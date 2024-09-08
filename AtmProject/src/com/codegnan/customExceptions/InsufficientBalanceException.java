package com.codegnan.customExceptions;

public class InsufficientBalanceException extends Exception {
	 public InsufficientBalanceException(String errorMsg) {
		 super(errorMsg);
		 }

}
