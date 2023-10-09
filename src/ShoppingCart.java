import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void checkout() {
        if (paymentStrategy != null) {
            paymentStrategy.pay();
        } else {
            System.out.println("Select the payment method.");
        }
    }


}
