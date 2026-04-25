package com.lld.project.Command.TextEditorUndoRedo;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorInvoker invoker = new EditorInvoker();

        System.out.println("=== Editing ===");
        invoker.execute(new InsertCommand(editor, "Hello", 0));
        invoker.execute(new InsertCommand(editor, " World", 5));
        invoker.execute(new DeleteCommand(editor, 0, 5)); // delete "Hello"

        System.out.println("\nContent: \"" + editor.getContent() + "\"");

        System.out.println("\n=== Undo ×2 ===");
        invoker.undo(); // re-insert "Hello"
        invoker.undo(); // un-insert " World"

        System.out.println("Content: \"" + editor.getContent() + "\"");

        System.out.println("\n=== Redo ×1 ===");
        invoker.redo();
        System.out.println("Content: \"" + editor.getContent() + "\"");
    }
}
