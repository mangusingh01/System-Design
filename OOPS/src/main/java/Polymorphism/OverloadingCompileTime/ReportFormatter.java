package Polymorphism.OverloadingCompileTime;

import java.util.List;
import java.util.Map;

public class ReportFormatter {

    // Overload 1: single string
    public String format(String line){
        return "|" + line + "|";
    }

    // Overload 2: list of lines
    public String format(List<String> lines){
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append("  - ").append(line).append("\n");
        }
        return sb.toString().stripTrailing();
    }

    // Overload 3: key-value map
    public String format(Map<String,String> data){
        StringBuilder sb = new StringBuilder();
        data.forEach((k,v)->{
            sb.append("  - ").append(k).append(": ").append(v).append("\n");
        });
        return sb.toString().stripTrailing();
    }

    // Overload 4: titled list (different signature from overload 2)
    public String format(String title, List<String> lines) {
        return "=== " + title + " ===\n" + format(lines); // reuses overload 2
    }
}
