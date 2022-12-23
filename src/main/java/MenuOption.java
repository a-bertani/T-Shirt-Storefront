/**
 * The enum Menu option
 */
public enum MenuOption {
    EXIT(0, "Exit"),
    LIST_PRODUCTS(1, "List Products"),
    BUY_PRODUCT(2, "Buy Product"),
    FIND_PRODUCT(3, "Find Product"),
    SHOW_CART(4, "Show Cart"),
    CHECKOUT(5, "Checkout");

    private int id;
    private String displayValue;

    /**
     * A MenuOption is initialized using a numeric id and its string representation.
     * @param id numeric id of the menu option
     * @param displayValue string id of the menu option
     */
    MenuOption(int id, String displayValue) {
        this.id = id;
        this.displayValue = displayValue;
    }

    public int getId() {
        return this.id;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    /**
     * Converts the passed in option id to a MenuOption if it has been defined.
     *
     * Throws an IllegalArgumentException if no match is found informing the caller.
     * @param optionId the option id to convert from
     * @return menu option matching the passed in id
     */
    public static MenuOption fromOptionId(int optionId) {
        for (MenuOption option : MenuOption.values()) {
            if (option.id == optionId) {
                return option;
            }
        }
        throw new IllegalArgumentException(String.format("Menu option id %d is not an available option.", optionId));
    }
}
