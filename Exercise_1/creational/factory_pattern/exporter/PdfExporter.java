package exporter;

public class PdfExporter implements DocumentExporter {
    @Override
    public void export(String content) {
        System.out.println("Exporting content to PDF: " + content);
    }
}
