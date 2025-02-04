package com.basicprogramming.task;

import java.io.Serializable;

public class LazySingleton implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private static LazySingleton instance;

    private LazySingleton() 
    {
    	if (instance != null) // Prevent Reflection from breaking Singleton
    	{
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static LazySingleton getInstance() 
    {
        if (instance == null) 
        {
            instance = new LazySingleton();
        }
        return instance;
    }
    
    protected Object readResolve() // Prevents new instance creation during deserialization
	{
	    return getInstance();
	}
}


