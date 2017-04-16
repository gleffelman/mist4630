package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Source;

public class SourceReadQuery {

	private Connection connection;
	private ResultSet results;
	
	public SourceReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
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
		String query = "select * from sources";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table ="";
		table += "<table border=1>";
		
		try {
			while(this.results.next()){
				Source source = new Source();
				source.setSourceID(this.results.getInt("sourceID"));
				source.setSourceName(this.results.getString("sourceName"));
				source.setSourceGroup(this.results.getString("sourceGroup"));
				source.setMediaCategory(this.results.getString("mediaCateogry"));
				source.setSourceLocation(this.results.getString("sourceLocation"));
				
				table +="<tr>";
				table +="<td>";
				table += source.getSourceID();
				table +="</td>";
				table +="<td>";
				table += source.getSourceName();
				table +="</td>";
				table +="<td>";
				table += source.getSourceGroup();
				table +="</td>";
				table +="<td>";
				table += source.getMediaCategory();
				table +="</td>";
				table +="<td>";
				table += source.getSourceLocation();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update?sourceID=" + source.getSourceID() + " >update</a> <a href=delete?sourceID=" + source.getSourceID() + " >delete</a>";
				table +="</td>";
				table +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
}
