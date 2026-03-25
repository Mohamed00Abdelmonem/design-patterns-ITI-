package library.adapter;

public class ExternalBookData {
    
    private final String bookTitle;
    private final boolean isBorrowable;
    private final String authorName;
    private final int publicationYear;

    public ExternalBookData(String bookTitle, boolean isBorrowable, String authorName, int publicationYear) {
        validateBookTitle(bookTitle);
        validateAuthorName(authorName);
        validatePublicationYear(publicationYear);
        
        this.bookTitle = bookTitle.trim();
        this.isBorrowable = isBorrowable;
        this.authorName = authorName.trim();
        this.publicationYear = publicationYear;
    }

    private void validateBookTitle(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty");
        }
    }

    private void validateAuthorName(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty");
        }
    }

    private void validatePublicationYear(int publicationYear) {
        if (publicationYear < 1000 || publicationYear > 2100) {
            throw new IllegalArgumentException("Publication year must be between 1000 and 2100");
        }
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public boolean isBorrowable() {
        return isBorrowable;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}