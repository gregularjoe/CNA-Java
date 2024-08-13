package Java_1.FinalProject1;

/**
 * The org.Address class represents a physical address with street information,
 * postal code, city, province, and country details.
 * @author greg.dawe
 */
public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    /**
     * Constructs an org.Address object with the specified details.
     * @param streetAddress The street address.
     * @param postalCode    The postal code.
     * @param city          The city.
     * @param province      The province.
     * @param country       The country.
     */
    public Address(String streetAddress, String postalCode, String city, String province, String country) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    /**
     * Gets the street address.
     * @return The street address.
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the street address.
     * @param streetAddress The new street address.
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets the postal code.
     * @return The postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     * @param postalCode The new postal code.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the city.
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * @param city The new city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the province.
     * @return The province.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province.
     * @param province The new province.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the country.
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     * @param country The new country.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
