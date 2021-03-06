package com.stord.exercise.response;

public abstract class AbstractResponse {

	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
