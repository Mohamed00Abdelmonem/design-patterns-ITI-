package library.chain;

public class DirectorHandler extends BorrowHandler {
    @Override
    public void handle(BorrowRequest request) {
        if (request.getDays() >= 15) {
            System.out.println("[Director] Approved \"" + request.getBookTitle()
                    + "\" for " + request.getUser().getName()
                    + " — " + request.getDays() + " days.");
        } else {
            System.out.println("[Director] Request denied.");
        }
    }
}