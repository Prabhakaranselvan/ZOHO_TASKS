package com.thread.inout;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.exception.InvalidException;
import com.thread.task.ExtendedThread;
import com.thread.task.RunnableThread;
import com.utilshub.ThreadLogger;
import com.utilshub.UtilsScan;

public class ThreadRunner 
{
	private static final Logger LOGGER = ThreadLogger.getLogger();
	
	private void beforeStartDetails(Thread thread)
	{
		LOGGER.info("Before starting the thread:\n" );
		LOGGER.info("Thread_Name(" + thread.getName() + ") ; Priority(" + thread.getPriority() + ") ; State(" + thread.getState() + ")\n");
	}
	
	private void afterStartDetails(Thread thread)
	{
		LOGGER.info("After starting the thread:\n" );
		LOGGER.info("Thread_Name(" + thread.getName() + ") ; Priority(" + thread.getPriority() + ") ; State(" + thread.getState() + ")\n");
	}
	
	private void exercise1() throws InvalidException, InterruptedException
    {
		LOGGER.info("Exercise 1 : Basic Thread Creation and State Observation\n");
        ExtendedThread thread = new ExtendedThread();

        beforeStartDetails(thread);
        thread.start();
        afterStartDetails(thread);
    }
	
	private void exercise2() throws InvalidException, InterruptedException
    {
		LOGGER.info("Exercise 2 : Implementing Threads Using Runnable Interface\n");
		RunnableThread runnable = new RunnableThread();
		Thread thread = new Thread(runnable);

		beforeStartDetails(thread);
        thread.start();
        afterStartDetails(thread);
    }
	
	private void exercise3() throws InvalidException, InterruptedException
    {
		LOGGER.info("Exercise 3 : Naming and Observing Multiple Threads\n");
		ExtendedThread thread = new ExtendedThread("ExtendedThread");

		beforeStartDetails(thread);
        thread.start();
        afterStartDetails(thread);
        
        
        RunnableThread runnable = new RunnableThread();
		Thread thread2 = new Thread(runnable, "RunnableThread");

		beforeStartDetails(thread2);
        thread2.start();
        afterStartDetails(thread2);

    }

	private void exercise4() throws InvalidException, InterruptedException
    {
		LOGGER.info("Exercise 4 : Simulating Thread Sleep and Observing Behavior\n");
		List<ExtendedThread> extendedThreads = new ArrayList<>();
		for (int i=0; i<5; i++) 
		{
            ExtendedThread thread = new ExtendedThread("ExtendedThread - " + i);
            extendedThreads.add(thread);
            thread.start();
        }
		
		List<RunnableThread> runnableThreads = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i=0; i<5; i++)
		{
			RunnableThread runnable = new RunnableThread();
			runnableThreads.add(runnable);
            Thread thread = new Thread(runnable, "RunnableThread - " + i);
            threads.add(thread);
            thread.start();
        }
    }
	
	private void exercise5() throws InvalidException, InterruptedException
    {
		LOGGER.info("Exercise 5 : Dynamic Sleep Time Assignment for Threads\n");
		List<ExtendedThread> extendedThreads = new ArrayList<>();
		for (int i=0; i<5; i++) 
		{
            ExtendedThread thread = new ExtendedThread("ExtendedThread - " + i, 60000+(i*10000));
            extendedThreads.add(thread);
            thread.start();
        }
		
		List<RunnableThread> runnableThreads = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i=0; i<5; i++) 
		{
			RunnableThread runnable = new RunnableThread(45000+(i*5000));
			runnableThreads.add(runnable);
            Thread thread = new Thread(runnable, "RunnableThread - " + i);
            threads.add(thread);
            thread.start();
        }
    }
	
	private void captureThreadDump() 
	{
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
        
        for (ThreadInfo threadInfo : threadInfos) 
        {
        	LOGGER.info(threadInfo.toString());
        }
	}
	
	private void exercise6() throws InvalidException, InterruptedException
	{
		LOGGER.info("Exercise 6 : Implementing a Controlled Execution Loop with Thread Dumps\n");
		List<ExtendedThread> extendedThreads = new ArrayList<>();
		for (int i=0; i<5; i++) 
		{
            ExtendedThread thread = new ExtendedThread("ExtendedThread - " + i, 60000+(i*10000));
            extendedThreads.add(thread);
            thread.start();
        }
		
		List<RunnableThread> runnableThreads = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i=0; i<5; i++) 
		{
			RunnableThread runnable = new RunnableThread(45000+(i*5000));
			runnableThreads.add(runnable);
            Thread thread = new Thread(runnable, "RunnableThread - " + i);
            threads.add(thread);
            thread.start();
        }
		
		try 
		{
            Thread.sleep(120000);

            for (int i = 1; i <= 3; i++) 
            {
                LOGGER.info("\nTaking Thread Dump " + i + " at " + (i * 30) + " seconds\n");
                captureThreadDump();
                Thread.sleep(30000);
            }

            for (ExtendedThread thread : extendedThreads) 
            {
                thread.stopThread();
            }
            for (RunnableThread thread : runnableThreads) 
            {
                thread.stopThread();
            }

        } 
		catch (InterruptedException e) 
		{
			LOGGER.log(Level.SEVERE,"ThreadRunner interrupted.\n" , e);
        }
    }
	
	private void exercise7() throws InvalidException, InterruptedException 
	{
		LOGGER.info("Exercise 7 : Gradual Thread Stopping and Advanced Thread Dump Analysis\n");
	    List<ExtendedThread> extendedThreads = new ArrayList<>();
	    for (int i = 0; i < 5; i++) 
	    {
	        ExtendedThread thread = new ExtendedThread("ExtendedThread - " + i, 60000+(i*10000));
	        extendedThreads.add(thread);
	        thread.start();
	    }

	    List<RunnableThread> runnableThreads = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i=0; i<5; i++) 
		{
			RunnableThread runnable = new RunnableThread(45000+(i*5000));
			runnableThreads.add(runnable);
            Thread thread = new Thread(runnable, "RunnableThread - " + i);
            threads.add(thread);
            thread.start();
        }

	    Thread threadDumpThread = new Thread(() -> {
	        try 
	        {
	            Thread.sleep(120000);
	            for (int i = 1; i <= 10; i++) 
	            {
	                LOGGER.info("\nTaking Thread Dump " + i + " at " + (i * 40) + " seconds\n");
	                captureThreadDump();
	                Thread.sleep(40000);
	            }
	        } 
	        catch (InterruptedException e) 
	        {
	        	LOGGER.log(Level.SEVERE,"Thread dump thread interrupted.\n" , e);
	        }
	    });
	    threadDumpThread.start();
	    
	    for (ExtendedThread thread : extendedThreads) 
	    {
	        Thread.sleep(60000);
	        thread.stopThread();
	        LOGGER.info(thread.getName() + " stopped.\n");
	    }
	    
	   
	    for (RunnableThread thread : runnableThreads) 
        {
	    	Thread.sleep(60000);
            thread.stopThread();
            LOGGER.info("All RunnableThread instances are stopped.\n");
        }
        

	    boolean allStopped;
	    do {
	        allStopped = true;
	        for (ExtendedThread thread : extendedThreads) 
	        {
	            if (thread.isAlive()) 
	            {
	                allStopped = false;
	                break;
	            }
	        }
	        
	        for (Thread thread : threads) 
	        {
	            if (thread.isAlive()) 
	            {
	                allStopped = false;
	                break;
	            }
	        }
	        Thread.sleep(5000);
	    } while (!allStopped);
	    
	    LOGGER.info("Tasks completed.\n");
	    
	    LOGGER.info("\nFinal Thread Dump after tasks completed\n");
	    captureThreadDump();
	}
	
	public static void main(String[] args) 
    {
        ThreadRunner runner = new ThreadRunner();
        boolean isContinue = true;
        String exercise;
       
        while (isContinue) 
        {
        	try
        	{
        		System.out.print("Enter the exercise to carry out : ");
    			exercise = UtilsScan.getString();
    			switch (exercise) 
                {
                    case "1": 
                    	
                    	runner.exercise1();
                    	break;
                    	
                    case "2": 
                    	runner.exercise2();
                    	break;
                    	
                    case "3":
                    	runner.exercise3(); 
                    	break;
                    	
                    case "4": 
                    	runner.exercise4(); 
                    	break;
                    	
                    case "5": 
                    	runner.exercise5(); 
                    	break;
                    	
                    case "6": 
                    	runner.exercise6(); 
                    	break;
                    	
                    case "7": 
                    	runner.exercise7(); 
                    	break;
                    	                                  	
                    case "0": 
                    	isContinue = false; 
                    	LOGGER.info("Terminated.\n");
                    	break;
                    	
                    default: 
                    	LOGGER.info("Invalid input. Try again.\n");
                    	break;
                }
        	}
        	catch (Exception e) 
			{
        		LOGGER.log(Level.SEVERE, "An exception occurred" , e);
			}
        }
    }
	
	
}
