package model;

public class PaymentResponse {
    private boolean success;
    private String message;

    public PaymentResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PaymentResponse { success=" + success + ", message='" + message + "' }";
    }
}

