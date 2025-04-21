package behavioral.template_method;

public abstract class PdfGenerator {
    private String fileName;

    public PdfGenerator(String fileName) {
        this.fileName = fileName;
    }
    
    public final void generatePdf() {
        openFile();
        writeHeader(); // optional or default 
        addContent(); // subclasses must implement this method
        closeFile();
    }

    protected void openFile(){
        System.out.println("Creating file " + fileName + "...");
    }

    protected void writeHeader(){
        System.out.println("Writing header (default)...");
    }

    protected abstract void addContent(); // subclasses must implement this method

    protected void closeFile(){
        System.out.println("Closing file " + fileName + "...");
    }

}
