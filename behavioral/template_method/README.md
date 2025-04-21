
### Introduction
- Template Method is a **behavioral** design pattern that **defines the skeleton of an algorithm in the superclass** but **lets subclasses override specific steps of the algorithm without changing its structure.**
- It's like a teamplate that can be used after making a little modification to it to save time and prevent duplication of code.

<p align="center">
    <img src="https://refactoring.guru/images/patterns/diagrams/template-method/structure.png" alt="Taken from refactoring guru" height="300">
</p>

### Example Scenario
- Let's say we want to build a PDF generator application. It creates the file, write the content then close the file.
- Image we want to create different types of documents like invoice, report etc.
- For all of the documents, few parts are common like creating and saving file, and few part needs to be defined.

To solve this, we will create a base class implementing the common ones, and we will either keep abstract of provide a default implementation on other ones.

### Implementation
1. PdfGenerator
```java
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
```
2. Few concrete implementation
2a. InvoiceGenerator
```java
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
```
2b. ReportGenerator
```java
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
```

And it's done.

### Example usage
```java
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
```

### Output
```
Creating file report.pdf...
Writing custom header...
Adding report content...
Closing file report.pdf...
-----------------
Creating file invoice.pdf...
Writing header (default)...
Adding invoice content...
Closing file invoice.pdf...
```

Let's learn together!!!
