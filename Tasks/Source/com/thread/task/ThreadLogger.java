package com.thread.task;

import java.util.logging.Logger;

import com.utilshub.LoggerUtils;

public class ThreadLogger
{
    private static final Logger LOGGER = LoggerUtils.createLogger(ThreadLogger.class, "Threads");
    
    private ThreadLogger()
    {
    	
    }

    public static Logger getLogger() 
    {
        return LOGGER;
    }
}
