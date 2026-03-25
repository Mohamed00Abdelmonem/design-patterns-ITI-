package library.chain;

public class LibrarianHandler extends BorrowHandler {
    @Override
    public void handle(BorrowRequest request) {
        if (request.getDays() <= 7) {
            System.out.println("[Librarian] Approved \"" + request.getBookTitle()
                    + "\" for " + request.getUser().getName()
                    + " — " + request.getDays() + " days.");
        } else if (nextHandler != null) {
            System.out.println("[Librarian] " + request.getDays()
                    + " days exceeds my authority. Escalating to Manager...");
            nextHandler.handle(request);
        } else {
            System.out.println("[Librarian] Request denied — no higher authority available.");
        }
    }
}