import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<Integer, IssueRecord> issuedBooks = new HashMap<>();

    private Scanner sc;

    public Library(Scanner sc) {
        this.sc = sc;
    }

    // 🔹 Safe integer input
    private int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // 🔹 Add Book
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = getIntInput();
        sc.nextLine();

        for (Book b : books) {
            if (b.getId() == id) {
                System.out.println("Book ID exists!");
                return;
            }
        }

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book Added!");
    }

    // 🔹 Add User
    public void addUser() {
        System.out.print("Enter User ID: ");
        int id = getIntInput();
        sc.nextLine();

        for (User u : users) {
            if (u.getId() == id) {
                System.out.println("User ID exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        users.add(new User(id, name));
        System.out.println("User Registered!");
    }

    // 🔹 Search Book
    public void searchBook() {
        System.out.print("Enter title: ");
        sc.nextLine();
        String input = sc.nextLine().replaceAll("\\s+", "").toLowerCase();

        for (Book b : books) {
            String title = b.getTitle().replaceAll("\\s+", "").toLowerCase();
            if (title.equals(input)) {
                System.out.println("Found: " + b.getTitle() + " by " + b.getAuthor());
                return;
            }
        }
        System.out.println("Not found!");
    }

    // 🔹 Issue Book
    public void issueBook() {
        System.out.print("Enter Book ID: ");
        int bookId = getIntInput();

        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        Book book = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                book = b;
                break;
            }
        }

        if (book == null || book.isIssued()) {
            System.out.println("Book not available!");
            return;
        }

        boolean userExists = false;
        for (User u : users) {
            if (u.getId() == userId) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            System.out.println("User not found!");
            return;
        }

        book.setIssued(true);
        issuedBooks.put(bookId, new IssueRecord(userId, LocalDate.now()));

        System.out.println("Book Issued!");
    }

    // 🔹 Return Book
    public void returnBook() {
        System.out.print("Enter Book ID: ");
        int bookId = getIntInput();

        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        if (!issuedBooks.containsKey(bookId)) {
            System.out.println("Book not issued!");
            return;
        }

        IssueRecord record = issuedBooks.get(bookId);

        if (record.getUserId() != userId) {
            System.out.println("This user didn't issue the book!");
            return;
        }

        LocalDate issueDate = record.getIssueDate();
        LocalDate returnDate = LocalDate.now();

        long days = ChronoUnit.DAYS.between(issueDate, returnDate);

        int fine = 0;
        if (days > 7) {
            fine = (int)(days - 7) * 5;
        }

        issuedBooks.remove(bookId);

        for (Book b : books) {
            if (b.getId() == bookId) {
                b.setIssued(false);
            }
        }

        System.out.println("Returned!");
        System.out.println("Days: " + days);
        System.out.println("Fine: " + fine);
    }
}