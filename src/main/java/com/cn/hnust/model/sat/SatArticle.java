package com.cn.hnust.model.sat;

import java.util.Date;

public class SatArticle {
	private String id;
	private String title;
	private String content;
	//private String openid;
	private int stars;
	private int shares;
	private int watches;
	private Date createTime;
	private Date updateTime;
	private String url;
	private String descImgUrl;
	private String articleId;
	//private int type;
	
	public String getUrl() {
		return url;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescImgUrl() {
		return descImgUrl;
	}
	public void setDescImgUrl(String descImgUrl) {
		this.descImgUrl = descImgUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public int getWatches() {
		return watches;
	}
	public void setWatches(int watches) {
		this.watches = watches;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
