package src.decorators;
import src.component.AI;

public abstract class Decorator implements AI {
    protected AI ai;

    public Decorator(AI ai) {
        this.ai = ai;
    }

    @Override
    public void accessFeatures() {
        ai.accessFeatures();
    }
}
