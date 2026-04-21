package com.lld.project.Factory.ReportGenerator;

public class HtmlReportCreator extends ReportCreator {
    @Override
    protected Report createReport() { return new HtmlReport(); }
}
