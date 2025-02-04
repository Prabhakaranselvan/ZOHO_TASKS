package com.basicprogramming.task;

import java.io.Serializable;

public class EagerSingleton implements Serializable, Cloneable
//Eager Initialization
{
	private static final long serialVersionUID = 1L;

	private static final EagerSingleton instance = new EagerSingleton();

	private EagerSingleton() 
	{
		if (instance != null) // Prevent Reflection from breaking Singleton
		{
            throw new IllegalStateException("Singleton instance already created");
        }
	}
	
	public static EagerSingleton getInstance() 
	{
	  return instance;
	}
	
	protected Object readResolve() // Prevents new instance creation during deserialization
	{
	    return getInstance();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
	    throw new CloneNotSupportedException("Cloning shouldn't be done.");
	}
}
