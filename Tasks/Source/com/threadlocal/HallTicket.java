package com.threadlocal;

public class HallTicket 
{
	public void issueHallTicket() 
	{
		Exam mathematics = new Exam();
		System.out.println("Hall ticket issued for: " + Student.getStudentName());
	    mathematics.conductExam();
	}
}
	
