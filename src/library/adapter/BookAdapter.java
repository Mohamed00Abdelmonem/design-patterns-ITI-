package library.adapter;

import library.core.BookInterface;
import library.core.User;

public class BookAdapter implements BookInterface {

    private final ExternalBookData externalBookData;
    private boolean isAvailable;

    public BookAdapter(ExternalBookData externalBookData) {
        if (externalBookData == null) {
            throw new IllegalArgumentException("External book data cannot be null");
        }
        this.externalBookData = externalBookData;
        this.isAvailable = externalBookData.isBorrowable();
    }

    @Override
    public String getTitle() {
        return String.format("%s by %s (%d)",
                externalBookData.getBookTitle(),
                externalBookData.getAuthorName(),
                externalBookData.getPublicationYear());
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void borrowBook(User user) {
        validateUser(user);
        
        if (isAvailable) {
            isAvailable = false;
            System.out.println("[Adapted] " + user.getName() + " borrowed external book: " + getTitle());
        } else {
            System.out.println("[Adapted] " + getTitle() + " is not borrowable.");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println("[Adapted] " + getTitle() + " has been returned.");
    }
    
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}