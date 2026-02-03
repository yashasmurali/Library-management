import java.util.Scanner;


class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.author = "Unknown";
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    public void displayBookDetails() {
        System.out.println("ID: " + bookId +
                " | Title: " + title +
                " | Author: " + author +
                " | Status: " + (isAvailable ? "Available" : "Borrowed"));
    }
}

public class Library {
    static Book[] books = new Book[10];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook(sc);
                case 2 -> displayBooks();
                case 3 -> searchBook(sc);
                case 4 -> borrowBook(sc);
                case 5 -> returnBook(sc);
                case 6 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addBook(Scanner sc) {
        if (count >= books.length) {
            System.out.println("Library is full.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books[count++] = new Book(id, title, author);
        System.out.println("Book added successfully.");
    }

    static void displayBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            books[i].displayBookDetails();
        }
    }

    static void searchBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].displayBookDetails();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void borrowBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
