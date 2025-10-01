package ide.plugins;
import ide.mediator.PluginMediator;

public class GitPlugin extends Plugin {
    public GitPlugin(PluginMediator mediator) {
        super("Git", mediator);
    }

    @Override
    public void receive(String event) {
        if (event.equals("file_saved")) {
            System.out.println("[Git] File saved. Preparing for commit...");
        }
    }
}
