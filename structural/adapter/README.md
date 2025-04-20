
### Introduction
- It is a **structural** design pattern that **allows objects with incompatible interfaces to collaborate**.
- Basically, it's like a converter that convert a type into another type needed for something.

### Example Scenario
- Let's say we want to charge our phone using laptop.
- Laptop has USB port and Phone requires type-C.
- To connect them we need a converter/adapter that takes the USB and give type-C.


### Implementation
- Target Interface (Type-C). We need this as final result
    ```java
    package structural.adapter;

    public interface TypeC {
        void chargeWithTypeC();
    }
    ```
- USB(Consider it as our existing class and we have access to change it).
    ```java
    package structural.adapter;

    public class USB {
        
        void chargeWithUSB() {
            System.out.println("Charging with USB...");
        }

    }
    ```
- Adapter for converting USB to Type-C.
    ```java
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

    ```
- Phone ( Consider it as the library code, or something we can't change).
    ```java
    package structural.adapter;

    public class Phone {
        void charge(TypeC typeC) {
            typeC.chargeWithTypeC();
        }
    }
    ```

### Example usages
```java
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
```


### Output
```
Adapter converts Type-C to USB.
Charging with USB...
```

### Definition again
- It is a **structural** design pattern that allows objects with incompatible interfaces(`TypeC`, `USB`) to collaborate.

Let's learn together!!!

