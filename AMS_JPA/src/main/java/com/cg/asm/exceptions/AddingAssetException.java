package com.cg.asm.exceptions;

public class AddingAssetException extends RuntimeException {
	// public AddAssetException(String msg)
	// {
	// System.err.println(msg);
	//
	// }
	public String getMessage() {
		return "asset is already present";
	}
}
