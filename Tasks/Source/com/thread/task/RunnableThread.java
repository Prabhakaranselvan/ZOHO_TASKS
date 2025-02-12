package com.thread.task;

import java.util.logging.Logger;

import com.utilshub.ThreadLogger;

public class RunnableThread implements Runnable
{
private Integer sleepTime = null;
private boolean isRunning = true;
private static final Logger LOGGER = ThreadLogger.getLogger();
	
	public RunnableThread() 
	{
    }
	
	public RunnableThread(int sleepTime) 
	{
        this.sleepTime = sleepTime;
    }
	
	public void stopThread() 
    {
        isRunning = false;
    }
	
	@Override
    public void run()
    {
		String threadName = Thread.currentThread().getName();
		LOGGER.info("Thread_Name(" + threadName + ") ; Priority(" + Thread.currentThread().getPriority() + ") ; State(" + Thread.currentThread().getState() + ")\n");
		if (sleepTime == null) 
		{
			sleepTime = 45000;
		}
        while (isRunning) 
        {
        	LOGGER.info("Going to Sleep: " + threadName + " for " + sleepTime + " ms\n");
	        try 
	        {
	            Thread.sleep(sleepTime);
	        } 
	        catch (InterruptedException e) 
	        {
	        	LOGGER.info(threadName + " interrupted.\n");
	        }
	        LOGGER.info("After sleeping: " + threadName+ "\n");
        }
        LOGGER.info(threadName + " Stopped...\n");
       
    }
}
