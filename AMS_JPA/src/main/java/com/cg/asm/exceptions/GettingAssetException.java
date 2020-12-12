package com.cg.asm.exceptions;

public class GettingAssetException extends RuntimeException {
	public String getMessage()
	{
		return "no assets are available";
	}
}
