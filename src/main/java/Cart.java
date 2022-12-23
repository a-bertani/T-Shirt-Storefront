import java.util.ArrayList;

/**
 * Cart class is responsible for managing the contents of the cart
 */
public class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total = 0;
    private double taxRate = 0.10;


    /**
     * Class constructor initializes the cart with an empty list of items,
     * total value of 0, and a tax rate of 10%
     */
    public Cart() {
    }

    /**
     * Prints a message notifying the user of an empty cart, when it contains no items
     *
     * When the cart has items, prints:
     * - number of items in the cart
     * - items one by one with their prices before tax
     * - before-tax total of all items
     * - after-tax total of all items
     */
    public void showDetails() {
        StringBuilder detailsSb = new StringBuilder();
        if (items.isEmpty()) {
            detailsSb.append(String.format("The cart is empty. " +
                    "Please add at least one product to see it in the cart.%n"));
        } else {
            appendCartHeaderToStringBuilder(detailsSb);
            appendItemsWithPricesToStringBuilder(detailsSb);
            appendCartTotalsToStringBuilder(detailsSb);
        }

        System.out.print(detailsSb);
    }

    /**
     * Add Product to the cart's items.
     * Prints a confirmation of Product being added.
     * Updates before-tax total of all items with added Product's price.
     *
     * @param p Product to add to the cart
     */
    public void addItem(Product p) {
        items.add(p);
        total += p.getPrice();
        System.out.println(String.format("%s has been added to your cart.", p.getName()));
    }

    /**
     * Checkout the cart.
     *
     * If the cart is empty, prints message to shopper asking them to add at least one product.
     * Otherwise:
     * Prints a message with the after-tax total of the checked out items.
     * Resets internal pre-tax total to 0.
     * Clears all items from the cart.
     * @return true if checkout is successful. False if not.
     */
    public boolean checkout() {
        if (items.size() == 0) {
            System.out.println("Your cart is currently empty. Please add at least one product to check out.");
            return false;
        }

        System.out.println(
                String.format("Your total is $%.2f", total * (1 + taxRate))
        );
        total = 0;
        items.clear();
        return true;
    }

    /**
     * Prints the cart header.
     */
    private void appendCartHeaderToStringBuilder(StringBuilder sb) {
        sb.append(String.format("--Cart--%n"));
        sb.append(String.format("Item Count: %d%n", items.size()));
    }

    /**
     * Prints all items in the cart with their prices.
     */
    private void appendItemsWithPricesToStringBuilder(StringBuilder sb) {
        sb.append(String.format("Items:%n"));
        for (Product p : items) {
            sb.append(
                    String.format(
                            "%s: $%.2f%n",
                            p.getName(),
                            p.getPrice()
                    )
            );
        }
        sb.append(String.format("%n"));
    }

    /**
     * Prints pre-tax total and after-tax total.
     *
     * Uses internal total and taxRate for calculations.
     */
    private void appendCartTotalsToStringBuilder(StringBuilder sb) {
        sb.append(
                String.format(
                        "%s: $%.2f%n",
                        "Pre-Tax Total",
                        total
                )

        );
        sb.append(
                String.format(
                        "%s (%.2f%% Tax): $%.2f%n",
                        "Post-Tax Total",
                        taxRate * 100,
                        total * (1 + taxRate)
                )
        );
    }
}

