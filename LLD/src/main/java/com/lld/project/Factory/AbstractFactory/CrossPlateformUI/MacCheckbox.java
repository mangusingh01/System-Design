package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class MacCheckbox implements Checkbox {
    private boolean checked = false;
    @Override public void render()        { System.out.println("[Mac] Rendering Mac checkbox"); }
    @Override public boolean isChecked()  { return checked; }
}
