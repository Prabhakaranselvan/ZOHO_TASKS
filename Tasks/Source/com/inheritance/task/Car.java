package com.inheritance.task;

public class Car 
{
    private int yearOfMake;
    private String engineNumber;
    private String type;
	
//Default Constructor
	public Car()
	{
	}
	
//Overloaded Constructor
	public Car(String message) 
	{
        System.out.println(message);
    }

// Getter and Setter for yearOfMake
    public int getYearOfMake() 
	{
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake)
	{
		this.yearOfMake = yearOfMake;
    }

// Getter and Setter for engineNumber
    public String getEngineNumber() 
	{
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber)
	{
		this.engineNumber = engineNumber;
    }

    // Getter and Setter for type
    public String getType() 
	{
        return type;
    }

    public void setType(String type)
	{
		this.type = type;
    }
	
	public void maintenance()
	{
		System.out.println("Car under maintenance");
 	}
}

