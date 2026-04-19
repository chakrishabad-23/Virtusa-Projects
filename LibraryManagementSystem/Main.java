import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library(sc);

        while (true) {
            System.out.println("\n1.Add Book 2.Add User 3.Search 4.Issue 5.Return 6.Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: lib.addBook(); break;
                case 2: lib.addUser(); break;
                case 3: lib.searchBook(); break;
                case 4: lib.issueBook(); break;
                case 5: lib.returnBook(); break;
                case 6: return;
                default: System.out.println("Invalid");
            }
        }
    }
}