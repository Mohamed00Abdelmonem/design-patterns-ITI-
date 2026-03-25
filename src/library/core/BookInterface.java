package library.core;

public interface BookInterface {
    void borrowBook(User user);
    void returnBook();
    String getTitle();
    boolean isAvailable();
}
