package exporter;
public class HtmlExporter implements DocumentExporter {
    @Override
    public void export(String content) {
        System.out.println("Exporting content to HTML: " + content);
    }
}
