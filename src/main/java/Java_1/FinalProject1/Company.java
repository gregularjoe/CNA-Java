package Java_1.FinalProject1;

/**
 * The Company class represents information about a company, including its name,
 * address, contact details, etc.
 * It also provides a static method to retrieve default company information.
 * @author greg.dawe
 */
public class Company {
    private final String companyName;
    private final String companyStreetAddress;
    private final String companyPostalCode;
    private final String companyCity;
    private final String companyProvince;
    private final String companyCountry;
    private final String companyPhone;
    private final String companyEmail;

    /**
     * Constructor to initialize the company details.
     * @param companyName         The name of the company.
     * @param companyStreetAddress The street address of the company.
     * @param companyPostalCode    The postal code of the company.
     * @param companyCity          The city where the company is located.
     * @param companyProvince      The province where the company is located.
     * @param companyCountry       The country where the company is located.
     * @param companyPhone         The phone number of the company.
     * @param companyEmail         The email address of the company.
     */
    public Company(String companyName, String companyStreetAddress, String companyPostalCode, String companyCity, String companyProvince, String companyCountry, String companyPhone, String companyEmail) {
        this.companyName = companyName;
        this.companyStreetAddress = companyStreetAddress;
        this.companyPostalCode = companyPostalCode;
        this.companyCity = companyCity;
        this.companyProvince = companyProvince;
        this.companyCountry = companyCountry;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
    }


    /**
     * Gets the name of the company.
     * @return The company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Gets the street address of the company.
     * @return The company street address.
     */
    public String getCompanyStreetAddress() {
        return companyStreetAddress;
    }

    /**
     * Gets the postal code of the company.
     * @return The postal code.
     */
    public String getCompanyPostalCode() {
        return companyPostalCode;
    }

    /**
     * Gets the City where the company is located.
     * @return The City.
     */
    public String getCompanyCity() {
        return companyCity;
    }

    /**
     * Gets the Province where the company is located.
     * @return The province.
     */
    public String getCompanyProvince() {
        return companyProvince;
    }

    /**
     * Gets the Country where the company is located.
     * @return The country.
     */
    public String getCompanyCountry() {
        return companyCountry;
    }

    /**
     * Gets the phone number of the company.
     * @return The phone number.
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * Gets the email address of the company.
     * @return The email address.
     */
    public String getCompanyEmail() {
        return companyEmail;
    }

    /**
     * Gets the default information of the company.
     * @return A Company object with default information.
     */
    public static Company getCompanyInfo() {
        return new Company(
                "Classic Computer Company",
                "543 Techno Paradise Road",
                "A2E 1E0",
                "St. John's",
                "NL",
                "Canada",
                "1-709-770-9696",
                "ccc@yahoo.ca");
    }
}
