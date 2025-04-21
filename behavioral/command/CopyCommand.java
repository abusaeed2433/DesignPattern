package behavioral.command;

public class CopyCommand extends Command {
    
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        // no backup needed, since it will just copy the text.
        editor.setClipboard(" sound"); // Just using a fixed string for simplicity
        return false; // not saved in commanded history
    }
    
}