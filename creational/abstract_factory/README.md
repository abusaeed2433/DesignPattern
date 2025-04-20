### Introduction
- The Abstract Factory design pattern is used when we need to create **families of related objects** without specifying their concrete classes.
- It is considered as another layer of abstraction over factory pattern.
- It works around a super-factory which creates other factories.

### Example Scenario
- Let's say, we are building a **UI toolkit** that supports two themes: **Light** and **Dark**.
- Each theme has its own set of UI components, such as **Button** and **ProgressBar**.


### Implementation of the example
- Product interfaces
    ```java
    public interface Button{
        void onClick();
    }
    
    public interface ProgressBar{
        void showProgress();
    }
    ```
- Concrete products for each theme. 
- Light theme:
    ```java
    public class LightButton implements Button{
        @Override
        public void onClick() {
            System.out.println("Light button clicked");
        }
    }

    public class LightProgressBar implements ProgressBar{
        @Override
        public void showProgress() {
            System.out.println("Light progress bar");
        }
    }
    ```
- Dark theme:
    ```java
    public class DarkButton implements Button{
        @Override
        public void onClick() {
            System.out.println("Dark button clicked");
        }
    }
    public class DarkProgressBar implements ProgressBar{
        @Override
        public void showProgress() {
            System.out.println("Dark progress bar");
        }
    }
    ```
- Abstract factory
    ```java
    public interface ToolkitFactory{
        Button createButton();
        ProgressBar createProgressBar();
    }
    ```
- Concrete factories for each theme
    ```java
    public class LightToolkitFactory implements ToolkitFactory{
        @Override
        public Button createButton() {
            return new LightButton();
        }
        @Override
        public ProgressBar createProgressBar() {
            return new LightProgressBar();
        }
    }

    public class DarkToolkitFactory implements ToolkitFactory{
        @Override
        public Button createButton() {
            return new DarkButton();
        }
        @Override
        public ProgressBar createProgressBar() {
            return new DarkProgressBar();
        }
    }
    ```

And it's done.

### Example code
```java
public class Main {
    
    public static void main(String[] args) {
        // Create a light-themed UI

        // light theme
        {
            ToolkitFactory factory = new LightToolkitFactory();
            Button button = factory.createButton();
            ProgressBar progressBar = factory.createProgressBar();
            button.onClick();
            progressBar.showProgress();
        }

        // dark theme
        {
            ToolkitFactory factory = new DarkToolkitFactory();
            Button button = factory.createButton();
            ProgressBar progressBar = factory.createProgressBar();
            button.onClick();
            progressBar.showProgress();
        }
    }

}
```
### Output
```none
Light button clicked
Light progress bar
Dark button clicked
Dark progress bar
```

### Definition again
- The Abstract Factory pattern allows us to create families of related objects (Button, ProgressBar) without specifying their concrete classes (LightButton, DarkButton, LightProgressBar, DarkProgressBar).
- It works around a super-factory (ToolkitFactory) which creates other factories (LightToolkitFactory, DarkToolkitFactory).

Let's learn together!!!
