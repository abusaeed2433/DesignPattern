package structural.flyweight;

public class Traditional{

    enum Color{
        RED, GREEN, BLUE, YELLOW, BLACK, WHITE
    }

    static class Character{
        private int x;
        private int y;
        private char c;

        private String fontFamily;
        private Color color;

        public Character(int x, int y, char c, String fontFamily, Color color){
            this.x = x;
            this.y = y;
            this.c = c;
            this.fontFamily = fontFamily;
            this.color = color;
        }
        // getter and setter
    }

    public static void main(String... args){

    }

}
