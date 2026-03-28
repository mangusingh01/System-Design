package Polymorphism.OverridingRuntime;

public class HTMLDocument extends Document {
    public HTMLDocument(String t, String a) { super(t, a); }
    public String render() {
        return track("[HTML] <html><body>" + title + "</body></html>");
    }
}
