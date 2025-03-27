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
