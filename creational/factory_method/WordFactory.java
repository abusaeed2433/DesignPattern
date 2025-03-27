package factory_method;

public class WordFactory implements DocumentFactory {

    @Override
    public Document createDocument(String name){
        return new Word(name);
    }
    
}
