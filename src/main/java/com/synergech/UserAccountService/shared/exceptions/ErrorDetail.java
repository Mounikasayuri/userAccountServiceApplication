package com.synergech.UserAccountService.shared.exceptions;

public class ErrorDetail {
	private String message;

	public ErrorDetail(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
