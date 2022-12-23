/**
 * Product class maintains the concept of a product in the application.
 * It encapsulates a the product's name, and its price
 */

public class Product {
    private int id;
    private String name;
    private double price;


    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getID() {
        return id;
    }
}

