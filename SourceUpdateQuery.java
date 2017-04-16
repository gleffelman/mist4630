/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Source;

/**
 * @author craigpiercy
 *
 */
public class SourceUpdateQuery {
	
	private Connection connection;
	
	public SourceUpdateQuery(String dbName, String uname, String pwd){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdate(Source source){
		String query = "update sources set sourceName=?, sourceGroup=?, mediaCategory=?, sourceLocation=? where sourceID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, source.getSourceName());
			ps.setString(2, source.getSourceGroup() );
			ps.setString(3, source.getMediaCategory());
			ps.setString(4, source.getSourceLocation());
			ps.setInt(5, source.getSourceID());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
