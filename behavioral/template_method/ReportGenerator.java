package behavioral.template_method;

public class ReportGenerator extends PdfGenerator {

    public ReportGenerator(String fileName) {
        super(fileName);
    }

    @Override
    protected void addContent() {
        System.out.println("Adding report content...");
    }

    @Override
    protected void writeHeader() {
        System.out.println("Writing custom header...");
    }
    
}
