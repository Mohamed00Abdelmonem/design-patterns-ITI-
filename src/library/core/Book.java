package library.core;

public class Book implements BookInterface {
    
    private static final String BOOK_NOT_AVAILABLE_MESSAGE = " is not available.";
    private static final String BOOK_RETURNED_MESSAGE = " has been returned.";
    private static final String BORROWED_MESSAGE = " borrowed: ";
    
    private final String title;
    private boolean isAvailable;

    public Book(String title) {
        validateTitle(title);
        this.title = title.trim();
        this.isAvailable = true;
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty");
        }
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void borrowBook(User user) {
        validateUser(user);
        
        if (isAvailable) {
            isAvailable = false;
            System.out.println(user.getName() + BORROWED_MESSAGE + title);
        } else {
            System.out.println(title + BOOK_NOT_AVAILABLE_MESSAGE);
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + BOOK_RETURNED_MESSAGE);
    }
    
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}