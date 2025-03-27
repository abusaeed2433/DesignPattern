package factory_method;

public class PdfFactory implements DocumentFactory {
    
    @Override
    public Document createDocument(String name){
        return new PDF(name);
    }
}
