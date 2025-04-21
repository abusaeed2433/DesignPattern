package behavioral.command;

public abstract class Command {
    
    protected Editor editor; // reference to editor
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        backup = editor.getText(); // saving currently shown data
    }

    public void undo() {
        editor.setText(backup); //showing previous content
    }

    public abstract boolean execute();

}