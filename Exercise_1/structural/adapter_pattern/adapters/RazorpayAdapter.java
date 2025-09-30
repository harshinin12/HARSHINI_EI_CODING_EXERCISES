package adapters;

import gateways.RazorpayGateway;
import interfaces.PaymentProcessor;
import model.PaymentResponse;

public class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PaymentResponse pay(double amount) {
        String response = gateway.makePayment(amount);
        return new PaymentResponse(true, response);
    }
}
