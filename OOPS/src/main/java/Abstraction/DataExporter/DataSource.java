package Abstraction.DataExporter;

import java.util.List;
import java.util.Map;

public interface DataSource {
    List<Map<String,Object>> fetch();
}
