/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

/**
 * @author Kirk
 *
 */
public class UserDeleteQuery {
	
private Connection connection;
	
	public UserDeleteQuery(String dbName, String uname, String pwd){
		
	String url = "jdbc:mysql://localhost:3306/"+dbName;
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url, uname, pwd);
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void doDelete(String email){
		//set up a string to hold our query
		String query = "delete from user where email = ?";
		
		//create e preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			//fill in the preparedstatement
			ps.setString(1, email);
			
			//execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

