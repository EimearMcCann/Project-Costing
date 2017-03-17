package classes;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

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

    public Customer(){
        customerID = nextCustID++;
        name = null;
        address = new Address();
        phone = null;
        email = null;
    }
    
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
    
    public void read(){
        try{
            name = JOptionPane.showInputDialog(null, "Enter the customer name", "Enter Name", JOptionPane.INFORMATION_MESSAGE);
            address.read();
            phone = JOptionPane.showInputDialog(null, "Enter the customers phone number", "Enter Phone Number", JOptionPane.INFORMATION_MESSAGE);
            email = JOptionPane.showInputDialog(null, "Enter the customers email", "Enter Email", JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

}
