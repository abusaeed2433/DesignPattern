## Factory method pattern

### Info
- It provides a way to delegate the instantiation logic to child classes.
- It is a creational pattern that `uses factory method` to deal with the `problem of creating objects` `without specifying the exact class of the object that will be created`.
- This is done by creating objects by calling a factory method — 
    - Either specified in an interface and implemented by child classes, or 
    - Implemented in a base class and overridden by derived classes.
- In other terms, this defines an interface for `creating objects in a superclass`, but allows subclasses to alter the type of objects that will be created.
- This pattern promotes loose coupling by separating the object creation process from the actual usage of the objects.

### Example
- Consider an application that generates reports in various formats, like PDF, Excel, or Word.
- The Factory Method pattern could be used to create `report generator objects specific to the required format`, without the client knowing the details of the report generator implementations.

### When to use?
- Object creation is quite complex and we need something centralized to manage it.

### Implementation of the example
- Abstract parent class(`Document.java`)
    ```java
    package factory_method;

    public abstract class Document { // can be interface if needed
        public final String name;
        public Document(String name) {
            this.name = name;
        }
        abstract void open();
    }
    ```
- Some concrete classes that extending the parent class.
- `PDF.java`
    ```
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
    ```
- `Word.java`
    ```java
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
    ```
- A factory parent interface
    ```java
    package factory_method;

    public interface DocumentFactory {
        Document createDocument(String fileName);
    }
    ```
- PdfFactory class for creating PDF document
    ```java
    package factory_method;

    public class PdfFactory implements DocumentFactory {
        
        @Override
        public Document createDocument(String name){
            return new PDF(name);
        }
    }
    ```
- WordFactory class for creaing Word document
    ```java
    package factory_method;

    public class WordFactory implements DocumentFactory {

        @Override
        public Document createDocument(String name){
            return new Word(name);
        }
        
    }
    ```

- Example usage:
    ```java
    package factory_method;

    public class Main {
        public static void main(String[] args) {
            DocumentFactory factory = new PdfFactory();
            Document pdf = factory.createDocument("medium");
            pdf.open();
        }
    }
    ```
- Output:
    ```
    Opening PDF: medium
    ```

### Definition again
- It defines an interface for creating objects in a superclass: `DocumentFactory`.
- but allows subclasses(`PdfFactory`, `WordFactory`) to alter the type of objects that will be created.
