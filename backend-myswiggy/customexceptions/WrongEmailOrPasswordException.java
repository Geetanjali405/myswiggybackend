package com.example.myswiggy.customexceptions;

public class WrongEmailOrPasswordException extends RuntimeException{
	
	public WrongEmailOrPasswordException(String message)
	{
		super(message);
	}

}
