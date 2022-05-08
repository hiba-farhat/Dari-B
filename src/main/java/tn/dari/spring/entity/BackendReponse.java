package tn.dari.spring.entity;

import java.io.Serializable;

public class BackendReponse implements Serializable {
	private  int statusCode;
	private String message;
	public BackendReponse() {

	}
	
	public BackendReponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BackendReponse [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
	
	
}
