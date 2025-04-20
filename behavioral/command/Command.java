package behavioral.command;

public abstract class Command {
    
    protected Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        backup = editor.getClipboard();
    }

    public void undo() {
        editor.setText(backup);
    }

    public abstract boolean execute();

}
