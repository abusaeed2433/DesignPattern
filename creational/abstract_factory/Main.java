package abstract_factory;

public class Main {
    
    public static void main(String[] args) {
        // Create a light-themed UI

        // light theme
        {
            ToolkitFactory factory = new LightToolkitFactory();
            Button button = factory.createButton();
            ProgressBar progressBar = factory.createProgressBar();
            button.onClick();
            progressBar.showProgress();
        }

        // dark theme
        {
            ToolkitFactory factory = new DarkToolkitFactory();
            Button button = factory.createButton();
            ProgressBar progressBar = factory.createProgressBar();
            button.onClick();
            progressBar.showProgress();
        }
    }

}
