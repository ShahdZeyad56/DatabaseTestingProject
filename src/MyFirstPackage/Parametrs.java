package MyFirstPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class Parametrs 
{
 
    
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	Random rand=new Random();
	int RandomcustomerNumber=rand.nextInt(700,900);
    String[] names = {"Ali", "Sara", "Mohammed", "Lina", "Omar"};
    int RandomIndexName=rand.nextInt(names.length);
    String RandomName=names[RandomIndexName];
    
    //Al Queries:
    String QueryToAdd = "insert into customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) values (" 
            + RandomcustomerNumber + ", '" 
            + RandomName + "', '" 
            + RandomName + "', '" 
            + RandomName + "', '+1-555-1234567', '123 Tech Ave', 'Silicon Valley', 'USA')";


    String QueryToUpdate = "update customers set contactFirstName ='Shahd' where customerNumber =" + RandomcustomerNumber;
	String ReadQuery = "select * from customers where customerNumber = " + RandomcustomerNumber;
	String DeleteQuery ="delete from customers where customerNumber = " + RandomcustomerNumber;

	
	//String MyInsertQue
	
	public void MyConnection() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","dream");
	}
	

	

	
	
}
