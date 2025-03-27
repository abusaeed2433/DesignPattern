package factory_method;

public abstract class Document { // can be interface if needed
    public final String name;
    public Document(String name) {
        this.name = name;
    }
    abstract void open();
}
