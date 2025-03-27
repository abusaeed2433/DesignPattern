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
