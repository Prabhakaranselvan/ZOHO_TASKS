package com.basicprogramming.task;

import java.io.Serializable;

public class SynchronizedLazySingleton implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private static SynchronizedLazySingleton instance;

    private SynchronizedLazySingleton() 
    {
    	if (instance != null) // Prevent Reflection from breaking Singleton
    	{
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static synchronized SynchronizedLazySingleton getInstance() 
    {
        if (instance == null) 
        {
            instance = new SynchronizedLazySingleton();
        }
        return instance;
    }
    
    protected Object readResolve() // Prevents new instance creation during deserialization
	{
	    return getInstance();
	}
}