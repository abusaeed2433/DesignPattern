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
