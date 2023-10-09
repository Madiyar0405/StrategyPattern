class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardName;

    public CreditCardPayment(String cardNumber, String cardName) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
    }

    public void pay() {
        System.out.println("Paid with credit card: " + cardNumber + " (Cardholder: " + cardName + ")");
    }
}