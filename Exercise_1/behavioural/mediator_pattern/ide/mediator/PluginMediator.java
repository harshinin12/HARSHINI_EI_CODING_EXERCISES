package ide.mediator;

import ide.plugins.Plugin;

public interface PluginMediator {
    void notify(Plugin sender, String event);
}
