package Abstraction.DataExporter.Impl;

import Abstraction.DataExporter.DataSource;

import java.util.List;
import java.util.Map;

public class MockDBSource implements DataSource {

    public List<Map<String, Object>> fetch() {
        return List.of(Map.of("id", 1, "name", "Alice", "age", 25));
    }
}
