package com.basicprogramming.task;

import java.io.Serializable;


public class BillPughSingleton implements Serializable
//Bill Pugh Singleton Implementation
{
	private static final long serialVersionUID = 1L;

	private BillPughSingleton()  
	{
		if (SingletonHelper.INSTANCE != null) // Prevent Reflection from breaking Singleton
		{
            throw new IllegalStateException("Singleton instance already created");
        }
	}

	private static class SingletonHelper 
	{
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() 
	{
	    return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve() // Prevents new instance creation during deserialization
	{
	    return getInstance();
	}
}

//clone






