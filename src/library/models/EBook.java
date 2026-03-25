package library.models;

import library.core.Book;
import library.core.User;

public class EBook extends Book {
    
    private static final String EBOOK_PREFIX = "e-book";
    private static final String BORROWED_MESSAGE = "borrowed the";

    public EBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        validateUser(user);
        System.out.println(String.format("%s %s %s: %s",
                user.getName(),
                BORROWED_MESSAGE,
                EBOOK_PREFIX,
                getTitle()));
    }
    
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}
