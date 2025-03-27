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
