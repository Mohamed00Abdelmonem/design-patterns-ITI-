package library.proxy;

import library.core.BookInterface;
import library.core.User;
import library.models.EBook;

public class EBookProxy implements BookInterface {

    private final EBook eBook;
    private static final String ACCESS_DENIED_PREFIX = "[Access Denied]";
    private static final String PREMIUM_EBOOK_MESSAGE = "is a premium e-book. Upgrade your account to access it.";

    public EBookProxy(EBook eBook) {
        validateEBook(eBook);
        this.eBook = eBook;
    }

    @Override
    public void borrowBook(User user) {
        validateUser(user);
        
        if (user.isPremium()) {
            eBook.borrowBook(user);
        } else {
            System.out.println(String.format("%s \"%s\" %s",
                    ACCESS_DENIED_PREFIX,
                    eBook.getTitle(),
                    PREMIUM_EBOOK_MESSAGE));
        }
    }

    @Override
    public void returnBook() {
        eBook.returnBook();
    }

    @Override
    public String getTitle() {
        return eBook.getTitle();
    }

    @Override
    public boolean isAvailable() {
        return eBook.isAvailable();
    }
    
    private void validateEBook(EBook eBook) {
        if (eBook == null) {
            throw new IllegalArgumentException("EBook cannot be null");
        }
    }
    
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}
