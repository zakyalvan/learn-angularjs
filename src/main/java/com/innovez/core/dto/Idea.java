package com.innovez.core.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Idea implements Serializable {
	private int id;
	private String title;
    private String description;
    private long votes;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public long getVotes() {
		return votes;
	}
	public void setVotes(long votes) {
		this.votes = votes;
	}   
}
