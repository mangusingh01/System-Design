package com.lld.project.Command.TextEditorUndoRedo;

public class DeleteCommand implements TextCommand {
    private final TextEditor editor;
    private final int position;
    private final int length;
    private String deletedText = ""; // captured at execute() time

    public DeleteCommand(TextEditor editor, int position, int length) {
        this.editor   = editor;
        this.position = position;
        this.length   = length;
    }

    @Override
    public void execute() {
        // Capture the text being deleted BEFORE removing it — needed for undo
        deletedText = editor.getContent().substring(position, position + length);
        editor.deleteText(position, length);
    }

    @Override
    public void undo() {
        editor.insertText(deletedText, position);
    }
}
