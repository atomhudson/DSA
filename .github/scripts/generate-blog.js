import fs from "fs";
import path from "path";
import { GoogleGenerativeAI } from "@google/generative-ai";

const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);

// Recursively collect all .java files
function getJavaFiles(dir) {
  let results = [];
  const list = fs.readdirSync(dir);

  list.forEach((file) => {
    const filePath = path.join(dir, file);
    const stat = fs.statSync(filePath);

    if (stat && stat.isDirectory()) {
      results = results.concat(getJavaFiles(filePath)); // recurse
    } else if (file.endsWith(".java")) {
      results.push(filePath);
    }
  });

  return results;
}

// Collect all Java files in repo root
const files = getJavaFiles("./");

// Generate docs for each file
async function generateDocs() {
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
      const model = genAI.getGenerativeModel({ model: "gemini-pro" });
      const result = await model.generateContent(prompt);
      const text = result.response.text();

      // Save docs in ./docs folder, preserving relative path
      const relPath = path.relative("./", filePath).replace(".java", ".md");
      const outPath = path.join("./docs", relPath);

      fs.mkdirSync(path.dirname(outPath), { recursive: true });
      fs.writeFileSync(outPath, text, "utf8");

      console.log(`✅ Generated docs for ${filePath}`);
    } catch (err) {
      console.error(`❌ Failed for ${filePath}:`, err.message);
    }
  }
}

generateDocs();
