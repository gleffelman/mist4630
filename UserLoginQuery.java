/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import models.User;

/**
 * @author Kirk
 *
 */
public class UserLoginQuery {
	
public Connection connection;
	
	public UserLoginQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doLogin(User user){
		//String url = "/UserLoginServlet";
		String query = "IF EXISTS (SELECT * FROM user WHERE email = ? AND upwd = ?";
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//this.results = ps.executeQuery();
			
			ps.setString(1,  user.getEmail());
			ps.setString(2, user.getUpwd());
			
			ps.executeQuery();
			
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
