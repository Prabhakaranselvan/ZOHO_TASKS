package com.utilshub;

import java.util.logging.Logger;

public class ThreadLogger extends LoggerUtils 
{
    private static final Logger LOGGER = LoggerUtils.createLogger(ThreadLogger.class, "Threads");

    public static Logger getLogger() 
    {
        return LOGGER;
    }
}
