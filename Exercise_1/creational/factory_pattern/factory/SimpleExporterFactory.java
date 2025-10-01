
package factory;
import exporter.*;

public class SimpleExporterFactory implements ExporterFactory {

    @Override
    public DocumentExporter createExporter(String type) {
        return switch (type.toUpperCase()) {
            case "PDF" -> new PdfExporter();
            case "DOCX" -> new DocxExporter();
            case "HTML" -> new HtmlExporter();
            case "TXT" -> new TxtExporter();
            default -> throw new IllegalArgumentException("Unknown format: " + type);
        };
    }
}

