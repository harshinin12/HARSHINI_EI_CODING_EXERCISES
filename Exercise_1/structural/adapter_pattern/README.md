# Adapter Design Pattern - Payment Gateway Integration

## 1. Overview
This project demonstrates the Adapter Design Pattern in Java by integrating multiple payment gateways into a single checkout system. The Adapter Pattern allows us to use incompatible interfaces together without modifying the existing code of the gateways.


## 2. Use Case
In an e-commerce platform, we want a single checkout system to support multiple payment gateways like **PayPal, Stripe, and Razorpay**.  
Each gateway has its **own method signature** for processing payments:

- PayPal: makePayment(String email, double amount) 
- Stripe: makePayment(String cardNumber, double amount)  
- Razorpay: makePayment(double amount)

Instead of modifying the checkout system every time a new gateway is added, we create adapter classes for each gateway. The checkout system interacts with a common interface, PaymentProcessor, ensuring flexibility and scalability.

**Example Flow:**
```java
CheckoutSystem checkout = new CheckoutSystem(
    new PayPalAdapter(new PayPalGateway(), "user@example.com")
);
checkout.processOrder(100);
