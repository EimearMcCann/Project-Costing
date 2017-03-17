package classes;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

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
    public Address(){
        street = null;
        town = null;
        county = null;
    }
    
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
    
    public void read(){
        try{
            street = JOptionPane.showInputDialog(null, "Enter the street name", "Enter Street", JOptionPane.INFORMATION_MESSAGE);
            town = JOptionPane.showInputDialog(null, "Enter the town name", "Enter Town", JOptionPane.INFORMATION_MESSAGE);
            county = JOptionPane.showInputDialog(null, "Enter the county name", "Enter County", JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "street=" + street + ", town=" + town + ", county=" + county;
    }
    
}
