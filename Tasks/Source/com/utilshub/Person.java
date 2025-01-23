package com.utilshub;

public class Person 
{
    String name;
    
//Constructor
    public Person(String name) 
	{
        this.name = name;
    }
	
	public String toString() 
	{
        return "Person{name='" + name + "'}";
    }
}