/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;


/**
 * @author Kirk
 *
 */
public class UserReadQuery{
	
	private Connection connection;
	private ResultSet results;
	public UserReadQuery(String dbname, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbname;
		
		//set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRead(){
		String query = "select * from products";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table = "";
		table += "<table border =1>";
		
		try {
			while(this.results.next()){
				User user = new User();
				user.setEmail(this.results.getString("email"));
				user.setUpwd(this.results.getString("password"));
				

			
				table += "<tr>";
				table += "<td>";
				table +=user.getEmail();
				table += "</td>";
				table += "<td>";
				table +=user.getUpwd();
				table += "</td>";
				table +="</tr>";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table +="=</table>";
		return table;
	}
	
	}
