
package Java_1.Assignment5;

/**
 * Represents an item on an invoice with a product and quantity.
 */
public class InvoiceItem {
    private Product product;
    private int quantity;

    /**
     * Constructs a new InvoiceItem with the specified product and quantity.
     *
     * @param product   The product associated with the item.
     * @param quantity  The quantity of the product in the invoice item.
     */
    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }

    /**
     * Sets the product associated with the invoice item.
     *
     * @param product The product to be associated with the item.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the product associated with the invoice item.
     *
     * @return The product associated with the item.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Sets the quantity of the product in the invoice item.
     *
     * @param quantity The quantity of the product in the item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the quantity of the product in the invoice item.
     *
     * @return The quantity of the product in the item.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Calculates and returns the total cost of the invoice item.
     *
     * @return The total cost of the invoice item, which is the product's price multiplied by the quantity.
     */
    public double getItemTotal() {
        double itemTotal = product.getPrice() * quantity;
        return itemTotal;
    }
}
