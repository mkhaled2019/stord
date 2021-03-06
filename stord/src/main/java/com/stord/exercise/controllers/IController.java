package com.stord.exercise.controllers;

import com.stord.exercise.enums.Errors;
import com.stord.exercise.response.AbstractResponse;
import com.stord.exercise.response.Error;

public interface IController {

	default void setError(AbstractResponse response, Errors errors) {
		Error error = new Error(errors.errorCode(), errors.errorDescription());
		response.setError(error);
	}
}
