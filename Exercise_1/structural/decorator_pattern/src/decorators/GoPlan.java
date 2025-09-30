package src.decorators;

public class GoPlan extends Decorator {
    public GoPlan(src.component.AI ai) {
        super(ai);
    }

    @Override
    public void accessFeatures() {
        super.accessFeatures();
        System.out.println("Go Plan: GPT-5, expanded messaging & uploads, faster images, longer memory, limited deep research, projects/tasks/custom GPTs-Rs. 399 INR/(inclusive of GST)");
    }
}
