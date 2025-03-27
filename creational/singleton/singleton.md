## SingleTon Design Pattern

### Info
- It ensures only once object can be created of a class.
- It is ideal for class that requires centralized control like
    - Managing database operation,
    - Manaing configuration settings.

### Advantages
- Can avoid accidental changes. Like if we have multiple instance modifying the same database, there may have inconsistency.
- Unneccessary object creation are not needed.


### Disadvantages
- Can make unit testing difficult as it is now a part of global state.

## Implementation (Not thread safe)
- Okay for most of the cases.
- Code:
- `ImageLoader.java`
    ```java
    package singleton;

    public class ImageLoader {
        private static ImageLoader instance;

        private ImageLoader() {}

        public static ImageLoader getInstance() {
            if (instance == null) {
                instance = new ImageLoader();
            }
            return instance;
        }
        
    }
    ```

## Implementation (Thread safe)
- Code
    ```java
    package singleton;

    public class ImageLoader {
        private static ImageLoader instance;

        private ImageLoader() {}

        public static ImageLoader getInstance() {
            if (instance == null) {
                synchronized (ImageLoader.class) {
                    if (instance == null) {
                        instance = new ImageLoader();
                    }
                }
            }
            return instance;
        }

        public void loadImage(String url){
            System.out.println("Image loaded");
        }

    }
    ```
- We can also make the method `syncronized`, but if there are many concurrent calls, then it may be little slower than the above one.
