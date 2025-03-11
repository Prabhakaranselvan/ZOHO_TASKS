package com.threadlocal;

public class College 
{
	public static void main(String[] args) 
	{
		Runnable task1 = () -> {
            new Admission().admitStudent("Prabhakaran");
            Student.clear();
        };

        Runnable task2 = () -> {
            new Admission().admitStudent("Narthamil");
            Student.clear();
        };
	
	    Thread thread1 = new Thread(task1);
	    Thread thread2 = new Thread(task2);
	
	    thread1.start();
	    thread2.start();
    }
}

