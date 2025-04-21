package behavioral.strategy;

import java.util.Arrays;

public class MergeSort implements SortStrategy{

    @Override
    public void sort(int[] arr) {
        Arrays.sort(arr);
    }
}
