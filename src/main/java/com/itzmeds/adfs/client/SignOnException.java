package com.itzmeds.adfs.client;

@SuppressWarnings("serial")
public class SignOnException extends Exception {

	public SignOnException() {
	}

	public SignOnException(String message) {
		super(message);
	}

	public SignOnException(Throwable cause) {
		super(cause);
	}

	public SignOnException(String message, Throwable cause) {
		super(message, cause);
	}

	public SignOnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
