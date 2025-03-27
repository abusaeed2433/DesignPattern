package factory_method;

public class PDF extends Document {
    public PDF(String name) {
        super(name);
    }
    
    @Override
    public void open() {
        System.out.println("Opening PDF: " + name);
    }   
}
