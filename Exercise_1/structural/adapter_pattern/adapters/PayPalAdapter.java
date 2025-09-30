package adapters;

import gateways.PayPalGateway;
import interfaces.PaymentProcessor;
import model.PaymentResponse;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;
    private String email;

    public PayPalAdapter(PayPalGateway gateway, String email) {
        this.gateway = gateway;
        this.email = email;
    }

    @Override
    public PaymentResponse pay(double amount) {
        String response = gateway.makePayment(email, amount);
        return new PaymentResponse(true, response);
    }
}
