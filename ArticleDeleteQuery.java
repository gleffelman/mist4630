/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author craigpiercy
 *
 */
public class ArticleDeleteQuery {
	
	private Connection connection;
	
	public ArticleDeleteQuery(String dbName, String uname, String pwd){
		
		String url = "jdbc:mysql://localhost:3306/"+dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDelete(int articleID){
		// set up a String to hold our query
		String query = "delete from articles where articleID = ?";
		
		// create a preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			// fill in the preparedstatement
			ps.setInt(1, articleID);
			
			// execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
