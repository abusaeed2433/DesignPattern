### Introduction
Command is a **behavioral** design pattern that turns a request into a stand-alone object that contains all information about the request.

### Example Scenario
Let's implement a TextEditor with some basic commands like copy, paste, undo. Here undo operation uses takes the last executed command or perform inverse action saved by that command.

### Implementation
1. The command interface or abstract class (if some default implementaion is needed)
```java
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
```
2. Some concrete implementaion of the Command class
2a. PasteCommand
```java
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
```
2b. CopyCommand
```java
package behavioral.command;

public class CopyCommand extends Command {
    
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.setClipboard("sound"); // Just using a fixed string for simplicity
        return false; // not saved in commanded history
    }
    
}
```
3. Command history class for storing command
```java
package behavioral.command;

import java.util.Stack;

public class CommandHistory {
    
    private Stack<Command> history = new Stack<>();
    
    public void push(Command command) {
        history.push(command);
    }

    public Command pop(){
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

}
```
4. Editor class
```java
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
```

And it's done.

### Example usage
```java
package behavioral.command;

public class Main {
    
    public static void main(String[] args) {
        
        Editor editor = new Editor();
        
        editor.executeCommand(new CopyCommand(editor));
        editor.executeCommand(new PasteCommand(editor));
        editor.executeCommand(new PasteCommand(editor));
        
        System.out.println("Text after paste: " + editor.getText());
        
        editor.undo();
        
        System.out.println("Text after undo: " + editor.getText());
    }

}
```

### Output
```
Text after paste: soundsound
Text after undo: sound
```

### Definition again
Command is a **behavioral** design pattern that turns a request(`executeCommand()`) into a stand-alone object (`CopyCommand`, `PasteCommand`) that contains all information about the request.

Let's learn together!!!
