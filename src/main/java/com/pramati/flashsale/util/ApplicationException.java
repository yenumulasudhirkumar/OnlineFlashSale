package com.pramati.flashsale.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8004227883854718947L;

	/**
	 * 
	 */
	
	public ApplicationException(String error) {
		super(error);
	}

}
