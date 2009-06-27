package com.alexbleasdale.exception;

public class DataNotFound extends Exception {

	private static final long serialVersionUID = 364137301820682799L;

	public DataNotFound(String message) {
		super(message);
	}

	public DataNotFound(String message, Throwable cause) {
		super(message, cause);
	}

}
