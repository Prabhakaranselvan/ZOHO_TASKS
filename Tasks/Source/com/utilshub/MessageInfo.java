package com.utilshub;


public class MessageInfo 
{
	private String message;
	private int number;

// Default Constructor
    public MessageInfo() 
    {
    }
    
// Constructor that accepts both variables
	public MessageInfo(String message, int number) 	
	{
		this.message = message;	
		this.number = number;
	}
	
	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	public int getNumber() 
	{
		return number;
	}

	public void setNumber(int number) 
	{
		this.number = number;
	}

	@Override
	public String toString() 
	{
		return "MessageInfo{Message:'" + message + "', number:" + number + "}";
	}
}
