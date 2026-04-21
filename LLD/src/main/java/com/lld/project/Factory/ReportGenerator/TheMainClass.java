package com.lld.project.Factory.ReportGenerator;

public class TheMainClass {
    public static void main(String[] args) {
        // Client works only with the abstract Creator — DIP satisfied
        ReportCreator creator = getCreator("PDF");
        creator.generate();

        creator = getCreator("HTML");
        creator.generate();
    }

    // Factory selection lives here — the one place that knows concrete types
    private static ReportCreator getCreator(String format) {
        return switch (format) {
            case "PDF"   -> new PdfReportCreator();
            case "HTML"  -> new HtmlReportCreator();
            case "Excel" -> new ExcelReportCreator();
            default      -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}