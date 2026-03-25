package library.chain;

public abstract class BorrowHandler {

    protected BorrowHandler nextHandler;

    public BorrowHandler setNext(BorrowHandler next) {
        this.nextHandler = next;
        return next;          // fluent API: librarian.setNext(manager).setNext(director)
    }

    public abstract void handle(BorrowRequest request);
}
