package services;

import java.sql.*;
import java.time.LocalDateTime;
import utils.DatabaseManager;

public class LoanService {
    public boolean borrowBook(int userId, int bookId) {
        String checkAvailability = "SELECT available_copies FROM books WHERE id = ?";
        String updateBook = "UPDATE books SET available_copies = available_copies - 1 WHERE id = ?";
        String insertLoan = "INSERT INTO loans(user_id, book_id, loaned_at) VALUES(?,?,?)";

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement(checkAvailability)) {
                pstmt.setInt(1, bookId);
                ResultSet rs = pstmt.executeQuery();
                if (!rs.next() || rs.getInt(1) <= 0) {
                    System.err.println("Book not available!");
                    conn.rollback();
                    return false;
                }
            }

            try (PreparedStatement pstmt = conn.prepareStatement(updateBook)) {
                pstmt.setInt(1, bookId);
                pstmt.executeUpdate();
            }

            try (PreparedStatement pstmt = conn.prepareStatement(insertLoan)) {
                pstmt.setInt(1, userId);
                pstmt.setInt(2, bookId);
                pstmt.setString(3, LocalDateTime.now().toString());
                pstmt.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            System.err.println("Borrow failed: " + e.getMessage());
            return false;
        }
    }

    public boolean returnBook(int loanId) {
        String getLoan = "SELECT book_id FROM loans WHERE id = ?";
        String updateLoan = "UPDATE loans SET returned_at = ? WHERE id = ?";
        String updateBook = "UPDATE books SET available_copies = available_copies + 1 WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);

            int bookId;
            try (PreparedStatement pstmt = conn.prepareStatement(getLoan)) {
                pstmt.setInt(1, loanId);
                ResultSet rs = pstmt.executeQuery();
                if (!rs.next()) {
                    System.err.println("Loan not found!");
                    conn.rollback();
                    return false;
                }
                bookId = rs.getInt(1);
            }

            try (PreparedStatement pstmt = conn.prepareStatement(updateLoan)) {
                pstmt.setString(1, LocalDateTime.now().toString());
                pstmt.setInt(2, loanId);
                pstmt.executeUpdate();
            }

            try (PreparedStatement pstmt = conn.prepareStatement(updateBook)) {
                pstmt.setInt(1, bookId);
                pstmt.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            System.err.println("Return failed: " + e.getMessage());
            return false;
        }
    }
}