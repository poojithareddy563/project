package com.cg.asm.exceptions;

public class AddingAssetException extends RuntimeException {

	public String getMessage() {
		return "asset is already present";
	}
}
