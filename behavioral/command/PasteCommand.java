package behavioral.command;

public class PasteCommand extends Command {
    
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        backup();
        editor.setText( editor.getText() + "sound"); // Just using a fixed string for simplicity
        return true; // will get saved in commanded history
    }
    
}
