package factory_method;

public class Main {
    public static void main(String[] args) {
        DocumentFactory factory = new PdfFactory();
        Document pdf = factory.createDocument("medium");
        pdf.open();
    }
}
