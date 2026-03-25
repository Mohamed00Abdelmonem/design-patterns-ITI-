import library.adapter.BookAdapter;
import library.adapter.ExternalBookData;
import library.core.Book;
import library.core.BookInterface;
import library.core.User;
import library.decorator.PremiumBookDecorator;
import library.facade.LibraryFacade;
import library.factory.BookFactory;
import library.models.EBook;

/**
 * Demonstration class showcasing various design patterns in a library management system.
 * 
 * This class demonstrates the implementation of:
 * - Singleton Pattern (LibraryFacade)
 * - Factory Method Pattern (BookFactory)
 * - Decorator Pattern (PremiumBookDecorator)
 * - Proxy Pattern (EBookProxy)
 * - Adapter Pattern (BookAdapter)
 * - Observer Pattern (User notifications)
 * - Chain of Responsibility Pattern (Borrow approval chain)
 */
public class LibrarySystemDemo {

    public static void main(String[] args) {
        LibrarySystemDemo demo = new LibrarySystemDemo();
        demo.runLibrarySystemDemo();
    }

    /**
     * Executes the complete library system demonstration.
     */
    private void runLibrarySystemDemo() {
        printSystemHeader();

        // Initialize library system (Singleton)
        LibraryFacade libraryFacade = new LibraryFacade();

        // Create test users
        User premiumUser = new User("Ahmed", true);
        User regularUser = new User("Fatma", false);

        // Create books using Factory Method pattern
        BookInterface harryPotter = createBook(BookFactory.BookType.PHYSICAL, "Alf Leila wa Leila");
        BookInterface lotr = createBook(BookFactory.BookType.HISTORICAL, "Qasr El Nil");
        BookInterface designPatternsEbook = createBook(BookFactory.BookType.EBOOK, "Programming Patterns");

        // Apply Decorator pattern for premium features
        BookInterface premiumHarryPotter = new PremiumBookDecorator(harryPotter);

        // Apply Proxy pattern for access control
        BookInterface protectedEBook = new library.proxy.EBookProxy((EBook) designPatternsEbook);

        // Add books to library
        addBooksToLibrary(libraryFacade, premiumHarryPotter, lotr, protectedEBook);

        // Apply Adapter pattern for external book data
        addAdaptedBookToLibrary(libraryFacade);

        // Set up Observer pattern for notifications
        setupUserNotifications(libraryFacade, premiumUser, regularUser);

        // Demonstrate various patterns
        demonstrateDecoratorAndProxy(libraryFacade, premiumUser, regularUser);
        demonstrateAdapter(libraryFacade, regularUser);
        demonstrateObserver(libraryFacade);
        demonstrateChainOfResponsibility(libraryFacade, premiumUser, regularUser);
    }

    /**
     * Prints the system header.
     */
    private void printSystemHeader() {
        System.out.println("=== Library Management System ===");
        System.out.println("Demonstrating Design Patterns Implementation\n");
    }

    /**
     * Creates a book using the Factory Method pattern.
     */
    private BookInterface createBook(BookFactory.BookType bookType, String title) {
        return BookFactory.createBook(bookType, title);
    }

    /**
     * Adds multiple books to the library.
     */
    private void addBooksToLibrary(LibraryFacade libraryFacade, BookInterface... books) {
        for (BookInterface book : books) {
            libraryFacade.addBook(book);
        }
    }

    // Apply Adapter pattern for external book data
    private void addAdaptedBookToLibrary(LibraryFacade libraryFacade) {
        ExternalBookData externalBookData = new ExternalBookData("Clean Code", true, "Naguib Mahfouz", 1988);
        BookInterface adaptedBook = new BookAdapter(externalBookData);
        libraryFacade.addBook(adaptedBook);
    }

    /**
     * Sets up user notifications using the Observer pattern.
     */
    private void setupUserNotifications(LibraryFacade libraryFacade, User... users) {
        for (User user : users) {
            libraryFacade.subscribeForNotifications(user);
        }
    }

    /**
     * Demonstrates Decorator and Proxy patterns.
     */
    private void demonstrateDecoratorAndProxy(LibraryFacade libraryFacade, User premiumUser, User regularUser) {
        System.out.println("--- Demonstrating Decorator + Proxy Patterns ---");
        libraryFacade.borrowBook("Alf Leila wa Leila", premiumUser);
        libraryFacade.borrowBook("Programming Patterns", regularUser);
        libraryFacade.borrowBook("Programming Patterns", premiumUser);
        System.out.println();
    }

    /**
     * Demonstrates the Adapter pattern.
     */
    private void demonstrateAdapter(LibraryFacade libraryFacade, User regularUser) {
        System.out.println("--- Demonstrating Adapter Pattern ---");
        libraryFacade.borrowBook("Clean Code by Naguib Mahfouz (1988)", regularUser);
        System.out.println();
    }

    /**
     * Demonstrates the Observer pattern.
     */
    private void demonstrateObserver(LibraryFacade libraryFacade) {
        System.out.println("--- Demonstrating Observer Pattern (return triggers notification) ---");
        libraryFacade.returnBook("Alf Leila wa Leila");
        System.out.println();
    }

    /**
     * Demonstrates the Chain of Responsibility pattern.
     */
    private void demonstrateChainOfResponsibility(LibraryFacade libraryFacade, User premiumUser, User regularUser) {
        System.out.println("--- Demonstrating Chain of Responsibility Pattern ---");
        libraryFacade.borrowBook("Qasr El Nil", regularUser, 5);
        libraryFacade.borrowBook("Qasr El Nil", premiumUser, 10);
        libraryFacade.borrowBook("Qasr El Nil", premiumUser, 20);
    }
}
