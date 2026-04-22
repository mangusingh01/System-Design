package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class MacButton implements Button {
    @Override public void render()   { System.out.println("[Mac] Rendering Mac button"); }
    @Override public void onClick()  { System.out.println("[Mac] Mac button clicked"); }
}
