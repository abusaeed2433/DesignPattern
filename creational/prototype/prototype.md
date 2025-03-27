
### Introduction
- It's a creational design pattern.
- In simple term, it is used to create an object based on an existing object through cloning. That's it.

### Problem with direct copying?
- We can clone an object using new keyword and then passing all the needed data. Yes, we can. But
- The class can have private variable, that maynot be accessible if it is used internally and have no getter.
- We become dependent on that class for cloning. If we need to clone multiple class known via a common interface, we can't clone them without knowing the class details.

### How to do it in Java?
- It's already implemented via the `Cloneable` interface.
- Any class that implements the `Cloneable` interface can be cloned.

## Let's do it without `Cloneable` interface

### Example Scenario
- Let's say we have some shapes(`Circle`, `Rectangle`) and we want to make copy of it.

### Implementation code
- Common shape interface. (`Shape.java`)
    ```java
    package prototype;

    public interface Shape {

        public Shape clone();
        public void draw();
        
    }
    ```
- Concrete implementations(`Circle.java`, and `Rectangle.java`)
    ```java
    package prototype;

    public class Circle implements Shape {
        private int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        @Override
        public void draw(){
            System.out.println("Drawing a circle with radius " + radius);
        }

        @Override
        public Circle clone() {
            return new Circle(radius);
        }

    }
    ```
    and
    ```java
    package prototype;

    public class Rectangle implements Shape {
        private int width;
        private int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(){
            System.out.println("Drawing a rectangle with width " + width + " and height " + height);
        }

        @Override
        public Rectangle clone() {
            return new Rectangle(width, height);
        }    
    }
    ```

### Example usages
```java
package prototype;

public class Main {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        Shape circle = new Circle(15);
        
        Shape rectangleClone = rectangle.clone();
        
        Shape circleClone = circle.clone();
        
        rectangle.draw();
        circle.draw();
        rectangleClone.draw();
        circleClone.draw();
    }

}
```

### Output
```none
Drawing a rectangle with width 10 and height 20
Drawing a circle with radius 15
Drawing a rectangle with width 10 and height 20
Drawing a circle with radius 15
```

Let's learn together!!!
