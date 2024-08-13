package Java_1.FinalProject1;

/**
 * The abstract class BillableItem represents an item that can be included in an invoice,
 * with properties such as ID, description, and price.
 * @author greg.dawe
 */
public abstract class BillableItem {
    private int id;
    private String description;
    private double price;

    /**
     * Constructs a BillableItem with the specified ID, description, and price.
     * Checks to make sure ID and price are greater than or equal to 0. If not, their value is set to 0.
     * @param id          The ID of the billable item.
     * @param description The description of the billable item.
     * @param price       The price of the billable item.
     */
    public BillableItem(int id, String description, double price) {
        if (id > 0) {
            this.id = id;
        }else if (id < 0 ) {
            this.id = 0;
        }
        this.description = description;
        if (price > 0) {
            this.price = price;
        } else if (price < 0) {
            this.price = 0;
        }
    }

    /**
     * Gets the ID of the billable item.
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the billable item.
     * Checks to make sure ID is greater than or equal to 0. If not, ID's value is set to 0.
     * @param id The new ID.
     */
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else if (id < 0) {
            this.id = 0;
        }
    }

    /**
     * Gets the description of the billable item.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the billable item.
     * @param description The new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the billable item.
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the billable item.
     * Makes sure price is greater than or equal to 0. If not price is set to 0.
     * @param price The new price.
     */
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else if (price < 0) {
            this.price = 0;
        }
    }
}
