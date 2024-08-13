package Java_1.FinalProject1;

/**
 * Represents a service that can be listed in the catalog and included in an invoice.
 * Extends the BillableItem class, providing common attributes such as ID, description, and price.
 * @author greg.dawe
 */
public class Service extends BillableItem {

    /**
     * Enum representing different types of services along with their unique ID, description, and price.
     */
    public enum ServiceType {
        ASSEMBLY(14, "Computer Assembly", 125.00),
        DEFRAG_HDD(15, "Defrag Hard Drive", 25.00),
        REPAIR(16, "General Repair", 27.50);

        final int id;
        final String description;
        final double price;

        ServiceType(int id, String description, double price) {
            this.id = id;
            this.description = description;
            this.price = price;
        }
    }

    /**
     * Constructs a new Service with the specified ID, description, and price.
     * @param id          The unique identifier for the service.
     * @param description A brief description of the service.
     * @param price       The price of the service.
     */
    public Service(int id, String description, double price) {
        super(id, description, price);
    }
}
