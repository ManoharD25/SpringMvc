package com.xworkz.springmvc.customexception;

public class SportException extends Exception{

	private static final long serialVersionUID = 1L;

	public SportException(String errormsg) {
		super(errormsg);
		
	}
	
}
