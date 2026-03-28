package Polymorphism.OverridingRuntime;

public class PDFDocument extends Document {
    public PDFDocument(String t, String a) {
        super(t, a);
    }
    public String render() {
        return track("[PDF] Rendering '" + title + "' as binary stream");
    }
}

