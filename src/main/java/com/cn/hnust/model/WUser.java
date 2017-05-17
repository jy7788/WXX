package com.cn.hnust.model;

import java.util.ArrayList;
import java.util.List;

public class WUser {
	private int subscribe;
	private String openid;
	private String nickname;
	private int sex;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	private long subscribe_time;
	private int groupid;
	private String remark;
	private String unionid;
	private String errorcode;
	
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	private List tagid_list = new ArrayList<>();
	
	public List getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(List tagid_list) {
		this.tagid_list = tagid_list;
	}
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public long getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public FiveBookUser getUser() {
		FiveBookUser u = new FiveBookUser();
		u.setBind(0);
		u.setImgUrl(this.getHeadimgurl());
		u.setNickname(this.getNickname());
		u.setOpenId(this.getOpenid());
		u.setSex(this.getSex());
		u.setStatus(1);
		u.setUsername(this.getOpenid());
		u.setPassword(this.getOpenid());
		u.setArea(this.getCountry());
		return u;
	}
}
