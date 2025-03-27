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
