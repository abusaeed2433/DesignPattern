package structural.flyweight;

public class TextCharacter {
    private int x;
    private int y;
    private char ch;

    private CharacterStyle style;

    public TextCharacter(int x, int y, char ch, CharacterStyle style) {
        this.x = x;
        this.y = y;
        this.ch = ch;
        this.style = style;
    }

    public void draw(){
        style.draw(x,y,ch);
    }

}
