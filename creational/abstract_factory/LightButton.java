package abstract_factory;

public class LightButton implements Button{
    @Override
    public void onClick() {
        System.out.println("Light button clicked");
    }
}
