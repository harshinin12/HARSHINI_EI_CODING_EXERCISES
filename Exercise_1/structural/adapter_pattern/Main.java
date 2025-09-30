import adapters.PayPalAdapter;
import adapters.RazorpayAdapter;
import adapters.StripeAdapter;
import gateways.PayPalGateway;
import gateways.RazorpayGateway;
import gateways.StripeGateway;
import system.CheckoutSystem;

public class Main {
    public static void main(String[] args) {
        CheckoutSystem checkout1 = new CheckoutSystem(
        new PayPalAdapter(new PayPalGateway(), "harshinin78@gmail.com")
    );
    checkout1.processOrder(100);

    CheckoutSystem checkout2 = new CheckoutSystem(
        new RazorpayAdapter(new RazorpayGateway())
    );
    checkout2.processOrder(200);
    CheckoutSystem checkout3 = new CheckoutSystem(
        new StripeAdapter(new StripeGateway(),"411111111" )
    );
    checkout3.processOrder(400);
    }
}

