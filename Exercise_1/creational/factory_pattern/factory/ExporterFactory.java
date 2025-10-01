package factory;
import exporter.DocumentExporter;

public interface ExporterFactory {
    DocumentExporter createExporter(String type);
}
