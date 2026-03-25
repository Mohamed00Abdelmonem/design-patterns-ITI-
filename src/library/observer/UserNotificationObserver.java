package library.observer;

import library.core.User;

public class UserNotificationObserver implements BookObserver {

    private final User user;

    public UserNotificationObserver(User user) {
        this.user = user;
    }

    @Override
    public void onBookAvailable(String bookTitle) {
        System.out.println("[Notification] Hey " + user.getName()
                + "! The book \"" + bookTitle + "\" is now available.");
    }
}
