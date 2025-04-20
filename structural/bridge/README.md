
### Introduction
- It is a **structural** design pattern that allows us to **split a large class or a set of closely related classes** into two separate hierarchies — **abstraction** and **implementation** — which can be developed independently of each other.
- It decouples an abstraction from its implementation so that the two can vary independently.
- It prefers composition over inheritance.

### Example Scenario
- Let's say we have a `Shape` class with pair of subclasses: `Circle`, `Rectangle`.
- Now we want to add color, `Red` and `Blue`. 
- To achieve this, we need 4 classes like this:
    <p align="center">
    <img src="https://refactoring.guru/images/patterns/diagrams/bridge/problem-en-2x.png" alt="Taken from refactoring guru" height="200">
    </p>

- If we want to add more shape or color, it gets complicated only.

### Solution
- To solve the problem, we use composition instead of inheritance.
    <p align="center">
    <img src="https://refactoring.guru/images/patterns/diagrams/bridge/solution-en-2x.png" alt="Taken from refactoring guru" height="200">
    </p>

### Implementation
- Color interface(`Color`)
    ```java
    package structural.bridge;

    public interface Color {

        static final int UNIT_COST = 100;

        void setOpacity(float opacity);
        float getOpacity();

        String getColorCode();

        int getUnitCost();

    }
    ```
- Few concrete implementation of the `Color`:
- `RedColor`
    ```java
    package structural.bridge;

    public class RedColor implements Color {
        private static final String COLOR_CODE = "FF0000";

        private float opacity = 0.5f;

        @Override
        public void setOpacity(float opacity) {
            this.opacity = opacity;
        }

        @Override
        public float getOpacity() {
            return opacity;
        }

        @Override
        public String getColorCode() {
            return COLOR_CODE;
        }

        @Override
        public int getUnitCost() {
            return (int)(UNIT_COST * opacity);
        }
        
    }
    ```
- `BlueColor`
    ```java
    package structural.bridge;

    public class BlueColor implements Color {

        private static final String COLOR_CODE = "0000FF";

        private float opacity = 0.5f;

        @Override
        public void setOpacity(float opacity) {
            if(opacity < 0 || opacity > 1) return;

            this.opacity = opacity;
        }

        @Override
        public float getOpacity() {
            return opacity;
        }

        @Override
        public String getColorCode() {
            return COLOR_CODE;
        }

        @Override
        public int getUnitCost() {
            return (int)(UNIT_COST * opacity * 1.5);
        }
        
    }
    ```
- Shape interface
    ```java
    package structural.bridge;

    public interface Shape {

        public abstract void draw();

        public void increaseBrightness();

        public void decreaseBrightness();

        public abstract int getTotalCost();
    }
    ```
- Few concrete implementation of the `Shape`
- `Triangle`
    ```java
    package structural.bridge;

    public class Triangle implements Shape{
        private int a;
        private int b;
        private int c;
        private Color color;

        public Triangle(int a, int b, int c, Color color) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.color = color;
        }
        
        
        @Override
        public void increaseBrightness() {
            color.setOpacity(color.getOpacity() + .1f);
        }

        @Override
        public void decreaseBrightness() {
            color.setOpacity(color.getOpacity() - .1f);
        }



        @Override
        public void draw() {
            System.out.println("Drawing a triangle with sides " + a + ", " + b + ", " + c + " and color " + color.getColorCode());
        }

        @Override
        public int getTotalCost() {        
            int s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            return (int)(area * color.getUnitCost());
        }
        
    }
    ```
- `Rectangle`
    ```java
    package structural.bridge;

    public class Rectangle implements Shape{

        private int height;
        private int width;
        private Color color;

        public Rectangle(int height, int width, Color color) {
            this.height = height;
            this.width = width;
            this.color = color;
        }

        @Override
        public void draw() {
            System.out.println("Drawing a rectangle with height " + height + ", width " + width + " and color " + color.getColorCode());
        }

        @Override
        public void increaseBrightness() {
            color.setOpacity(color.getOpacity() + 0.2f);
        }

        @Override
        public void decreaseBrightness() {
            color.setOpacity(height - 0.2f);
        }

        @Override
        public int getTotalCost() {
            return (int)(height * width * color.getUnitCost());
        }
        
    }
    ```

### Example usages:
```java
package structural.bridge;

public class Main {

    public static void main(String[] args){
        Color blueColor = new BlueColor();
        Color redColor = new RedColor();

        Shape triangle = new Triangle(4,4,4,blueColor);
        Shape rectangle = new Rectangle(10,5,redColor);

        triangle.draw();
        System.out.println("Total cost of the triangle: " + triangle.getTotalCost());

        rectangle.draw();
        System.out.println("Total cost of the rectangle: " + rectangle.getTotalCost());
        
        rectangle.increaseBrightness();
        rectangle.draw();
        System.out.println("Total cost of the rectangle: " + rectangle.getTotalCost());
        
    }

}
```

### Output
```none
Drawing a triangle with sides 4, 4, 4 and color 0000FF
Total cost of the triangle: 519
Drawing a rectangle with height 10, width 5 and color FF0000
Total cost of the rectangle: 2500
Drawing a rectangle with height 10, width 5 and color FF0000
Total cost of the rectangle: 3500
```

### Definition again
- It is a structural design pattern that allows us to split a large class or a set of closely related classes(all shapes and colors) into two separate hierarchies — abstraction(`Shape`, `Color`) and implementation(`Triangle`, `Rectangle`, `RedColor`, `BlueColor`) — which can be developed independently of each other.


Let's learn together!!!
