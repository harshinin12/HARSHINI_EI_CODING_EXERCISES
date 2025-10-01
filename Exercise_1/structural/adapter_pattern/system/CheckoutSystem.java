package system;
import interfaces.PaymentProcessor;
import model.PaymentResponse;

public class CheckoutSystem {
    private PaymentProcessor processor;

    public CheckoutSystem(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void processOrder(double amount) {
        PaymentResponse response = processor.pay(amount);
        System.out.println(response);
    }
}
