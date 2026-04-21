package com.lld.project.Factory.ReportGenerator;

public abstract class ReportCreator {

    // Factory method — the hook subclasses override
    protected abstract Report createReport();

    // Template method — uses the factory method; never touches concrete types
    public void generate() {
        Report report = createReport();   // polymorphic call — DIP in action
        System.out.println("Generating " + report.getFormat() + " report...");
        report.render();
        System.out.println("Done.");
    }
}

