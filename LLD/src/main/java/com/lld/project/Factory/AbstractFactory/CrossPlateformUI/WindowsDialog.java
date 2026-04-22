package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class WindowsDialog implements Dialog {
    @Override public void show()     { System.out.println("[Win] Showing Windows dialog"); }
    @Override public void close()    { System.out.println("[Win] Closing Windows dialog"); }
}
