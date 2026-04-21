package com.lld.project.Factory.ReportGenerator;

public class ExcelReport implements Report {
    @Override public void render()        { System.out.println("[Excel] Rendering Excel report..."); }
    @Override public String getFormat()   { return "Excel"; }
}
