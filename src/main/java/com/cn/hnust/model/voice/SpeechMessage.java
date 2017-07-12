package com.cn.hnust.model.voice;

import java.util.List;

public class SpeechMessage {
	private String bg;
	private String ed;
	private String nc;
	private String onebest;
	private String si;
	private String speaker;
	private List<WordResult> wordsResultList;
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public String getEd() {
		return ed;
	}
	public void setEd(String ed) {
		this.ed = ed;
	}
	public String getNc() {
		return nc;
	}
	public void setNc(String nc) {
		this.nc = nc;
	}
	public String getOnebest() {
		return onebest;
	}
	public void setOnebest(String onebest) {
		this.onebest = onebest;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public List<WordResult> getWordsResultList() {
		return wordsResultList;
	}
	public void setWordsResultList(List<WordResult> wordsResultList) {
		this.wordsResultList = wordsResultList;
	}
}
