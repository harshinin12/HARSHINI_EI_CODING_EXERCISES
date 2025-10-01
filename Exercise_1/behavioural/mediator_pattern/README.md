# Mediator Design Pattern

## Use Case
In an IDE (Integrated Development Environment), multiple plugins like Editor, Debugger, Git, BuildTool, and Terminal need to interact with each other. For example:

- When a file is saved in the Editor, the BuildTool should rebuild the project, Git should prepare for commit, and Debugger should check breakpoints.  
- When debugging starts, the Editor switches to debug mode.  
- The Terminal logs all plugin actions.

Instead of having each plugin directly communicate with every other plugin, a central mediator manages all interactions. This reduces coupling and makes it easy to add or remove plugins.

## Why It Is a Mediator Pattern
- **Centralized Control**: IDEPluginMediator acts as the single point of communication between all plugins.  
- **Decoupled Components**: Plugins only know about the mediator, not each other, reducing dependencies.  
- **Event-Driven Communication**: Plugins send events to the mediator (sendEvent), and the mediator decides which plugins should respond.  
- **Easily Extensible**: Adding a new plugin requires only registering it with the mediator without changing other plugins.

This example clearly demonstrates the Mediator pattern in a practical, real-world scenario where multiple components interact in a coordinated manner.

## Output Screenshot
<img width="547" height="237" alt="image" src="https://github.com/user-attachments/assets/bba896d5-d50f-4634-94a3-709693def6c4" />

