package src.decorators;

public class BusinessPlan extends Decorator {
    public BusinessPlan(src.component.AI ai) {
        super(ai);
    }

    @Override
    public void accessFeatures() {
        super.accessFeatures();
        System.out.println("Business Plan: All Plus features + higher limits, unlimited model access, videos/images/code generation, team tools, advanced security & privacy, Sharepoint integration, meeting & voice transcription--Rs. 2099 INR/(inclusive of GST)");
    }
}
