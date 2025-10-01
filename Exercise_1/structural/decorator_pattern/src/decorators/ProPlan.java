package src.decorators;
public class ProPlan extends Decorator {
    public ProPlan(src.component.AI ai) {
        super(ai);
    }

    @Override
    public void accessFeatures() {
        super.accessFeatures();
        System.out.println("Pro Plan: GPT-5 pro reasoning, unlimited messages/uploads, max memory & context, max deep research & agent mode, expanded projects/tasks/custom GPTs, advanced Sora & Codex, research preview-Rs.19,900 INR/(inclusive of GST)");
    }
}
