package Polymorphism.OverridingRuntime;

import java.util.List;

public class DocumentRenderer {
    public void renderAll(List<Document> docs) {
        for (Document doc : docs) {
            System.out.println(doc.render());
            System.out.println(doc.getMetadata());
        }
    }
}
