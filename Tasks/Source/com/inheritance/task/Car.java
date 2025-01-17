package com.inheritance.task;
import com.helper.UtilsHub;
import com.exception.InvalidException;

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

    public void setYearOfMake(int yearOfMake) throws InvalidException
	{
		UtilsHub.checkZero(yearOfMake);
		UtilsHub.checkNegative(yearOfMake);
        this.yearOfMake = yearOfMake;
    }

// Getter and Setter for engineNumber
    public String getEngineNumber() 
	{
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) throws InvalidException 
	{
		UtilsHub.checkNull(engineNumber);
        this.engineNumber = engineNumber;
    }

    // Getter and Setter for type
    public String getType() 
	{
        return type;
    }

    public void setType(String type) throws InvalidException
	{
		UtilsHub.checkNull(type);
        this.type = type;
    }
	
	public void maintenance()
	{
		System.out.println("Car under maintenance");
 	}
}

