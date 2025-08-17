import java.util.Scanner;
import models.User;
import services.BookService;
import services.LoanService;
import services.UserService;
import utils.DatabaseManager;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final BookService bookService = new BookService();
    private static final LoanService loanService = new LoanService();

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> { System.out.println("Goodbye!"); System.exit(0); }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (userService.registerUser(name, email, password)) {
            System.out.println("✅ Registration successful!");
        } else {
            System.out.println("❌ Registration failed!");
        }
    }

    private static void loginUser() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userService.login(email, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getName() + "!");
            showUserMenu(user);
        } else {
            System.out.println("❌ Login failed!");
        }
    }

    private static void showUserMenu(User user) {
        while (true) {
            System.out.println("\n===== User Menu =====");
            System.out.println("1. List Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> bookService.listBooks();
                case 2 -> borrowBook(user);
                case 3 -> returnBook(user);
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void borrowBook(User user) {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        if (loanService.borrowBook(user.getId(), bookId)) {
            System.out.println("✅ Book borrowed successfully!");
        } else {
            System.out.println("❌ Failed to borrow book!");
        }
    }

    private static void returnBook(User user) {
        System.out.print("Enter Loan ID: ");
        int loanId = scanner.nextInt();
        scanner.nextLine();

        if (loanService.returnBook(loanId)) {
            System.out.println("✅ Book returned successfully!");
        } else {
            System.out.println("❌ Failed to return book!");
        }
    }
}