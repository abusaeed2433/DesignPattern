package behavioral.command;

public class Editor {
    private CommandHistory history = new CommandHistory();
    private String clipboard = "";

    private String text = "";


    public void executeCommand(Command command) {
        if( command.execute() ){
            history.push(command);
        }
    }

    public void undo(){
        if( history.isEmpty() ) return;

        Command command = history.pop();
        command.undo();
    }

    public void setClipboard(String text) {
        this.clipboard = text;
    }
    public String getClipboard() {
        return clipboard;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

}
