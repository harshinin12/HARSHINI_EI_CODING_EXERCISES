package ide.plugins;
import ide.mediator.PluginMediator;

public class TerminalPlugin extends Plugin {
    public TerminalPlugin(PluginMediator mediator) {
        super("Terminal", mediator);
    }

    @Override
    public void receive(String event) {
        System.out.println("[Terminal] Log: " + event);
    }
}
