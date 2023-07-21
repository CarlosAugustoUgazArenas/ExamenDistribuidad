package com.ugaz.infraccionservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class ValidateServiceException2 extends RuntimeException{
    
    private static final long serialVersionUID=1L;
    
    public ValidateServiceException2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidateServiceException2(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValidateServiceException2(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValidateServiceException2(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValidateServiceException2(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
