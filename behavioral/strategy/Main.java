package behavioral.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        SortContext context = new SortContext();
        
        {
            int[] arr = {5, 2, 9, 1, 5, 6};
            
            System.out.println("Sorting using QuickSort:");
            context.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
        
        {
            int[] arr = {5, 2, 9, 1, 5, 6};
            context.setStrategy(new MergeSort());
            System.out.println("Sorting using MergeSort:");
            context.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
        
    }

    
}
