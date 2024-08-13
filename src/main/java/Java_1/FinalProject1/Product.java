package Java_1.FinalProject1;

/**
 * Represents a product that can be listed in the catalog and included in an invoice.
 * Extends the BillableItem class, providing common attributes such as ID, description, and price.
 * @author greg.dawe
 */
public class Product extends BillableItem {

    /**
     * Constructs a new Product with the specified ID, description, and price.
     * @param id          The unique identifier for the product.
     * @param description A brief description of the product.
     * @param price       The price of the product.
     */
    public Product(int id, String description, double price) {
        super(id, description, price);
    }
}
