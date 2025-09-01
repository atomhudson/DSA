import fs from "fs";
import path from "path";
import { GoogleGenerativeAI } from "@google/generative-ai";

const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);

// Only process changed .java files from GitHub Action
const files = process.env.FILES
  ? process.env.FILES.split(/\s+/).filter((f) => f.endsWith(".java"))
  : [];

async function generateDocs() {
  if (files.length === 0) {
    console.log("⚠️ No changed Java files to process.");
    return;
  }

  for (const filePath of files) {
    const code = fs.readFileSync(filePath, "utf8");

    const prompt = `
You are a technical writer. Explain this Java code in detail, step by step,
including its workflow, important methods, and use cases.
Return the output in Markdown format.

File: ${path.basename(filePath)}
Code:
${code}
`;

    try {
      const model = genAI.getGenerativeModel({
        model: "gemini-1.5-flash-latest", // or gemini-1.5-pro-latest
      });
      const result = await model.generateContent(prompt);
      const text = result.response.text();

      // Save inside blog/content/posts, keeping subfolder structure
      const relPath = filePath.replace(".java", ".md");
      const outPath = path.join(process.env.BLOG_PATH, relPath);

      fs.mkdirSync(path.dirname(outPath), { recursive: true });
      fs.writeFileSync(outPath, text, "utf8");

      console.log(`✅ Generated docs for ${filePath} -> ${outPath}`);
    } catch (err) {
      console.error(`❌ Failed for ${filePath}:`, err.message);
    }
  }
}

generateDocs();
