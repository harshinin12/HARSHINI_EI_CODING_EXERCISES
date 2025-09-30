package gateways;

public class RazorpayGateway{
    public String makePayment(double amount) {
        return "Razorpay Txn of INR " + amount + " done.";
    }
}
