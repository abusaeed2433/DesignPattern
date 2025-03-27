package abstract_factory;

public class DarkProgressBar implements ProgressBar{
    @Override
    public void showProgress() {
        System.out.println("Dark progress bar");
    }
}
