package config;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MyConnection {
	
	public static Connection getConnection()
	{
		try {
			 //FileReader reader = new FileReader("db.properties");
			  
		      // create properties object
		      //Properties p = new Properties();

		      // Add a wrapper around reader object
		      //p.load(reader);
		      
		      Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Uma@2sahina");
		      return con;
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				return null;
			}
	}

}
