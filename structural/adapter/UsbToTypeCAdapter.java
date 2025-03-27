package structural.adapter;

public class UsbToTypeCAdapter implements TypeC {
    private USB usb;

    public UsbToTypeCAdapter(USB usb) {
        this.usb = usb;
    }

    @Override
    public void chargeWithTypeC() {
        System.out.println("Adapter converts Type-C to USB.");
        usb.chargeWithUSB();
    }
}
