package Abstraction.DataExporter.Impl;

import Abstraction.DataExporter.DataFormatter;

import java.util.List;
import java.util.Map;

public class JSONFormatter implements DataFormatter {
    public String format(List<Map<String,Object>> records) {
        return records.toString(); // real impl uses Jackson/Gson
    }
}
