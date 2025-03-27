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
