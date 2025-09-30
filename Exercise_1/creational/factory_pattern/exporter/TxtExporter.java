package exporter;

public class TxtExporter implements DocumentExporter {
    @Override
    public void export(String content) {
        System.out.println("Exporting content to Txt: " + content);
    }
}
