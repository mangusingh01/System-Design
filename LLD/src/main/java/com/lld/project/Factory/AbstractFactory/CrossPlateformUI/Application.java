package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class Application {
    private final Button   button;
    private final Dialog   dialog;
    private final Checkbox checkbox;

    // Factory injected via constructor — the whole family arrives together
    public Application(UIFactory factory) {
        this.button   = factory.createButton();
        this.dialog   = factory.createDialog();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        System.out.println("--- Rendering UI ---");
        button.render();
        dialog.show();
        checkbox.render();
    }

    public void interact() {
        System.out.println("--- Interacting ---");
        button.onClick();
        dialog.close();
    }
}
