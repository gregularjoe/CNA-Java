package Java_1.FinalProject1;

/**
 * Represents an item on an invoice with a product and quantity.
 * @author greg.dawe
 */
public class InvoiceItem {
    private BillableItem billableItem;
    private int quantity;

    /**
     * Constructs a new InvoiceItem with the specified product and quantity.
     * @param billableItem   The product associated with the item.
     * @param quantity  The quantity of the product in the invoice item.
     */
    public InvoiceItem(BillableItem billableItem, int quantity) {
        this.billableItem = billableItem;
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    /**
     * Gets the billable item associated with this invoice item.
     * @return The billable item.
     */
    public BillableItem getBillableItem() {
        return billableItem;
    }

    /**
     * Sets the quantity of the product in the invoice item.
     * @param quantity The quantity of the product in the item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the quantity of the product in the invoice item.
     * @return The quantity of the product in the item.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Calculates and returns the total cost of the invoice item, which is the product's price multiplied by the quantity.
     * @return The total cost of the invoice item.
     */
    public double itemTotal() {
        return  billableItem.getPrice() * quantity;
    }
}
