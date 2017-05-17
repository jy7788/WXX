package com.cn.hnust.model;

public class Person {
	private int id;
	private String personName;
	private String nickName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Person(int id, String personName, String nickName) {
		super();
		this.id = id;
		this.personName = personName;
		this.nickName = nickName;
	}
	public Person() {
	}
	
	
}
