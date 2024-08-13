
package Java_1.Assignment5;

/**
 * Represents a product with an ID, description, and price.
 */
public class Product {
    private int id;
    private String description;
    private double price;

    /**
     * Constructs a new Product with the specified ID, description, and price.
     *
     * @param id          The unique identifier for the product.
     * @param description The description of the product.
     * @param price       The price of the product.
     */
    public Product(int id, String description, double price) {
        if (id < 0) {
            id = 0;
        }
        this.id = id;
        this.description = description;
        if (price < 0) {
            price = 0;
        }
        this.price = price;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The unique identifier for the product.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the product.
     *
     * @return The unique identifier for the product.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the description of the product.
     *
     * @param description The description of the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return this.price;
    }
}
