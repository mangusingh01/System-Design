package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class MacFactory implements UIFactory {
    @Override public Button   createButton()   { return new MacButton(); }
    @Override public Dialog   createDialog()   { return new MacDialog(); }
    @Override public Checkbox createCheckbox() { return new MacCheckbox(); }
}
