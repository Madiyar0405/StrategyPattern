class BankTransferPayment implements PaymentStrategy {
    private String bankAccount;

    public BankTransferPayment(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void pay() {
        System.out.println("Paid with bank transfer: " + bankAccount);
    }
}