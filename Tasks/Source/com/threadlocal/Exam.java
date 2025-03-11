package com.threadlocal;

public class Exam 
{
	public void conductExam() 
	{
		System.out.println("Exam conducted for: " + Student.getStudentName());
		Result m3Result = new Result();
	    m3Result.declareResult();
	}
	
}
