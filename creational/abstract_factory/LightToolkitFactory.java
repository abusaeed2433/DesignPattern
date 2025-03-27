package abstract_factory;

public class LightToolkitFactory implements ToolkitFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }
    @Override
    public ProgressBar createProgressBar() {
        return new LightProgressBar();
    }
}
