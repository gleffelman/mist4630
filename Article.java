package model;

public class Article {

	private int articleID;
	private String title;
	private String description;
	private int date;
	private double validityRating;
	private String partyAffected;
	private char response;
	private String responseBy;
	private String responseDesc;
	
	public Article(int articleID, String title, String description, int date, double validityRating, String partyAffected, char response, String responseBy, String responseDesc) {
		this.articleID = articleID;
		this.title = title;
		this.description = description;
		this.date = date;
		this.validityRating = validityRating;
		this.partyAffected = partyAffected;
		this.response = response;
		this.responseBy = responseBy;
		this.responseDesc = responseDesc;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public double getValidityRating() {
		return validityRating;
	}

	public void setValidityRating(double validityRating) {
		this.validityRating = validityRating;
	}

	public String getPartyAffected() {
		return partyAffected;
	}

	public void setPartyAffected(String partyAffected) {
		this.partyAffected = partyAffected;
	}

	public char getResponse() {
		return response;
	}

	public void setResponse(char response) {
		this.response = response;
	}

	public String getResponseBy() {
		return responseBy;
	}

	public void setResponseBy(String responseBy) {
		this.responseBy = responseBy;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	
}
