package classes;

/**
 * @author Marinus Toman
 * Date: 16-Mar-2017
 */
public class Address {
    // Instance Fields
    private String street;
    private String town;
    private String county;
    
    // Constructors
    public Address(String street, String town, String county){
        this.street = street;
        this.town = town;
        this.county = county;
    }

    // Methods
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "street=" + street + ", town=" + town + ", county=" + county;
    }
    
}
