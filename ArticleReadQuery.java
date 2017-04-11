package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;

public class ArticleReadQuery {

	private Connection connection;
	private ResultSet results;
	
	public ArticleReadQuery(String dbName, String uname, String pwd){
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
		String query = "select * from articles";
		
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
				Article article = new Article();
				article.setArticleID(this.results.getInt("articleID"));
				article.setTitle(this.results.getString("title"));
				article.setDescription(this.results.getString("description"));
				article.setDate(this.results.getInt("date"));
				article.setValidityRating(this.results.getDouble("validityRating"));
				article.setPartyAffected(this.results.getString("partyAffected"));
				article.setResponse(this.results.getString("response"));
				article.setResponseBy(this.results.getString("responseBy"));
				article.setResponseDesc(this.results.getString("responseDesc"));
				
				table +="<tr>";
				table +="<td>";
				table += article.getArticleID();
				table +="</td>";
				table +="<td>";
				table += article.getTitle();
				table +="</td>";
				table +="<td>";
				table += article.getDescription();
				table +="</td>";
				table +="<td>";
				table += article.getDate();
				table +="</td>";
				table +="<td>";
				table += article.getValidityRating();
				table +="</td>";
				table +="<td>";
				table += article.getPartyAffected();
				table +="</td>";
				table +="<td>";
				table += article.getResponse();
				table +="</td>";
				table +="<td>";
				table += article.getResponseBy();
				table +="</td>";
				table +="<td>";
				table += article.getResponseDesc();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update?articleID=" + article.getArticleID() + " >update</a> <a href=delete?articleID=" + article.getArticleID() + " >delete</a>";
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
