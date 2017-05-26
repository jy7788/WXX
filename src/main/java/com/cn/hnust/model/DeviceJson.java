package com.cn.hnust.model;

public class DeviceJson {
	private String msg;
	private String ip;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public DeviceJson() {
	}
	public DeviceJson(String msg, String ip) {
		super();
		this.msg = msg;
		this.ip = ip;
	}
}
