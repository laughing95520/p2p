package com.wyh.p2p.entities;

/**
 * 友情链接类
 * 
 * @author Administrator
 * 
 */
public class Link {

	// id
	private Integer id;

	// 友情链接名称
	private String linkName;

	// 友情链接URL
	private String linkUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
