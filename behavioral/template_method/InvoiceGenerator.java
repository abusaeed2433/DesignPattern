package behavioral.template_method;

public class InvoiceGenerator extends PdfGenerator {

    public InvoiceGenerator(String fileName) {
        super(fileName);
    }

    @Override
    protected void addContent() {
        System.out.println("Adding invoice content...");
    }

}
