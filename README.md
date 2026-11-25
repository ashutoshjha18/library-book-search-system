# LINKS :

project report: https://drive.google.com/file/d/1vvUjhQxdUJxx2vn9ciWYNnKvfSSWcHKL/view?usp=drivesdk

project presentation: https://drive.google.com/file/d/1Je3jh04Czz1t7I_oHMqAKDWaYn-w2JWX/view?usp=drivesdk


# 📚 Library Book Search System

A lightweight, console-based Library Management and Book Search System built in **Java**. Designed to demonstrate core Data Structures and Algorithms (DSA) in action, this application manages a persistent catalog of books, maintains sorted records automatically, and provides efficient lookup capabilities using **Binary Search** and **Linear Search**.

---

## ✨ Key Features

- **Persistent File Storage:** Automatically loads book records from `data/books.txt` at startup and saves updates back to disk upon exit using a clean `Title | Author` format.
- **Automatic Alphabetical Sorting:** Keeps the library collection sorted by book title (case-insensitive) whenever records are loaded or added.
- **Fast Title Lookup (Binary Search):** Locates exact book titles in logarithmic time ($O(\log n)$) over the sorted catalog.
- **Flexible Author Search (Linear Search):** Supports partial, case-insensitive substring matching (e.g., searching `"Orwell"` finds all titles by `"George Orwell"`).
- **Input Validation:** Guards against empty titles or blank author names to maintain catalog integrity.
- **Zero External Dependencies:** Built purely with standard Java SE libraries (`java.io`, `java.nio`, `java.util`).

---

## ⚡ Algorithmic Complexity

| Operation | Algorithm / Strategy | Time Complexity | Space Complexity |
| :--- | :--- | :---: | :---: |
| **Search by Exact Title** | Iterative Binary Search | $O(\log n)$ | $O(1)$ |
| **Search by Author (Partial)** | Linear Scan | $O(n)$ | $O(k)$* |
| **Add Book & Maintain Order** | Append + Case-Insensitive Sort | $O(n \log n)$ | $O(1)$ |
| **Load / Save Catalog** | Sequential UTF-8 File I/O | $O(n)$ | $O(n)$ |

*\*Where $n$ is the total number of books in the catalog and $k$ is the number of matching results returned.*

---

## 📂 Project Structure

```text
library-book_search_system/
│
├── data/
│   └── books.txt               # Persistent text database storing "Title | Author" pairs
│
├── src/
│   ├── main.java               # Main entry point containing the interactive console menu
│   ├── book_manager.java       # Handles adding books, sorting, and UTF-8 file I/O
│   └── search_utils.java       # Custom implementations of binary and linear search
│
├── README.md                   # Project documentation and setup instructions               
