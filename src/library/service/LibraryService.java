package library.service;

import library.core.BookInterface;
import library.core.User;
import library.observer.BookObserver;

import java.util.ArrayList;
import java.util.List;


public class LibraryService {

    // ── Singleton ──────────────────────────────────────────────────────────────
    private static LibraryService instance;

    private final List<BookInterface> books = new ArrayList<>();
    private final List<BookObserver> observers = new ArrayList<>();   // Observer list

    private LibraryService() { }   // private → no outside instantiation

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    // ── Book management ────────────────────────────────────────────────────────
    public void addBook(BookInterface book) {
        books.add(book);
    }

    public BookInterface findBook(String title) {
        for (BookInterface book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title, User user) {
        BookInterface book = findBook(title);
        if (book != null) {
            book.borrowBook(user);
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    public void returnBook(String title) {
        BookInterface book = findBook(title);
        if (book != null) {
            book.returnBook();
            notifyObservers(title);   // ← notify all watchers (Req 8)
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    // ── Observer management ────────────────────────────────────────────────────
    public void subscribe(BookObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(BookObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String bookTitle) {
        for (BookObserver observer : observers) {
            observer.onBookAvailable(bookTitle);
        }
    }
}