
### Introduction
- Flyweight is a **structural** design pattern that allows us **to fit more objects into the available amount of RAM by sharing common parts** of state between multiple objects instead of keeping all of the data in each object.
- It is used when we need to create a lot of Objects of a class and have memory issue.

### Factor to consider before applying
- The number of Objects to be created by application should be huge.
- The object creation is heavy on memory and it can be time consuming too.
- The object properties can be divided into **intrinsic(immutable, shared, ususally have less variation)** and **extrinsic(mutable, requires many objects)** properties, extrinsic properties of an Object should be defined by the client program.

### Example Scenario
- Let's say we have a TextEditor that can draw character at any position on the screen with font-family, color.

### Without fly-weight
- We can simply create a class having all those properties like this:
    ```java
    enum Color{
        RED, GREEN, BLUE, YELLOW, BLACK, WHITE
    }

    static class Character{
        private int x;
        private int y;
        private char ch;

        private String fontFamily;
        private Color color;

        public Character(int x, int y, char ch, String fontFamily, Color color){
            this.x = x;
            this.y = y;
            this.ch = ch;
            this.fontFamily = fontFamily;
            this.color = color;
        }
        // getter and setter
    }
    ```
- But what if `fontFamily` and `color` property takes more space? Creating many objects of this class surely create memory issue.
- Additionally, there are very less variation in `fontFamily` and `color`, so we can actually reuse them.

### Separating properties
- Intrinsic properties: `fontFamily` and `color` as they can be shared among multiple character objects.
- Extrinsi properties: `x`, `y`, `ch` as there can be huge number of variations.

### Implementation
- Color enum
    ```java
    package structural.flyweight;

    public enum Color {
        RED, GREEN, BLUE, YELLOW, BLACK, WHITE
    }
    ```
- Class with intrinsic properties
    ```java
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
    ```
- Class with extrinsic property with a reference to intrinsic property
    ```java
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
    ```
- Factory method to manages all the styles, so that duplicate styles can be prevented.
    ```java
    package structural.flyweight;

    import java.util.Map;
    import java.util.TreeMap;

    public class FlyweightFactory {

        private static final Map<String, CharacterStyle> stylesMap = new TreeMap<>();

        public static CharacterStyle getCharacterStyle(Color color, String fontFamily){
            String key = color + " " + fontFamily;
            
            CharacterStyle style = stylesMap.get(key);
            if(style == null){
                style = new CharacterStyle(fontFamily, color);
                stylesMap.put(key, style);
            }

            return style;
        }

        public static int getNumberOfStyles(){
            return stylesMap.size();
        }
        
    }
    ```
- And it's done.

### Example usages
```java
package structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    public static void main(String[] args) {
        List<TextCharacter> textCharacters = new ArrayList<>();

        CharacterStyle style1 = FlyweightFactory.getCharacterStyle(Color.BLACK, "Arial");
        textCharacters.add(new TextCharacter(10, 20, 'H', style1));

        CharacterStyle style2 = FlyweightFactory.getCharacterStyle(Color.RED, "Times New Roman");
        textCharacters.add(new TextCharacter(30, 40, 'e', style2));

        CharacterStyle style3 = FlyweightFactory.getCharacterStyle(Color.GREEN, "Verdana");
        textCharacters.add(new TextCharacter(50, 60, 'l', style3));

        CharacterStyle style4 = FlyweightFactory.getCharacterStyle(Color.RED, "Times New Roman"); // same as style2
        textCharacters.add(new TextCharacter(50, 50, 'F', style4));

        // Displaying the text characters
        for (TextCharacter textCharacter : textCharacters) {
            textCharacter.draw();
        }

        System.out.println("Total unique styles created: " + FlyweightFactory.getNumberOfStyles());
    }
}
```

### Output
```
Drawing character H at position (10,20) with font family Arial and color BLACK
Drawing character e at position (30,40) with font family Times New Roman and color RED
Drawing character l at position (50,60) with font family Verdana and color GREEN
Drawing character F at position (50,50) with font family Times New Roman and color RED
Total unique styles created: 3
```

### Definition again
- Flyweight is a structural design pattern that allows us to fit more objects into the available amount of RAM by sharing common parts(`CharacterStyle`) of state between multiple objects(`TextCharacter`) instead of keeping all of the data in each object(`TextCharacter`).
- It is used when we need to create a lot of Objects of a class(`TextCharacter`) and have memory issue.


Let's learn together!!!
