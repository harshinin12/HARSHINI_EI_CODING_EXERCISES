package ide.mediator;

import ide.plugins.*;

public class IDEPluginMediator implements PluginMediator {
    private EditorPlugin editor;
    private DebuggerPlugin debugger;
    private GitPlugin git;
    private BuildPlugin build;
    private TerminalPlugin terminal;

    public void setEditor(EditorPlugin editor) { this.editor = editor; }
    public void setDebugger(DebuggerPlugin debugger) { this.debugger = debugger; }
    public void setGit(GitPlugin git) { this.git = git; }
    public void setBuild(BuildPlugin build) { this.build = build; }
    public void setTerminal(TerminalPlugin terminal) { this.terminal = terminal; }

    @Override
    public void notify(Plugin sender, String event) {
        switch (event) {
            case "file_saved" -> {
                if (git != null) git.receive(event);
                if (build != null) build.receive(event);
                if (debugger != null) debugger.receive(event);
            }
            case "debug_start" -> {
                if (editor != null) editor.receive(event);
            }
        }
        if (terminal != null) {
            terminal.receive("[" + sender.getName() + "] triggered " + event);
        }
    }
}
