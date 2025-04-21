package behavioral.command;

public class PasteCommand extends Command {
    
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        backup(); // storing current data for undo operation
        editor.setText( editor.getText() + editor.getClipboard());
        return true; // will get saved in command history
    }
    
}
