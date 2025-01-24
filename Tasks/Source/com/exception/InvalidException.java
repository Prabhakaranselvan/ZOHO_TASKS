package com.exception;

public class InvalidException extends Exception 
{
	private static final long serialVersionUID = 1L;
	public InvalidException(String message) 
	{
        super(message);
    }
	public InvalidException(String message, Throwable cause) 
	{
        super(message, cause);
	}
}
