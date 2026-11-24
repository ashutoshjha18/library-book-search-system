import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        book_manager library = new book_manager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Search Books by Author");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();

                if (library.addBook(title, author)) {
                    System.out.println("Book added successfully!");
                }

            } else if (choice.equals("2")) {
                library.displayBooks();

            } else if (choice.equals("3")) {
                System.out.print("Enter book title to search: ");
                String title = scanner.nextLine();
                library.searchByTitleInteractive(title);

            } else if (choice.equals("4")) {
                System.out.print("Enter author name to search: ");
                String author = scanner.nextLine();
                library.searchByAuthorInteractive(author);

            } else if (choice.equals("5")) {
                library.saveBooks();
                System.out.println("Books saved successfully!");
                System.out.println("Thank you for using Library Management System.");
                break;

            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
