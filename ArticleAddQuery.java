/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Article;

/**
 * @author craigpiercy
 *
 */
public class ArticleAddQuery {
	
	public Connection connection;
	
	public ArticleAddQuery(String dbName, String uname, String pwd){
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
	
	public void doAdd(Article article){
		String query = "insert into article (title, description, date, validityRating, partyAffected, response, responseBy, responseDesc) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getDescription());
			ps.setInt(3, article.getDate());
			ps.setDouble(4, article.getValidityRating());
			ps.setString(5, article.getPartyAffected());
			ps.setString(6, article.getResponse());
			ps.setString(7, article.getResponseBy());
			ps.setString(8, article.getResponseDesc());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
