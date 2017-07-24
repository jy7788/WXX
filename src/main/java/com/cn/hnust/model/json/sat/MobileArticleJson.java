package com.cn.hnust.model.json.sat;

import java.util.List;

public class MobileArticleJson {
	private Object paginator;
	private List<ArticleJson> results;
	public Object getPaginator() {
		return paginator;
	}
	public void setPaginator(Object paginator) {
		this.paginator = paginator;
	}
	public List<ArticleJson> getResults() {
		return results;
	}
	public void setResults(List<ArticleJson> results) {
		this.results = results;
	}
}
