package com.lld.project.Factory.AbstractFactory.CrossPlateformUI;

public class MacDialog implements Dialog {
    @Override public void show()     { System.out.println("[Mac] Showing Mac dialog"); }
    @Override public void close()    { System.out.println("[Mac] Closing Mac dialog"); }
}
