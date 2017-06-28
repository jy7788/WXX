package com.cn.hnust.model.pa;

public class PAUserRequest {
	private int id;
	private String openid;
	private int requesterId;
	private String requesterOpenid;
	private int role;
	private int requestStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}
	public String getRequesterOpenid() {
		return requesterOpenid;
	}
	public void setRequesterOpenid(String requesterOpenid) {
		this.requesterOpenid = requesterOpenid;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}
}
