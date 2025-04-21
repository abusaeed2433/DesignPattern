package behavioral.strategy;

public class SortContext {
    
    private SortStrategy strategy;

    public SortContext() {
        this.strategy = new QuickSort();
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr) {
        strategy.sort(arr);
    }

}
