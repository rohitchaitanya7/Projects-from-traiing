package com.example.demo.exception;

public class InputException extends RuntimeException{
	private static String message="range is 10- 20";
	private static int errorcode= 100;
	private  int input;
	
	
	public InputException() {
		super();
	}

	public InputException(int input) {
		super(message);
		this.input = input;
	}

	public static int getErrorcode() {
		return errorcode;
	}

	public static void setErrorcode(int errorcode) {
		InputException.errorcode = errorcode;
	}

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	}

	public String getMessage() {
		return message;
	}

	public void setMsg(String message) {
		// TODO Auto-generated method stub
		InputException.message = message;
		
	}


	
	
	
	

}
