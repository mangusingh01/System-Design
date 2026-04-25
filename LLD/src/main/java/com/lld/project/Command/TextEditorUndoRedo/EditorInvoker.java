package com.lld.project.Command.TextEditorUndoRedo;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorInvoker {
    private final Deque<TextCommand> undoStack = new ArrayDeque<>();
    private final Deque<TextCommand> redoStack = new ArrayDeque<>();

    // Execute a command and push it onto the undo stack.
    // Clear redo stack — a new action breaks the redo chain.
    public void execute(TextCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // new action invalidates redo history
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("[Invoker] Nothing to undo");
            return;
        }
        TextCommand command = undoStack.pop();
        command.undo();
        redoStack.push(command); // move to redo stack
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("[Invoker] Nothing to redo");
            return;
        }
        TextCommand command = redoStack.pop();
        command.execute();
        undoStack.push(command); // re-execute and restore to undo stack
    }

    public int historySize() { return undoStack.size(); }
}
