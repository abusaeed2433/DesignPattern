package structural.adapter;

public class Main {
    public static void main(String[] args) {
        // Existing USB port
        USB usb = new USB();

        // Adapter to convert USB to Type-C
        TypeC adapter = new UsbToTypeCAdapter(usb);

        // Phone charging using the adapter
        Phone phone = new Phone();
        phone.charge(adapter);
    }
}
