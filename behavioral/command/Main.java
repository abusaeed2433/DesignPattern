package behavioral.command;

public class Main {
    
    public static void main(String[] args) {
        
        Editor editor = new Editor();
        
        editor.executeCommand(new CopyCommand(editor));
        editor.executeCommand(new PasteCommand(editor));
        editor.executeCommand(new PasteCommand(editor));
        editor.executeCommand(new PasteCommand(editor));
        
        System.out.println("Text after paste: " + editor.getText());
        
        editor.undo();
        editor.undo();
        
        System.out.println("Text after 2 undo: " + editor.getText());
    }

}
