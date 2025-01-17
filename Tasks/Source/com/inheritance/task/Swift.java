package com.inheritance.task;
import com.helper.UtilsHub;
import com.exception.InvalidException;

public class Swift extends Car 
{
    private int seats;
    private int airbags;
    private String model;
    private String color;

// Getter and Setter for seats
    public int getSeats() 
	{
        return seats;
    }

    public void setSeats(int seats) throws InvalidException
	{
		UtilsHub.checkZero(seats);
		UtilsHub.checkNegative(seats);
        this.seats = seats;
    }

// Getter and Setter for airbags
    public int getAirbags() 
	{
        return airbags;
    }

    public void setAirbags(int airbags) throws InvalidException
	{
		UtilsHub.checkNegative(airbags);
        this.airbags = airbags;
    }

// Getter and Setter for model
    public String getModel() 
	{
        return model;
    }

    public void setModel(String model) throws InvalidException
	{
		UtilsHub.checkNull(model);
        this.model = model;
    }

// Getter and Setter for color
    public String getColor() 
	{
        return color;
    }

    public void setColor(String color) throws InvalidException
	{
		UtilsHub.checkNull(color);
        this.color = color;
    }
}
