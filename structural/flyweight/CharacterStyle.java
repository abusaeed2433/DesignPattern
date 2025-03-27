package structural.flyweight;

public class CharacterStyle {

    private final String fontFamily; // intrinsic
    private final Color color; // intrinsic

    public CharacterStyle(String fontFamily, Color color) {
        this.fontFamily = fontFamily;
        this.color = color;
    }

    public String getFontFamily() {
        return fontFamily;
    }
    
    public Color getColor() {
        return color;
    }

    public void draw(int x, int y, char ch) {
        System.out.println("Drawing character " + ch + " at position (" + x + "," + y + ") with font family " + fontFamily + " and color " + color);
    }
    
}
