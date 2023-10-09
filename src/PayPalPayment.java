class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay() {
        System.out.println("Paid with PayPal: " + email);
    }
}