package abstract_factory;

public class LightProgressBar implements ProgressBar{
    @Override
    public void showProgress() {
        System.out.println("Light progress bar");
    }
}
