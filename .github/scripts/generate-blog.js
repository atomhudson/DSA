import fs from "fs";
import path from "path";
import { GoogleGenerativeAI } from "@google/generative-ai";

const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);

// Debug: Log the raw FILES environment variable
console.log("Raw FILES env var:", JSON.stringify(process.env.FILES));

// Process changed .java files from GitHub Action
const files = process.env.FILES
  ? process.env.FILES
      .split('\n')                    // Split by newlines first
      .map(f => f.trim())             // Remove whitespace
      .filter(f => f && f.endsWith(".java")) // Filter for non-empty Java files
  : [];

console.log("Processed files array:", files);

async function generateDocs() {
  if (files.length === 0) {
    console.log("⚠️ No changed Java files to process.");
    console.log("FILES env var content:", process.env.FILES);
    return;
  }

  console.log(`📝 Processing ${files.length} Java file(s):`, files);

  for (const filePath of files) {
    console.log(`\n🔍 Processing: ${filePath}`);

    // Check if file exists
    if (!fs.existsSync(filePath)) {
      console.error(`❌ File not found: ${filePath}`);
      continue;
    }

    const code = fs.readFileSync(filePath, "utf8");
    console.log(`📖 Read ${code.length} characters from ${filePath}`);

    const prompt = `
You are a technical writer. Explain this Java code in detail, step by step,
including its workflow, important methods, and use cases.
Return the output in Markdown format with proper headers and code blocks.

File: ${path.basename(filePath)}
Path: ${filePath}

Code:
\`\`\`java
${code}
\`\`\`

Please provide:
1. A brief overview of what this code does
2. Detailed explanation of key methods and classes
3. Code workflow and logic flow
4. Use cases and examples
5. Any important notes or considerations
`;

    try {
      console.log(`🤖 Generating content with Gemini...`);

      const model = genAI.getGenerativeModel({
        model: "gemini-1.5-flash-latest",
      });

      const result = await model.generateContent(prompt);
      const text = result.response.text();

      console.log(`✅ Generated ${text.length} characters of documentation`);

      // Save inside blog/content/posts, keeping subfolder structure
      const relPath = filePath.replace(".java", ".md");
      const outPath = path.join(process.env.BLOG_PATH, relPath);

      console.log(`💾 Saving to: ${outPath}`);

      // Ensure directory exists
      fs.mkdirSync(path.dirname(outPath), { recursive: true });

      // Add frontmatter for blog
      const blogContent = `---
title: "${path.basename(filePath, '.java')} - Java Code Documentation"
date: ${new Date().toISOString()}
description: "Auto-generated documentation for ${filePath}"
tags: ["java", "code-documentation", "automated"]
---

# ${path.basename(filePath)} Documentation

${text}

---
*This documentation was automatically generated from the source code.*
`;

      fs.writeFileSync(outPath, blogContent, "utf8");
      console.log(`✅ Generated docs for ${filePath} -> ${outPath}`);

    } catch (err) {
      console.error(`❌ Failed for ${filePath}:`, err.message);
      console.error("Full error:", err);
    }
  }
}

// Add package.json type check
if (!fs.existsSync('package.json')) {
  console.log("Creating package.json with module type...");
  fs.writeFileSync('package.json', JSON.stringify({
    "name": "blog-generator",
    "version": "1.0.0",
    "type": "module"
  }, null, 2));
}

generateDocs().catch(console.error);