package services;

import models.Book;
import utils.DatabaseManager;
import java.sql.*;
import java.time.LocalDateTime;

public class BookService {
    public boolean addBook(String title, String author, String isbn, int copies) {
        String sql = "INSERT INTO books(title, author, isbn, total_copies, available_copies, created_at) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, isbn);
            pstmt.setInt(4, copies);
            pstmt.setInt(5, copies);
            pstmt.setString(6, LocalDateTime.now().toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to add book: " + e.getMessage());
            return false;
        }
    }

    public void listBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n=== Available Books ===");
            System.out.printf("%-5s %-30s %-20s %-15s\n", "ID", "Title", "Author", "Available");
            System.out.println("--------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-30s %-20s %d/%d\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("available_copies"),
                        rs.getInt("total_copies"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to list books: " + e.getMessage());
        }
    }
}