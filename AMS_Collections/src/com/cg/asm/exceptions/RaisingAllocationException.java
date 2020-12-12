package com.cg.asm.exceptions;

public class RaisingAllocationException extends RuntimeException {
	public String getMessage()
	{
		return "allocationId is already present";
	}
}
