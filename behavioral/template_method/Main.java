package behavioral.template_method;

public class Main {
    
    public static void main(String[] args) {
        PdfGenerator reportGenerator = new ReportGenerator("report.pdf");
        reportGenerator.generatePdf();
        
        System.out.println("-----------------");
        
        PdfGenerator invoiceGenerator = new InvoiceGenerator("invoice.pdf");
        invoiceGenerator.generatePdf();
    }

}
