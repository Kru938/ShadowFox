package models;

import java.time.LocalDateTime;

public class Loan {
    private int id;
    private int userId;
    private int bookId;
    private LocalDateTime loanedAt;
    private LocalDateTime returnedAt;

    public Loan() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public LocalDateTime getLoanedAt() { return loanedAt; }
    public void setLoanedAt(LocalDateTime loanedAt) { this.loanedAt = loanedAt; }
    public LocalDateTime getReturnedAt() { return returnedAt; }
    public void setReturnedAt(LocalDateTime returnedAt) { this.returnedAt = returnedAt; }
}