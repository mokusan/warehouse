package com.jcry.warehouse.exceptions;

public class NotAuthorizedException extends RuntimeException {

	public NotAuthorizedException(String mensaje) {
		super(mensaje);
	}
}
