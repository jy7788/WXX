package com.cn.hnust.model;

import java.util.Date;

public class WeixinQr {
	
	public final static int MAX_BASE_SNUM = 100000;
	
	public final static int REPASSWORD_TYPE = 1;
	public final static int SET_GROUP_TYPE = 2;
	public final static int TEMP_LOGIN = 11;
	public final static int TEMP_BIND = 12;
	
	private int id;
	private String name;
	private int type;
	private int status;
	private Integer snum;
	private String msg;
	
	private String qrData;
	private Date createDate;
	private String ticket;
	
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getSnum() {
		return snum;
	}
	public void setSnum(Integer snum) {
		this.snum = snum;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getQrData() {
		return qrData;
	}
	public void setQrData(String qrData) {
		this.qrData = qrData;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
