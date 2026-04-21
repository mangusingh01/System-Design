package com.lld.project.Factory.ReportGenerator;

public class PdfReport implements Report {
    @Override public void render()        { System.out.println("[PDF] Rendering PDF report..."); }
    @Override public String getFormat()   { return "PDF"; }
}
