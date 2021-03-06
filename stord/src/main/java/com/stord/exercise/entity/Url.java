package com.stord.exercise.entity;

import javax.persistence.*;

@Entity
@Table(name = "url")
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String long_Url;

	@Column(nullable = true)
	private String short_Url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLongUrl() {
		return long_Url;
	}

	public void setLongUrl(String longUrl) {
		this.long_Url = longUrl;
	}

	public String getShortUrl() {
		return short_Url;
	}

	public void setShortUrl(String shortUrl) {
		this.short_Url = shortUrl;
	}

}
