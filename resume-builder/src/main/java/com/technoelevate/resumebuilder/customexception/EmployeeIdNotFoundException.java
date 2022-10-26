package com.technoelevate.resumebuilder.customexception;

@SuppressWarnings("serial")
public class EmployeeIdNotFoundException extends RuntimeException {
	
	public EmployeeIdNotFoundException (String messege) {
		super(messege);
	}

}
