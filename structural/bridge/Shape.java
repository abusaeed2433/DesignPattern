package structural.bridge;

public interface Shape {

    public abstract void draw();

    public void increaseBrightness();

    public void decreaseBrightness();

    public abstract int getTotalCost();
}
