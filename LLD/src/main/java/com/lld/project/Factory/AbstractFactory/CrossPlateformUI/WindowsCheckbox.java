package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class WindowsCheckbox implements Checkbox {
    private boolean checked = false;
    @Override public void render()        { System.out.println("[Win] Rendering Windows checkbox"); }
    @Override public boolean isChecked()  { return checked; }
}

