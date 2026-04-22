package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public interface UIFactory {
    Button   createButton();
    Dialog   createDialog();
    Checkbox createCheckbox();
}

