package com.cg.asm.exceptions;

public class LoginException extends RuntimeException {
	public String getMessage()
	{
		return "invalid login credentials";
	}
}
