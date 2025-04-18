package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookIterator implements Iterator<Book> {

    private int index = 0;

    private final List<Book> bookList;

    public BookIterator(List<Book> bookList) {
        this.bookList = new ArrayList<>(bookList);
    }

    @Override
    public boolean hasNext() {
        return index < bookList.size();
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return bookList.get(index++);
        }
        return null;
    }
    
}
