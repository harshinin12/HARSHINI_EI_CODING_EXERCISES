package ide.plugins;

import ide.mediator.PluginMediator;

public class EditorPlugin extends Plugin {
    public EditorPlugin(PluginMediator mediator) {
        super("Editor", mediator);
    }

    public void saveFile() {
        System.out.println("[Editor] File saved.");
        sendEvent("file_saved");
    }

    @Override
    public void receive(String event) {
        if (event.equals("debug_start")) {
            System.out.println("[Editor] Switching to debug mode.");
        }
    }
}
