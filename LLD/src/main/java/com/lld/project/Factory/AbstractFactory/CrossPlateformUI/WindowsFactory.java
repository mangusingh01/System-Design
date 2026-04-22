package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class WindowsFactory implements UIFactory {
    @Override public Button   createButton()   { return new WindowsButton(); }
    @Override public Dialog   createDialog()   { return new WindowsDialog(); }
    @Override public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
