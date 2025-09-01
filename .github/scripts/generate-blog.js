import fs from "fs";
import path from "path";
import OpenAI from "openai";

const openai = new OpenAI({ apiKey: process.env.GEMINI_API_KEY });

// Root folder where your Java code lives
const SRC_DIR = "./src/main/java/com/atomhudson/DSA/Data_Structures";
const BLOG_PATH = process.env.BLOG_PATH || "./docs";

function getAllJavaFiles(dir) {
  let results = [];
  const list = fs.readdirSync(dir);

  list.forEach((file) => {
    const fullPath = path.join(dir, file);
    const stat = fs.statSync(fullPath);

    if (stat && stat.isDirectory()) {
      results = results.concat(getAllJavaFiles(fullPath));
    } else if (file.endsWith(".java")) {
      results.push(fullPath);
    }
  });

  return results;
}

async function run() {
  const files = getAllJavaFiles(SRC_DIR);
  console.log(`📂 Found ${files.length} Java files`);

  for (const file of files) {
    const code = fs.readFileSync(file, "utf-8");

    const response = await openai.chat.completions.create({
      model: "gemini-1.5-pro",
      messages: [
        { role: "system", content: "You are an AI that generates developer-friendly documentation in Markdown." },
        { role: "user", content: `Generate a detailed explanation of this Java class:\nFile: ${file}\nCode:\n${code}` }
      ]
    });

    const explanation = response.choices[0].message.content;
    const mdContent = `---
title: "${path.basename(file)}"
date: ${new Date().toISOString()}
---

## 📂 File: ${file}

${explanation}
`;

    const safeName = file.replace(/[\/\\]/g, "_").replace(".java", ".md");
    fs.writeFileSync(`${BLOG_PATH}/${safeName}`, mdContent);
    console.log(`✅ Generated: ${safeName}`);
  }
}

run().catch((err) => {
  console.error("❌ Error generating docs:", err);
  process.exit(1);
});
