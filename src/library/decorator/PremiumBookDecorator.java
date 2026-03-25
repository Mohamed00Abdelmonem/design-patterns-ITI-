package library.decorator;

import library.core.BookInterface;
import library.core.User;

public class PremiumBookDecorator implements BookInterface {

    private final BookInterface wrappedBook;
    private static final int EXTRA_DAYS = 10;
    private static final String PREMIUM_MESSAGE_PREFIX = "[Premium]";

    public PremiumBookDecorator(BookInterface book) {
        validateBook(book);
        this.wrappedBook = book;
    }

    @Override
    public void borrowBook(User user) {
        validateUser(user);
        wrappedBook.borrowBook(user);
        System.out.println(String.format("  %s %s %s %d %s: %s",
                PREMIUM_MESSAGE_PREFIX,
                user.getName(),
                "gets",
                EXTRA_DAYS,
                "extra borrowing days for",
                wrappedBook.getTitle()));
    }

    @Override
    public void returnBook() {
        wrappedBook.returnBook();
    }

    @Override
    public String getTitle() {
        return wrappedBook.getTitle();
    }

    @Override
    public boolean isAvailable() {
        return wrappedBook.isAvailable();
    }
    
    private void validateBook(BookInterface book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
    }
    
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}