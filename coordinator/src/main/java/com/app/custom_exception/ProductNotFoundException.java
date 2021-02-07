package com.app.custom_exception;

//@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String mesg) {
		super(mesg);
	}

}
