package com.stord.exercise.enums;

public enum Errors {

	SERVICE_LAYER_ERROR("srv_1", "Service Layer Error");

	private String errorCode;
	private String errorDescription;

	private Errors(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String errorCode() {
		return errorCode;
	}

	public String errorDescription() {
		return errorDescription;
	}

}
