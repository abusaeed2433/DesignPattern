package abstract_factory;

public class DarkToolkitFactory implements ToolkitFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }
    @Override
    public ProgressBar createProgressBar() {
        return new DarkProgressBar();
    }
}
