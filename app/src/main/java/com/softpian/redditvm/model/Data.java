package com.softpian.redditvm.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Data{

	private List<ChildrenItem> children;

	private String before;

	private int dist;

	private String after;

	private int score;

	@Json(name = "num_comments")
	private int numComments;

	private String thumbnail;

	private double created;

	private String author;

	private String name;

	private String title;

	private String url;

	public void setChildren(List<ChildrenItem> children){
		this.children = children;
	}

	public List<ChildrenItem> getChildren(){
		return children;
	}

	public void setBefore(String before){
		this.before = before;
	}

	public Object getBefore(){
		return before;
	}

	public void setDist(int dist){
		this.dist = dist;
	}

	public int getDist(){
		return dist;
	}

	public void setAfter(String after){
		this.after = after;
	}

	public String getAfter(){
		return after;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}

	public void setNumComments(int numComments){
		this.numComments = numComments;
	}

	public int getNumComments(){
		return numComments;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setCreated(double created){
		this.created = created;
	}

	public double getCreated(){
		return created;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}