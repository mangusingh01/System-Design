package com.lld.project.Factory.ReportGenerator;

public class ExcelReportCreator extends ReportCreator {
    @Override
    protected Report createReport() { return new ExcelReport(); }
}
