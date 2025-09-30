package gateways;

public class StripeGateway {
public String makePayment(String CardNumber, double amount) {
        return "Stripe: $" + amount + " paid by the user";
    }
}
