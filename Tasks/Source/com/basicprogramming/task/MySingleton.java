package com.basicprogramming.task;

import java.io.Serializable;

public class MySingleton implements Serializable
//Bill Pugh Singleton Implementation
{
	private static final long serialVersionUID = 1L;

	private MySingleton() 
	{
	    if (SingletonHelper.INSTANCE != null) // Prevent Reflection from breaking Singleton
	    {
	        throw new RuntimeException("Use getInstance() method to create Singleton");
	    }
	}

	private static class SingletonHelper 
	{
	    private static final MySingleton INSTANCE = new MySingleton();
	}
	
	public static MySingleton getInstance() 
	{
	    return SingletonHelper.INSTANCE;
	}
	
	private Object readResolve() // Prevents new instance creation during deserialization
	{
	    return getInstance();
	}
}


//Lazy Initialization with Double-Checked Locking
//{
//    private static final long serialVersionUID = 1L;
//    
//	private static volatile MySingleton instance;
//
//    private MySingleton() {}
//
//    public static MySingleton getInstance() 
//    {
//        if (instance == null) 
//        { 
//            synchronized (MySingleton.class) 
//            {
//                if (instance == null) 
//                { 
//                    instance = new MySingleton();
//                }
//            }
//        }
//        return instance;
//    }
//}



//Eager Initialization
//{
//	private static final long serialVersionUID = 1L;
//
//	private static final MySingleton instance = new MySingleton();
//
//	private MySingleton() {}
//	
//	public static MySingleton getInstance() 
//	{
//	  return instance;
//	}
//}
