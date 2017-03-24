package dao;

import classes.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Marinus Toman Date: 17-Mar-2017
 */
public class CustomerDB extends DBHandler {
    // Instance Fields

    // Constructors
    public CustomerDB(String user, String pass) {
        super(user, pass);
    }

    // Methods
    public Customer read(int id) {
        Customer c = null;
        // if id exists in table,
        // then create query and create customer
        if (id > 0) {
            try {
                // openconnection
                openConnection();
                // create query
                String query = makeSelectCustomer(id);
                // get results and pass cursor over first row
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                // set next customer id to avoid conflicts
                Customer.setNextID(id);
                // create customer based on results
                c = new Customer(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
            } catch (SQLException e) {
                System.out.println("Problem with SQL.\n" + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnection();
            }
        }
        return c;
    }

    public void write(Customer c) {
        if (c != null) {
            try {
                // open connection to db
                openConnection();
                // create table if it doesnt exist
                createCustomerTable();
                // create query to insert customer info
                String query = makeInsertQuery(c.getName(), 
                        c.getAddress().getStreet(), c.getAddress().getTown(), 
                        c.getAddress().getCounty(), c.getPhone(), c.getEmail());
                // execute query
                stmt.executeUpdate(query);
                System.out.println("success...written to db");
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnection();
            }
        }
    }
    
    public void update(Customer c, int id){
        if (c != null && id > 0) {
            try {
                // open connection to db
                openConnection();
                // create query to insert customer info
                String query = makeUpdateQuery(id, c.getName(), 
                        c.getAddress().getStreet(), c.getAddress().getTown(), 
                        c.getAddress().getCounty(), c.getPhone(), c.getEmail());
                // execute query
                stmt.executeUpdate(query);
                System.out.println("success...written to db");
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnection();
            }
        }
    }

    private static String makeSelectCustomer(int id) {
        String select = "SELECT Name, Street, Town, County, PhoneNo, Email "
                + "FROM project_costing.customer WHERE ID = " + id + ";";

        return select;
    }

    private static String makeUpdateQuery(int id, String name, String street, String town, String county, String phone, String email) {
        String insert = "UPDATE project_costing.customer "
                + " SET Name = '" + name + "', Street = '" + street 
                + "', Town = '" + town + "', County = '" + county 
                + "', PhoneNo = '" + phone + "', Email = '" + email + "'"
                + " WHERE ID = " + id + ";";

        return insert;
    }
    
    private static String makeInsertQuery(String name, String street, String town, String county, String phone, String email){
        String insert = "INSERT INTO project_costing.customer (Name, Street, Town, County, PhoneNo, Email) "
                + "VALUES ('" + name + "', '" + street + "', '" + town + "', '" + county + "', '" + phone + "', '" + email + "');";

        return insert;
    }

    private void createCustomerTable() {
        //create table
        String createTable = "CREATE TABLE IF NOT EXISTS customer "
                + "(CustomerID INTEGER auto_increment not NULL, "
                + " Name VARCHAR(255), "
                + " Street VARCHAR(255), "
                + " Town VARCHAR(255), "
                + " County VARCHAR(255), "
                + " PhoneNo VARCHAR(255),"
                + " Email VARCHAR(255),"
                + " PRIMARY KEY ( CustomerID ));";
        //create customer table
        try {
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            System.out.println("Table not created. " + e.getMessage());
        }
    }

    private int getCount() {
        int rows = 0;
        String query = "SELECT COUNT(ID) FROM customer;";
        try {
            openConnection();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            rows = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Something wrong with count method. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something wrong with count method. " + e.getMessage());
        } finally {
            closeConnection();
        }
        return rows;
    }
}
