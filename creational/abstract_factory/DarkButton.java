package abstract_factory;

public class DarkButton implements Button{
    @Override
    public void onClick() {
        System.out.println("Dark button clicked");
    }
}

