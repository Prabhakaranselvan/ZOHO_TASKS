package com.utilshub;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.exception.InvalidException;

public class LoggerUtils 
{	
	public static final Logger createLogger(Class<?> clazz, String subFolder)
	{
		try 
		{
			UtilsCheck.checkNull(clazz);
			UtilsCheck.checkNull(subFolder);
		}
		catch (InvalidException e) 
		{
			e.printStackTrace();
		}
		
		Logger logger = Logger.getLogger(clazz.getName());
		String logDir = "Log Files/" + subFolder;
		File dir = new File(logDir);
        dir.mkdirs();
	        
		try
		{
			FileHandler infoHandler = new FileHandler(logDir + "/infoLogs.txt", true);
	        infoHandler.setLevel(Level.INFO);
	        infoHandler.setFormatter(new SimpleFormatter());
	        infoHandler.setFilter(record -> record.getLevel() == Level.INFO);

	        FileHandler severeHandler = new FileHandler(logDir + "/severeLogs.txt", true);
	        severeHandler.setLevel(Level.SEVERE);
	        severeHandler.setFormatter(new SimpleFormatter());
	        
	        FileHandler totalHandler = new FileHandler(logDir + "/totalLogs.txt", true);
	        totalHandler.setLevel(Level.ALL);
	        totalHandler.setFormatter(new SimpleFormatter());
	        
	        logger.addHandler(infoHandler);
	        logger.addHandler(severeHandler);
	        logger.addHandler(totalHandler);
	        
	        logger.setLevel(Level.INFO);
	        logger.setUseParentHandlers(false);
		} 
		catch (SecurityException | IOException e) 
		{
			e.printStackTrace();
		}
		return logger;	
	}

}
