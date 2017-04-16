package model;

public class Source {
	private int sourceID;
	private String sourceName;
	private String sourceGroup;
	private String mediaCategory;
	private String sourceLocation;
	
	public Source(int sourceID, String sourceName, String sourceGroup, String mediaCategory, String sourceLocation) {
		this.sourceID = sourceID;
		this.sourceName = sourceName; 
		this.sourceGroup = sourceGroup; 
		this.mediaCategory = mediaCategory; 
		this.sourceLocation = sourceLocation; 
	}

	public int getSourceID() {
		return sourceID;
	}

	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceGroup() {
		return sourceGroup;
	}

	public void setSourceGroup(String sourceGroup) {
		this.sourceGroup = sourceGroup;
	}

	public String getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(String mediaCategory) {
		this.mediaCategory = mediaCategory;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
}
