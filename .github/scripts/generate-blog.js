import fs from "fs";
import OpenAI from "openai";

const openai = new OpenAI({ apiKey: process.env.GEMINI_API_KEY });

const files = process.env.FILES?.split("\n").filter(Boolean) || [];
const repo = process.env.GITHUB_REPO;
const sha = process.env.COMMIT_SHA;
const blogPath = process.env.BLOG_PATH;

for (const file of files) {
  const code = fs.readFileSync(file, "utf-8");

  const response = await openai.chat.completions.create({
    model: "gemini-1.5-pro",
    messages: [
      { role: "system", content: "You are an AI that generates developer-friendly documentation in Markdown." },
      { role: "user", content: `Generate a detailed explanation of this Java class:
File: ${file}
Code:\n${code}` }
    ]
  });

  const explanation = response.choices[0].message.content;

  const link = `https://github.com/${repo}/blob/${sha}/${file}`;

  const mdContent = `---
title: "${file}"
date: ${new Date().toISOString()}
---

## 📂 File: ${file}

🔗 [View on GitHub](${link})

---

${explanation}
`;

  const safeName = file.replace(/\//g, "_").replace(".java", ".md");
  fs.writeFileSync(`${blogPath}/${safeName}`, mdContent);
}
