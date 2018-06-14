package com.softpian.redditvm.model;

public class ChildrenItem{

	private Data data;

	private String kind;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}
}