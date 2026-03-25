package library.chain;

// ── Manager: approves requests up to 14 days ─────────────────────────────────
public class ManagerHandler extends BorrowHandler {
    @Override
    public void handle(BorrowRequest request) {
        if (request.getDays() <= 14) {
            System.out.println("[Manager] Approved \"" + request.getBookTitle()
                    + "\" for " + request.getUser().getName()
                    + " — " + request.getDays() + " days.");
        } else if (nextHandler != null) {
            System.out.println("[Manager] " + request.getDays()
                    + " days exceeds my authority. Escalating to Director...");
            nextHandler.handle(request);
        } else {
            System.out.println("[Manager] Request denied — no higher authority available.");
        }
    }
}
