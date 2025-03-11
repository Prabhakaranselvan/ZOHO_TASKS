package com.threadlocal;

public class Student 
{
	private static final ThreadLocal<String> studentThreadLocal = new ThreadLocal<>();
	
	public static void setStudentName(String studentName) 
	{
		studentThreadLocal.set(studentName);
	}

	public static String getStudentName() 
	{
     return studentThreadLocal.get();
	}

	public static void clear() 
	{
     studentThreadLocal.remove();
	}	 
}




