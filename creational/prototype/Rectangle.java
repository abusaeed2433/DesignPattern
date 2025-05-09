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
