package edu.eci.pdsw.DynamicWebIntroduction.models;

public class Todo {
	
	private Integer id, userId;
	private String title;
	private boolean completed;
	
	public Todo() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userId=" + userId + ", title=" + title + ", completed=" + completed + "]";
	}

}
