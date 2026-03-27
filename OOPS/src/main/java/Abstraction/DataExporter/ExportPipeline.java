package Abstraction.DataExporter;

public class ExportPipeline {
    private final DataSource source;
    private final DataFormatter formatter;
    private final DataWriter writer;

    public ExportPipeline(DataSource source, DataFormatter formatter,
                          DataWriter writer) {
        this.source = source;
        this.formatter = formatter;
        this.writer = writer;
    }

    public void run() {
        var records = source.fetch();
        var output  = formatter.format(records);
        writer.write(output);
    }
}