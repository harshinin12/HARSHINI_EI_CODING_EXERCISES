package interfaces;

import model.PaymentResponse;

public interface PaymentProcessor {
    PaymentResponse pay(double amount);
}
