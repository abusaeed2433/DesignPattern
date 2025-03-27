package structural.adapter;

class Phone {
    void charge(TypeC typeC) {
        typeC.chargeWithTypeC();
    }
}
