package com.cg.asm.exceptions;

public class AddEmployeeException extends RuntimeException {
	public String getMessage() {
		return "invalid DeptId or employee is already added";
	}
}
