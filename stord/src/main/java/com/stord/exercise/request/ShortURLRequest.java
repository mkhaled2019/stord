package com.stord.exercise.request;

import io.swagger.annotations.ApiModelProperty;

public class ShortURLRequest extends AbstractRequest {

	@ApiModelProperty(required = true, notes = "long Url to be converted to short URL")
	private String longUrl;

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
}
