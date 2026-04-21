package com.lld.project.Factory.ReportGenerator;

public class PdfReportCreator extends ReportCreator {
    @Override
    protected Report createReport() { return new PdfReport(); }
}
