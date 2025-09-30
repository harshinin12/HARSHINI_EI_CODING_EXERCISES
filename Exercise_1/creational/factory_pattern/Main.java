

import factory.ExporterFactory;
import factory.SimpleExporterFactory;
import exporter.DocumentExporter;

public class Main {
    public static void main(String[] args) {
        ExporterFactory factory = new SimpleExporterFactory();
        String content = "Hello Factory Method Pattern!";

        DocumentExporter pdf = factory.createExporter("PDF");
        pdf.export(content);

        DocumentExporter docx = factory.createExporter("DOCX");
        docx.export(content);

        DocumentExporter html = factory.createExporter("HTML");
        html.export(content);

        DocumentExporter txt = factory.createExporter("TXT");
        txt.export(content);
    }
}
