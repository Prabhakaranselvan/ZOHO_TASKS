package com.utilshub;

public class Person 
{
    private String name;
    
//Constructor
    public Person(String name) 
	{
        this.name = name;
    }
	
    @Override
	public String toString() 
	{
        return "Person{Name:'" + name + "'}";
    }
}