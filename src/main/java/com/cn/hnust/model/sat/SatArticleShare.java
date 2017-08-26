package com.cn.hnust.model.sat;

import java.util.Date;

public class SatArticleShare {
	private String id;
	private String userId;
	private String articleId;
	private String advisId;
	private Date createTime;
	private int shares;
	private int stars;
	private int watches;
	private int advisClickCount;
	private Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getAdvisId() {
		return advisId;
	}
	public void setAdvisId(String advisId) {
		this.advisId = advisId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getWatches() {
		return watches;
	}
	public void setWatches(int watches) {
		this.watches = watches;
	}
	public int getAdvisClickCount() {
		return advisClickCount;
	}
	public void setAdvisClickCount(int advisClickCount) {
		this.advisClickCount = advisClickCount;
	}
}
