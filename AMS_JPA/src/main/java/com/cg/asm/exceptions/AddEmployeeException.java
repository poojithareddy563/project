package com.cg.asm.exceptions;

public class AddEmployeeException extends RuntimeException {
	public String getMessage() {
		return "employeeId is already present or invalid DeptId";
	}
}
