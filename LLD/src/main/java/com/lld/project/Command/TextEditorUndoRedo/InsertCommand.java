package com.lld.project.Command.TextEditorUndoRedo;

public class InsertCommand implements TextCommand {
    private final TextEditor editor;    // receiver
    private final String text;          // parameters captured at creation time
    private final int position;

    public InsertCommand(TextEditor editor, String text, int position) {
        this.editor   = editor;
        this.text     = text;
        this.position = position;
    }

    @Override
    public void execute() {
        editor.insertText(text, position);
    }

    @Override
    public void undo() {
        // To undo an insert: delete the same text from the same position
        editor.deleteText(position, text.length());
    }
}
