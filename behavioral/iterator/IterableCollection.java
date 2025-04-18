package behavioral.iterator;

public interface IterableCollection<T> {
    
    Iterator<T> createIterator();

}
