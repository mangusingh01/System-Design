package Abstraction.DataExporter.Impl;

import Abstraction.DataExporter.DataWriter;

public class StdoutWriter implements DataWriter {

    public void write(String data) {
        System.out.println(data);
    }
}
