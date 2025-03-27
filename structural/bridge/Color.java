package structural.bridge;

public interface Color {

    static final int UNIT_COST = 100;

    void setOpacity(float opacity);
    float getOpacity();

    String getColorCode();

    int getUnitCost();

}
