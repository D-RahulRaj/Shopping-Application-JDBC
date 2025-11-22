package com.shopping.exception;

public class CustomerDataInValidException extends RuntimeException
{
	private String exception;

	public CustomerDataInValidException() {
		super();
	}

	public CustomerDataInValidException(String exception) {
		super();
		this.exception = exception;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "CustomerDataInValidException [exception=" + exception + "]";
	}
	

}