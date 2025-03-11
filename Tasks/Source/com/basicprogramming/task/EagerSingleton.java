package com.basicprogramming.task;

import java.io.Serializable;

public class EagerSingleton implements Serializable, Cloneable
//Eager Initialization
{
	private static final long serialVersionUID = 1L;

	private static final EagerSingleton INSTANCE = new EagerSingleton();

	private EagerSingleton() 
	{
		if (INSTANCE != null) // Prevent Reflection from breaking Singleton
		{
            throw new IllegalStateException("Singleton instance already created");
        }
	}
	
	public static EagerSingleton getInstance() 
	{
	  return INSTANCE;
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
