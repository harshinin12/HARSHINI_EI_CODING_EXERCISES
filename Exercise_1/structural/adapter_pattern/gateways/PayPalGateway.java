package gateways;

public class PayPalGateway {
    public String makePayment(String email, double amount) {
        return "PayPal: $" + amount + " paid by " + email;
    }
}
