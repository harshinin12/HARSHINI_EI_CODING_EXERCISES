package exporter;

public class DocxExporter implements DocumentExporter {
    @Override
    public void export(String content) {
        System.out.println("Exporting content to Docx: " + content);
    }
}
