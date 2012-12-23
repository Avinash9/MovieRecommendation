package com.hashedIn.Model;

public class Ratings 
{
	private int userId;
	private int itemId;
	private int rating;
	private long timestamp;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "Ratings [userId=" + userId + ", itemId=" + itemId + ", rating="
				+ rating + ", timestamp=" + timestamp + "]";
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
