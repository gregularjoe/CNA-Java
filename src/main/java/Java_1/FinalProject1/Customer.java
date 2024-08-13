package Java_1.FinalProject1;

/**
 * The Customer class represents information about a customer,
 * including their first name and last name.
 * @author greg.dawe
 */
public class Customer {
    private String firstName;
    private String lastName;

    /**
     * Constructor to initialize the customer's first name and last name.
     * @param firstName The first name of the customer.
     * @param lastName  The last name of the customer.
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the customer.
     * @return The customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the customer.
     * @return The customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     * @param lastName The new last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
