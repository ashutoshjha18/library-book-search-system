import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class book_manager {

    private String filepath;
    private List<search_utils.Book> books;

    public book_manager() {
        this("data/books.txt");
    }

    public book_manager(String filepath) {
        this.filepath = filepath;
        this.books = new ArrayList<>();
        loadBooks();
    }

    /**
     * Loads data from the file at program startup.
     */
    public void loadBooks() {
        this.books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(this.filepath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.contains("|")) {
                    String[] parts = line.split("\\|", 2);
                    String title = parts[0].trim();
                    String author = parts[1].trim();

                    if (!title.isEmpty() && !author.isEmpty()) {
                        this.books.add(new search_utils.Book(title, author));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Books file not found. Starting with an empty library.");
        } catch (IOException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }

        sortBooks();
    }

    /**
     * Saves data back to the text file.
     */
    public void saveBooks() {
        File file = new File(this.filepath);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {

            for (search_utils.Book book : this.books) {
                writer.write(book.title + " | " + book.author);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books file: " + e.getMessage());
        }
    }

    /**
     * Keeps the list sorted alphabetically by title.
     */
    public void sortBooks() {
        this.books.sort(Comparator.comparing(book -> book.title.toLowerCase()));
    }

    /**
     * Adds a book and keeps the list sorted.
     */
    public boolean addBook(String title, String author) {
        title = title.trim();
        author = author.trim();

        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Error: Title and author cannot be blank!");
            return false;
        }

        search_utils.Book newBook = new search_utils.Book(title, author);
        this.books.add(newBook);
        sortBooks();

        return true;
    }

    /**
     * Displays all current books sorted by title.
     */
    public void displayBooks() {
        if (this.books.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }

        System.out.println("\n--- Library Books (Sorted by Title) ---");

        for (int i = 0; i < this.books.size(); i++) {
            search_utils.Book book = this.books.get(i);
            System.out.println((i + 1) + ". " + book.title + " | " + book.author);
        }

        System.out.println("----------------------------------------");
    }

    /**
     * Triggers binary search for a title.
     */
    public void searchByTitleInteractive(String title) {
        int index = search_utils.binarySearch(this.books, title);

        if (index != -1) {
            search_utils.Book book = this.books.get(index);
            System.out.println(
                "Found: " + book.title + " | " + book.author + " (position " + (index + 1) + ")"
            );
        } else {
            System.out.println("Book " + title + " not found.");
        }
    }

    /**
     * Triggers linear search for an author.
     */
    public void searchByAuthorInteractive(String authorQuery) {
        List<search_utils.SearchMatch> matches = search_utils.linearSearchAuthor(this.books, authorQuery);

        if (!matches.isEmpty()) {
            for (search_utils.SearchMatch match : matches) {
                System.out.println(
                    "Found: " + match.book.title + " | " + match.book.author + " (position " + (match.index + 1) + ")"
                );
            }
        } else {
            System.out.println("No books found for author matching '" + authorQuery + "'.");
        }
    }
}