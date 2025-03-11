package com.threadlocal;

public class Admission 
{
	public void admitStudent(String studentName) 
	{
		Student.setStudentName(studentName);
		System.out.println("Admission done for: " + studentName);
        new HallTicket().issueHallTicket();
	}
}

