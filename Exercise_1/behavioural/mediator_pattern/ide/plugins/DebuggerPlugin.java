package ide.plugins;

import ide.mediator.PluginMediator;

public class DebuggerPlugin extends Plugin {
    public DebuggerPlugin(PluginMediator mediator) {
        super("Debugger", mediator);
    }

    public void startDebug() {
        System.out.println("[Debugger] Debugging started.");
        sendEvent("debug_start");
    }

    @Override
    public void receive(String event) {
        if (event.equals("file_saved")) {
            System.out.println("[Debugger] Notified: File saved, checking breakpoints.");
        }
    }
}
