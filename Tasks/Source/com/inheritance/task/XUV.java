package com.inheritance.task;

public class XUV extends Car 
{
    private int seats;
    private int airbags;
    private String model;
    private String color;
	
//Default Constructor calling overloaded Super Constructor
	public XUV() 
	{
        super("message");
    }

// Getter and Setter for seats
    public int getSeats() 
	{
        return seats;
    }

    public void setSeats(int seats)
	{
		this.seats = seats;
    }

// Getter and Setter for airbags
    public int getAirbags() 
	{
        return airbags;
    }

    public void setAirbags(int airbags)
	{
		this.airbags = airbags;
    }

// Getter and Setter for model
    public String getModel() 
	{
        return model;
    }

    public void setModel(String model)
	{
		this.model = model;
    }

// Getter and Setter for color
    public String getColor() 
	{
        return color;
    }

    public void setColor(String color)
	{
		this.color = color;
    }
}
