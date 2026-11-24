# 📚 Library Book Search System

A lightweight, console-based Library Management and Book Search System built in **Java**. Designed to demonstrate core Data Structures and Algorithms (DSA) in action, this application manages a persistent catalog of books, keeps records automatically sorted, and provides fast search capabilities using **Binary Search** and **Linear Search**.

---

## ✨ Key Features

* **Persistent File Storage:** Automatically loads book records from `data/books.txt` at startup and saves updates back to disk upon exit (`Title | Author` format).
* **Automatic Alphabetical Sorting:** Keeps the library collection sorted by book title (case-insensitive) whenever records are loaded or added.
* **Fast Title Lookup (Binary Search):** Locates exact book titles in logarithmic time.
* **Flexible Author Search (Linear Search):** Supports partial, case-insensitive matching (e.g., searching `"Orwell"` finds all books by `"George Orwell"`)[cite: 1, 4].
* **Input Validation:** Prevents empty titles or blank author names from corrupting the catalog[cite: 2].
* **Zero External Dependencies:** Built purely with standard Java SE libraries (`java.io`, `java.nio`, `java.util`).

---

## 📂 Project Structure

```text
library_Book_search_system/
│
├── data/
│   └── books.txt               # Persistent text database storing "Title | Author" pairs
│
├── src/
│   ├── main.java               # Main entry point containing the interactive console menu[cite: 3]
│   ├── book_manager.java       # Handles adding books, sorting, and UTF-8 file I/O[cite: 2]
│   └── search_utils.java       # Custom implementations of binary and linear search
│
├── README.md                   # Project documentation and setup instructions
└── .gitignore                  # Ignores compiled .class files, build folders, and IDE configs