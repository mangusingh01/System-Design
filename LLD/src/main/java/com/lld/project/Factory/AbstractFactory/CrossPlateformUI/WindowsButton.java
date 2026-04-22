package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class WindowsButton implements Button {
    @Override public void render()   { System.out.println("[Win] Rendering Windows button"); }
    @Override public void onClick()  { System.out.println("[Win] Windows button clicked"); }
}
