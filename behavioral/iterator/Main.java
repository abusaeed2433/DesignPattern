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
