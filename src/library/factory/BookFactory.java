package library.factory;

import library.core.Book;
import library.models.EBook;
import library.models.HistoricalBook;
import library.models.PhysicalBook;

public class BookFactory {

    public enum BookType {
        PHYSICAL, EBOOK, HISTORICAL
    }

    public static Book createBook(BookType type, String title) {
        switch (type) {
            case PHYSICAL:    return new PhysicalBook(title);
            case EBOOK:       return new EBook(title);
            case HISTORICAL:  return new HistoricalBook(title);
            default: throw new IllegalArgumentException("Unknown book type: " + type);
        }
    }
}