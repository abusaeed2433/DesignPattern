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
