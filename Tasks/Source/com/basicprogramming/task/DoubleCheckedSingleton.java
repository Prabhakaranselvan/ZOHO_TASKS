package com.basicprogramming.task;

import java.io.Serializable;

public class DoubleCheckedSingleton implements Serializable
//Lazy Initialization with Double-Checked Locking
{
	private static final long serialVersionUID = 1L;
  
	private static volatile DoubleCheckedSingleton instance;

	private DoubleCheckedSingleton() 
	{
		if (instance != null) // Prevent Reflection from breaking Singleton
		{
            throw new IllegalStateException("Singleton instance already created");
        }
	}

	public static DoubleCheckedSingleton getInstance() 
	{
		if (instance == null) 
		{ 
			synchronized (DoubleCheckedSingleton.class) 
			{
				if (instance == null) 
				{ 
					instance = new DoubleCheckedSingleton();
				}
			}
		}
      return instance;
	}
      
	protected Object readResolve() // Prevents new instance creation during deserialization
  	{
  	    return getInstance();
  	}
}