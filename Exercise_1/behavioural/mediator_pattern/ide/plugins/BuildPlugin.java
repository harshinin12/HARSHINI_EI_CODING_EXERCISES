package ide.plugins;

import ide.mediator.PluginMediator;

public class BuildPlugin extends Plugin {
    public BuildPlugin(PluginMediator mediator) {
        super("BuildTool", mediator);
    }

    @Override
    public void receive(String event) {
        if (event.equals("file_saved")) {
            System.out.println("[BuildTool] Rebuilding project...");
        }
    }
}
