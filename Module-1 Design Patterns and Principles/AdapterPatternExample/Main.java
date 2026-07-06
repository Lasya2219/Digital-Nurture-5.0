package AdapterPatternExample;

public class Main {
    public static void main(String[] args) {
        GooglePay googlePay = new GooglePay();
        PhonePay phonePay = new PhonePay();

        PaymentProcessor paymentProcessor = new GpayAdapter(googlePay);
        PaymentProcessor phonePayProcessor = new PhonePayAdapter(phonePay);

        paymentProcessor.processPayment(500.0);
        phonePayProcessor.processPayment(300.0);
    }
}
