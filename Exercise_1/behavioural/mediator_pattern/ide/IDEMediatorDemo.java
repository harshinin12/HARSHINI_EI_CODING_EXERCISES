package ide;
import ide.mediator.*;
import ide.plugins.*;

public class IDEMediatorDemo {
    public static void main(String[] args) {
        IDEPluginMediator mediator = new IDEPluginMediator();

        EditorPlugin editor = new EditorPlugin(mediator);
        DebuggerPlugin debugger = new DebuggerPlugin(mediator);
        GitPlugin git = new GitPlugin(mediator);
        BuildPlugin build = new BuildPlugin(mediator);
        TerminalPlugin terminal = new TerminalPlugin(mediator);

        mediator.setEditor(editor);
        mediator.setDebugger(debugger);
        mediator.setGit(git);
        mediator.setBuild(build);
        mediator.setTerminal(terminal);

        editor.saveFile();
        System.out.println("----");
        debugger.startDebug();
    }
}
