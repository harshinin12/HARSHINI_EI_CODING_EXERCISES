package ide.plugins;
import ide.mediator.PluginMediator;

public abstract class Plugin {
    protected PluginMediator mediator;
    protected String name;

    public Plugin(String name, PluginMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    protected void sendEvent(String event) {
        mediator.notify(this, event);
    }

    public abstract void receive(String event);
}
