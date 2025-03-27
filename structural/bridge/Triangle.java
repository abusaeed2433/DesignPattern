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
