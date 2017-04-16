/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Source;

/**
 * @author craigpiercy
 *
 */
public class SourceReadRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Source source = new Source();
	private int sourceID;
	
	public SourceReadRecord(String dbName, String uname, String pwd, int sourceID){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.sourceID = sourceID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doRead(){
		String query = "select * from sources where sourceID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.sourceID);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			source.setSourceID(this.results.getInt(1));
			source.setSourceName(this.results.getString("sourceName"));
			source.setSourceGroup(this.results.getString("sourceGroup"));
			source.setMediaCategory(this.results.getString("mediaCategory"));
			source.setSourceLocation(this.results.getString("sourceLocation"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Source getSource(){
		return this.source;
	}
	
	

}
