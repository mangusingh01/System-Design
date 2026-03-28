package Polymorphism.OverridingRuntime;

public abstract class Document {
    protected final String title, author;
    private int renderCount = 0;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract String render();      // runtime-dispatched

    public String getMetadata() {          // shared concrete method
        return "\"" + title + "\" by " + author;
    }

    protected String track(String output) {
        renderCount++;
        return output;
    }
    public int getRenderCount() {
        return renderCount;
    }
}

