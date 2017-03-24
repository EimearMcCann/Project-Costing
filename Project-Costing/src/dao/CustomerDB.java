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
    /**
     * Constructs a new connection to the database
     * @param username
     * @param pass 
     */
    public CustomerDB(String username, String pass) {
        super(username, pass);
    }

    // Methods
    /**
     * Reads a record from the database table based on the given primary key
     * @param id
     * @return Full record(object) from the table
     */
    public Customer read(int id) {
        Customer c = null;
        // if id exists in table,
        // then create query and create customer
        if (id > 0 && id < getLastID()) {
            try {
                // openconnection
                openConnection();
                // create query to read customer info
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

    /**
     * Writes a record to the database table
     * @param c 
     */
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

    /**
     * Updates an existing record in the table with the new information provided
     * @param c
     * @param id 
     */
    public void update(Customer c, int id) {
        if (c != null && (id > 0 && id < getLastID())) {
            try {
                // open connection to db
                openConnection();
                // create query to update customer info
                String query = makeUpdateQuery(id, c.getName(),
                        c.getAddress().getStreet(), c.getAddress().getTown(),
                        c.getAddress().getCounty(), c.getPhone(), c.getEmail());
                // execute query
                stmt.executeUpdate(query);
                System.out.println("success...updated record");
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                // close connection to db
                closeConnection();
            }
        }
    }

    /**
     * Deletes a record from the table if it exists in the table
     * @param id 
     */
    public void delete(int id) {
        if (id > 0 && id < getLastID()) {
            try {
                // open connection to db
                openConnection();
                // create query to delete customer info
                String query = makeDeleteQuery(id);
                // execute query
                stmt.executeUpdate(query);
                System.out.println("success...deleted ID: " + id + " from db");
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                // close connection to db
                closeConnection();
            }
        }
    }

    /**
     * Creates a query to select a record from the table
     * @param id
     * @return String query
     */
    private String makeSelectCustomer(int id) {
        String select = "SELECT Name, Street, Town, County, PhoneNo, Email "
                + "FROM project_costing.customer WHERE ID = " + id + ";";

        return select;
    }

    /**
     * Creates a query to update a record in the table
     * @param id
     * @param name
     * @param street
     * @param town
     * @param county
     * @param phone
     * @param email
     * @return String query
     */
    private String makeUpdateQuery(int id, String name, String street,
            String town, String county, String phone, String email) {
        // create update query
        String update = "UPDATE project_costing.customer "
                + " SET Name = '" + name + "', Street = '" + street
                + "', Town = '" + town + "', County = '" + county
                + "', PhoneNo = '" + phone + "', Email = '" + email + "'"
                + " WHERE ID = " + id + ";";

        return update;
    }

    /**
     * Creates a query to insert a record into the table
     * @param name
     * @param street
     * @param town
     * @param county
     * @param phone
     * @param email
     * @return String query
     */
    private String makeInsertQuery(String name, String street,
            String town, String county, String phone, String email) {
        // create insert query
        String insert = "INSERT INTO project_costing.customer "
                + "(Name, Street, Town, County, PhoneNo, Email) "
                + "VALUES ('" + name + "', '" + street + "', '" + town + "', '" 
                + county + "', '" + phone + "', '" + email + "');";

        return insert;
    }

    /**
     * Creates a query to delete a record based on the given primary key
     * @param id
     * @return String query
     */
    private String makeDeleteQuery(int id) {
        // create delete query
        String del = "DELETE FROM project_costing.customer "
                + "WHERE ID = " + id + ";";

        return del;
    }

    /**
     * Creates Customer database table
     *    if it does not exist
     */
    private void createCustomerTable() {
        //create table query
        String createTable = "CREATE TABLE IF NOT EXISTS customer "
                + "(ID INTEGER auto_increment not NULL, "
                + " Name VARCHAR(255), "
                + " Street VARCHAR(255), "
                + " Town VARCHAR(255), "
                + " County VARCHAR(255), "
                + " PhoneNo VARCHAR(255),"
                + " Email VARCHAR(255),"
                + " PRIMARY KEY ( ID ));";
        //create customer table
        try {
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            System.out.println("Table not created. " + e.getMessage());
        }
    }

    /**
     * Gets the last primary key used
     * @return Last primary key in the table
     */
    private int getLastID() {
        int id = 0;
        String query = "SELECT ID FROM customer ORDER BY ID DESC LIMIT 1;";
        try {
            openConnection();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Something wrong with count method. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something wrong with count method. " + e.getMessage());
        } finally {
            closeConnection();
        }
        return id;
    }
}
