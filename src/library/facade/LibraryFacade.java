package library.facade;

import library.chain.*;
import library.core.BookInterface;
import library.core.User;
import library.observer.UserNotificationObserver;
import library.service.LibraryService;

public class LibraryFacade {

    private final LibraryService libraryService;
    private final BorrowHandler borrowChain;

    public LibraryFacade() {
        this.libraryService = LibraryService.getInstance();

        // Build the chain: Librarian → Manager → Director
        BorrowHandler librarian = new LibrarianHandler();
        BorrowHandler manager   = new ManagerHandler();
        BorrowHandler director  = new DirectorHandler();
        librarian.setNext(manager).setNext(director);
        this.borrowChain = librarian;
    }

    /** Add any BookInterface (Book, Decorator, Proxy, Adapter) to the library. */
    public void addBook(BookInterface book) {
        libraryService.addBook(book);
    }

    /** Simple borrow — just needs title and user. */
    public void borrowBook(String title, User user) {
        libraryService.borrowBook(title, user);
    }

    /** Borrow with explicit day count — goes through the approval chain. */
    public void borrowBook(String title, User user, int days) {
        BorrowRequest request = new BorrowRequest(user, title, days);
        borrowChain.handle(request);
    }

    /** Return a book and automatically notify subscribed observers. */
    public void returnBook(String title) {
        libraryService.returnBook(title);
    }

    /** Register a user to be notified when any book becomes available. */
    public void subscribeForNotifications(User user) {
        libraryService.subscribe(new UserNotificationObserver(user));
    }
}