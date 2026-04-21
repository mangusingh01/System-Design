package com.lld.project.Factory.ReportGenerator;

public class HtmlReport implements Report {
    @Override public void render()        { System.out.println("[HTML] Rendering HTML report..."); }
    @Override public String getFormat()   { return "HTML"; }
}
