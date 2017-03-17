package classes;

/**
 * @author Marinus Toman Date: 16-Mar-2017
 */
public class Customer {
    // Instance Fields

    private static int nextCustID = 1;
    private final int customerID;
    private String name;
    private Address address;
    private String phone;
    private String email;

    public Customer(String name, Address address, String phone, String email) {
        customerID = nextCustID++;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }

    public static void setNextID(int id) {
        nextCustID = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

}
