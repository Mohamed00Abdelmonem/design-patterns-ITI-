package library.models;

import library.core.Book;
import library.core.User;

public class PhysicalBook extends Book {
    
    private static final String PHYSICAL_BOOK_PREFIX = "Physical Book";
    private static final String BORROWED_BY_MESSAGE = "has been borrowed by";
    private static final String PERIOD_SUFFIX = ".";

    public PhysicalBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        validateUser(user);
        System.out.println(String.format("%s: %s %s %s%s",
                PHYSICAL_BOOK_PREFIX,
                getTitle(),
                BORROWED_BY_MESSAGE,
                user.getName(),
                PERIOD_SUFFIX));
    }
    
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}
