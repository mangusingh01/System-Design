package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class Main {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();

        // Factory selection: one place, one decision
        UIFactory factory = os.contains("mac") ? new MacFactory() : new WindowsFactory();

        Application app = new Application(factory);
        app.renderUI();
        app.interact();

        System.out.println("\n--- Forcing Mac factory for demo ---");
        Application macApp = new Application(new MacFactory());
        macApp.renderUI();
    }
}
