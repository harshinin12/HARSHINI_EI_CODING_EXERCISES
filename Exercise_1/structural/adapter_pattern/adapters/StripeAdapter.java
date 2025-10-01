package adapters;
import gateways.StripeGateway;
import interfaces.PaymentProcessor;
import model.PaymentResponse;

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway gateway;
    private String cardNumber;  

    public StripeAdapter(StripeGateway gateway, String cardNumber) {  // Corrected parameter name
        this.gateway = gateway;
        this.cardNumber = cardNumber;  
    }

    @Override
    public PaymentResponse pay(double amount) {
        String response = gateway.makePayment(cardNumber, amount);  // Use cardNumber here
        return new PaymentResponse(true, response);
    }
}
