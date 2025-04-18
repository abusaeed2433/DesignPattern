package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class LibraryCollection implements IterableCollection<Book>{

    private List<Book> bookList;

    public LibraryCollection() {
        this.bookList = new ArrayList<>();
    }
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(bookList);
    }
    
}
