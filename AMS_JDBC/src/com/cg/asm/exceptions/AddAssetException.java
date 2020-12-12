package com.cg.asm.exceptions;

public class AddAssetException extends RuntimeException {
	
	public String getMessage() {
		return "asset is already present";
	}
}
