package behavioral.strategy;

import java.util.Arrays;

public class QuickSort implements SortStrategy{

    @Override
    public void sort(int[] arr) {
        Arrays.sort(arr); // Using default sort for simplicity
    }
    
}
