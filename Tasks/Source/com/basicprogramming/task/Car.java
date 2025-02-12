package com.basicprogramming.task;

public class Car 
{
	private String model;
	private int number;

// Default Constructor
    public Car() 
    {
    }
    
// Constructor that accepts both variables
	public Car(String model, int number) 	
	{
		this.model = model;	
		this.number = number;
	}
	
	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
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
		return "Car{model:'" + model + "', number:" + number + "}";
	}
}

