package org.dk.exception;

public class LoadResource extends RuntimeException {
	public LoadResource(String message) {
		super(message);
	}

	public LoadResource(String message, Throwable cause) {
		super(message, cause);
	}
}
