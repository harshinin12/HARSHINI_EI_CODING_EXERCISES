package src.decorators;
public class PlusPlan extends Decorator {
    public PlusPlan(src.component.AI ai) {
        super(ai);
    }

    @Override
    public void accessFeatures() {
        super.accessFeatures();
        System.out.println("Plus Plan: GPT-5 advanced reasoning, expanded messaging/uploads, faster images, expanded memory/context, deep research & agent mode, Sora video generation, Codex agent.-Rs. 1,999 INR/(inclusive of GST)");
    }
}
