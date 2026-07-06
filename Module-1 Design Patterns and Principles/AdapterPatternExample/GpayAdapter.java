package AdapterPatternExample;

public class GpayAdapter implements PaymentProcessor {
    private GooglePay googlePay;

    public GpayAdapter(GooglePay googlePay) {
        this.googlePay = googlePay;
    }

    @Override
    public void processPayment(double amount) {
        googlePay.makePayment(amount);
    }
    
}
