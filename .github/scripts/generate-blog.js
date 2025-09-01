import fs from "fs";
import path from "path";
import { GoogleGenerativeAI } from "@google/generative-ai";

const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);

// 1. Read changed Java files
const files = fs
  .readdirSync("./src/main/java/com/atomhudson/DSA/Data_Structures/")
  .filter((f) => f.endsWith(".java"));

// 2. Generate markdown docs for each file
async function generateDocs() {
  for (const file of files) {
    const filePath = path.join(
      "./src/main/java/com/atomhudson/DSA/Data_Structures/",
      file
    );
    const code = fs.readFileSync(filePath, "utf8");

    const prompt = `
You are a technical writer. Explain this Java code in detail, step by step,
including its workflow, important methods, and use cases.
Return the output in Markdown format.

File: ${file}
Code:
${code}
`;

    try {
      const model = genAI.getGenerativeModel({ model: "gemini-pro" });
      const result = await model.generateContent(prompt);
      const text = result.response.text();

      const outFile = `./docs/${file.replace(".java", ".md")}`;
      fs.writeFileSync(outFile, text, "utf8");
      console.log(`✅ Generated docs for ${file}`);
    } catch (err) {
      console.error(`❌ Failed for ${file}:`, err.message);
    }
  }
}

generateDocs();
