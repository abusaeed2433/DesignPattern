
### Introduction
Iterator is a **behavioral** design pattern that lets us traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

### Example Scenario
Let's say we have a library with a collection of books. We want to go through each book one by one, but we don't want the users of the library to know how the books are stored internally(array, list, etc.).

### Implementation
1. Book class
```java
package behavioral.iterator;

public class Book {
    public String title;

    public Book(String title) {
        this.title = title;
    }
}
```

2. Generic iterator interface
```java
package behavioral.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

3. Concrete iterator implementing Iterator interface.
```java
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
```
4. Iterable collection for creating iterator at a class
```java
package behavioral.iterator;

public interface IterableCollection<T> {
    
    Iterator<T> createIterator();

}
```

5. Actual concrete collection implementing the `IterableCollection` interface.
```java
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
```

And it's done.

### Example usage
```java
package behavioral.iterator;

public class Main {
    
    public static void main(String[] args) {
        LibraryCollection library = new LibraryCollection();
        library.addBook(new Book("The Catcher in the Rye"));
        library.addBook(new Book("To Kill a Mockingbird"));
        library.addBook(new Book("1984"));
        
        Iterator<Book> bookIterator = library.createIterator();
        library.addBook(new Book("1985"));
        
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.title);
        }
        System.out.println("--------------------------");
        bookIterator = library.createIterator();
        while( bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.title);
        }
    }

}
```

### Output
```
The Catcher in the Rye
To Kill a Mockingbird
1984
--------------------------
The Catcher in the Rye
To Kill a Mockingbird
1984
1985
```


### Definition again
Iterator is a behavioral design pattern that lets us traverse elements of a collection(`LibraryCollection`) without exposing its underlying representation(List<Books>).

Let's learn together!!!
