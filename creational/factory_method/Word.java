package factory_method;

public class Word extends Document {
    public Word(String name) {
        super(name);
    }
    @Override
    public void open() {
        System.out.println("Opening Word: " + name);
    }
}
