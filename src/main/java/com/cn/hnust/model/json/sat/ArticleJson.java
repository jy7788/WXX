package com.cn.hnust.model.json.sat;

import java.util.List;

public class ArticleJson {
	private String type;
	private int id;
	private String title;
	private String localType;
	private long createdAt;
	private String summary;
	private String url;
	private DescImgJson img;
	private List tags;
	private Object user;
	private int commentCount;
	private Object sourceName;
	private Object resource;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public String getLocalType() {
		return localType;
	}
	public void setLocalType(String localType) {
		this.localType = localType;
	}
	public long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public DescImgJson getImg() {
		return img;
	}
	public void setImg(DescImgJson img) {
		this.img = img;
	}
	public List getTags() {
		return tags;
	}
	public void setTags(List tags) {
		this.tags = tags;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public Object getSourceName() {
		return sourceName;
	}
	public void setSourceName(Object sourceName) {
		this.sourceName = sourceName;
	}
	public Object getResource() {
		return resource;
	}
	public void setResource(Object resource) {
		this.resource = resource;
	}
}
