package library.chain;

import library.core.User;

public class BorrowRequest {
    private final User user;
    private final String bookTitle;
    private final int days;

    public BorrowRequest(User user, String bookTitle, int days) {
        this.user = user;
        this.bookTitle = bookTitle;
        this.days = days;
    }

    public User getUser()        { return user; }
    public String getBookTitle() { return bookTitle; }
    public int getDays()         { return days; }
}
