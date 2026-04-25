package com.lld.project.Command.TextEditorUndoRedo;

public class TextEditor {
    private StringBuilder content = new StringBuilder();

    public void insertText(String text, int position) {
        content.insert(position, text);
        System.out.println("[Editor] Insert at " + position + ": \"" + text
                + "\" → \"" + content + "\"");
    }

    public void deleteText(int position, int length) {
        content.delete(position, position + length);
        System.out.println("[Editor] Delete at " + position + ", len " + length
                + " → \"" + content + "\"");
    }

    public String getContent()         { return content.toString(); }
    public int    getLength()          { return content.length(); }
}

