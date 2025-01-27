package MyFirstPackage;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parametrs {

    // This method sets up the database connection before running the tests
    @BeforeTest
    public void mySetup() throws SQLException {
        MyConnection(); // Establish a connection to the database
    }

    //---------------------------------------------------------------------------------    
    // Test Case 1: Adding a new customer to the database
    @Test(priority = 1)
    public void AddNewCustomer() throws SQLException {

        stmt = con.createStatement(); // Create a statement object
        stmt.executeUpdate(QueryToAdd); // Execute the SQL query to insert the record
        int effectedRow = stmt.executeUpdate(QueryToAdd);
		Assert.assertEquals(effectedRow, 1);
    }

    //---------------------------------------------------------------------------------    
    // Test Case 2: Updating a customer's information in the database
    @Test(priority = 2, enabled = true)
    public void UpdateCustomerInfo() throws SQLException {

        stmt = con.createStatement(); // Create a statement object
        int effectedRow = stmt.executeUpdate(QueryToUpdate); // Execute the update query and get the number of affected rows
		Assert.assertEquals(effectedRow, 1);

    }

    //--------------------------------------------------------------------------------    
    // Test Case 3: Reading and displaying data for customers with customerNumber > 110
    @Test(priority = 3)
    public void ReadTheUpdatedData() throws SQLException {

       
        stmt = con.createStatement(); // Create a statement object
        rs = stmt.executeQuery(ReadQuery); // Execute the query and store the result set

        // Loop through the result set to display customer details
        while (rs.next()) {
            String contactFirstNmae = rs.getString("contactFirstName"); // Get the customer's first name
            int contactId = Integer.parseInt(rs.getString("customerNumber")); // Get the customer's ID
            String CityOfThecustomer = rs.getString("city"); // Get the customer's city

            // Print the retrieved details
            System.out.println(contactFirstNmae);
            System.out.println(contactId);
            System.out.println(CityOfThecustomer);
        }
    }

    //--------------------------------------------------------------------------------
    // Test Case 4: Deleting a customer from the database
    @Test(priority = 4, enabled = true)
    public void DeleteCustomer() throws SQLException {

        // SQL query to delete a customer record using the customer number
   
        stmt = con.createStatement(); // Create a statement object
        int effectedRow = stmt.executeUpdate(DeleteQuery); // Execute the delete query and get the number of affected rows
        Assert.assertEquals(effectedRow, 1);
        // Print the number of affected rows for confirmation
        System.out.println(effectedRow);
    }
}
