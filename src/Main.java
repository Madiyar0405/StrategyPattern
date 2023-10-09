import java.util.Scanner;


public class Main{
public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        CartController controller = new CartController(cart, scanner);
        controller.run();
        }
}

class CartController {
    private ShoppingCart cart;
    private Scanner scanner;

    public CartController(ShoppingCart cart, Scanner scanner) {
        this.cart = cart;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Add an item to the cart");
            System.out.println("2. Choose a payment method");
            System.out.println("3. To pay");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItemToCart();
                    break;
                case 2:
                    choosePaymentMethod();
                    break;
                case 3:
                    cart.checkout();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    break;
            }
        }
    }

    private void addItemToCart() {
        System.out.print("Enter the product name:");
        String itemName = scanner.next();
        System.out.print("Enter the product price:");
        int itemPrice = scanner.nextInt();
        cart.addItem(new Item(itemName, itemPrice));
    }

    private void choosePaymentMethod() {
        System.out.println("Choose a payment method:");
        System.out.println("1. Credit card");
        System.out.println("2. PayPal");
        System.out.println("3. Bank transfer");
        int paymentChoice = scanner.nextInt();

        if (paymentChoice == 1) {
            System.out.print("Enter your credit card number: ");
            String cardNumber = scanner.next();
            System.out.print("Enter the name of the cardholder: ");
            String cardName = scanner.next();
            cart.setPaymentStrategy(new CreditCardPayment(cardNumber, cardName));
        } else if (paymentChoice == 2) {
            System.out.print("Enter your PayPal email address: ");
            String email = scanner.next();
            cart.setPaymentStrategy(new PayPalPayment(email));
        } else if (paymentChoice == 3) {
            System.out.print("Enter the bank account number: ");
            String bankAccount = scanner.next();
            cart.setPaymentStrategy(new BankTransferPayment(bankAccount));
        }
    }

    private void exit() {
        System.out.println("Exit the program.");
        System.exit(0);
    }
}
