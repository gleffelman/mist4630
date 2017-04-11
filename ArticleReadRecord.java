/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;

/**
 * @author craigpiercy
 *
 */
public class ArticleReadRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Article article = new Article();
	private int articleID;
	
	public ArticleReadRecord(String dbName, String uname, String pwd, int articleID){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.articleID = articleID;
		
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
		String query = "select * from articles where articleID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.articleID);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			article.setArticleID(this.results.getInt(1));
			article.setTitle(this.results.getString("title"));
			article.setDescription(this.results.getString("description"));
			article.setDate(this.results.getInt("date"));
			article.setValidityRating(this.results.getDouble("validityRating"));
			article.setPartyAffected(this.results.getString("partyAffected"));
			article.setResponse(this.results.getString("response"));
			article.setResponseBy(this.results.getString("responseBy"));
			article.setResponseDesc(this.results.getString("responseDesc"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Article getArticle(){
		return this.article;
	}
	
	

}
