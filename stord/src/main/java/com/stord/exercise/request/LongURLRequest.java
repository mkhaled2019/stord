package com.stord.exercise.request;

import io.swagger.annotations.ApiModelProperty;

public class LongURLRequest extends AbstractRequest {

	@ApiModelProperty(required = true, notes = "short Url to be converted to long URL")
	private String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
