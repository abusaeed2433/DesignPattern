
### Introduction
Strategy is a **behavioral** design pattern that lets us define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

### Example Scenario
- Let's say we have a list of numbers and we want to sort it using user preferred sorting algo.
- If we use traditional approach, we create a single class and put all codes inside it. But if we keep adding more algo, the class size become large, and harder to maintain.

To solve this issue, we create separate class for each of the sorting algorithm. We then pass reference to the sorting algo and use it.

### Implementation
1. Strategy interface
    ```java
    package behavioral.strategy;

    public interface SortStrategy {
        void sort(int[] arr);
    }
    ```
2. Few concrete strategies
    1. BubbleSort
        ```java
        package behavioral.strategy;

        import java.util.Arrays;

        public class BubbleSort implements SortStrategy{

            @Override
            public void sort(int[] arr) {
                Arrays.sort(arr); // Using default sort for simplicity        
            }
            
        }
        ```
    2. QuickSort
        ```java
        package behavioral.strategy;

        import java.util.Arrays;

        public class QuickSort implements SortStrategy{

            @Override
            public void sort(int[] arr) {
                Arrays.sort(arr); // Using default sort for simplicity
            }
            
        }
        ```
    3. MergeSort
        ```java
        package behavioral.strategy;

        import java.util.Arrays;

        public class MergeSort implements SortStrategy{

            @Override
            public void sort(int[] arr) {
                Arrays.sort(arr);
            }
        }
        ```
3. Context class
    ```java
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
    ```

And it's done.

### Example usage
```java
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
```

### Output
```
Sorting using QuickSort:
[1, 2, 5, 5, 6, 9]
Sorting using MergeSort:
[1, 2, 5, 5, 6, 9]
```

### Definition again
Strategy is a behavioral design pattern that lets us define a family of algorithms, put each of them into a separate class (`BubbleSort`, `QuickSort`, `MergeSort`), and make their objects interchangeable(though the strategy interface `SortStrategy`).

Let's learn together!!!
