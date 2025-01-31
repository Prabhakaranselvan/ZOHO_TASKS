package com.basicprogramming.inout;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.basicprogramming.task.BPDateTime;
import com.basicprogramming.task.BPFile;
import com.basicprogramming.task.BPProperties;
import com.basicprogramming.task.MySingleton;
import com.basicprogramming.task.RainbowColour;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.exception.InvalidException;
import com.utilshub.Person;
import com.utilshub.PojoClass;
import com.utilshub.UtilsCheck;
import com.utilshub.UtilsScan;

public class BPRunner 
{
	private static final Logger LOGGER = Logger.getLogger(BPRunner.class.getName());

	BPFile bpFile = new BPFile();
	BPProperties bpProperties = new BPProperties();
			    
	private void exercise1(String dirPath) throws InvalidException, IOException
	{
		LOGGER.info("Ex_1: Create a file and write specified lines\n");
		bpFile.ensureDirectoryExists(dirPath);
       
        LOGGER.info("Enter the number of lines: ");
        int noOfLines = UtilsScan.getInteger();
        UtilsCheck.checkNegative(noOfLines);
        String[] lines = new String[noOfLines];
        for (int i = 0; i < noOfLines; i++)
        {
        	LOGGER.info("Enter line " + (i + 1) + ": ");
            lines[i] = UtilsScan.getString();
        }
        
        String fileName = "Simple.txt";
    	bpFile.writeToFile(dirPath, fileName, lines);
        LOGGER.info("File created and written successfully\n");
               
    }

    private void exercise2(String dirPath) throws InvalidException, IOException 
    {
        LOGGER.info("Ex_2: Store values in Properties and save them to myprops.txt\n");
        bpFile.ensureDirectoryExists(dirPath);
                
        Properties properties = bpProperties.createProperties();
        LOGGER.info("No of Key-Value pairs to Add: ");
		int num = UtilsScan.getInteger();
		UtilsCheck.checkNegative(num);
		for (int i = 1; i <= num; i++) 
		{
			LOGGER.info("Enter key" + i + " : ");
			String key = UtilsScan.getString();
			LOGGER.info("Enter value" + i + " : ");
			String value = UtilsScan.getString();
			bpProperties.addKeyValuePair(properties, key, value);
		}
		
		LOGGER.info("Enter comments: ");
		String comments = UtilsScan.getString();
		
		String fileName = "myprops.txt";
		bpProperties.storeProperties(properties, dirPath, fileName, comments);
		LOGGER.info("Properties stored successfully\n");
    }

    private void exercise3(String dirPath) throws InvalidException, IOException 
    {
        LOGGER.info("Ex_3: Read keys & values from myprops.txt and store them back into Properties object\n");
        bpFile.ensureDirectoryExists(dirPath);
                
        Properties properties = bpProperties.createProperties();
        String fileName = "myprops.txt";
    	bpProperties.loadProperties(properties, dirPath, fileName);
        LOGGER.info(properties + "\n");
        
    }

    private void exercise4() throws InvalidException, IOException 
    {
        LOGGER.info("Ex_4: Repeat exercises 1, 2, 3 by creating the directory programmatically\n");
        
        LOGGER.info("Enter the directory path: ");
	    String dirPath = UtilsScan.getString(); 		//  /home/prabha-tt0645/INC*/myDir
	    bpFile.ensureDirectoryExists(dirPath);
        exercise1(dirPath);
        exercise2(dirPath);
        exercise3(dirPath);
    }

    private void exercise5() throws InvalidException 
    {
        LOGGER.info("Ex_5: Create a class with an additional constructor accepting a String and print object\n");
        LOGGER.info("Creating Person Object. Enter Name: ");
		String name = UtilsScan.getString();
        Person person = new Person(name);
        LOGGER.info(person + "\n");
    }

    private void exercise6() throws InvalidException 
    {
        LOGGER.info("Ex_6: Create a POJO class with String & Integer variables and a constructor to initialize them\n");
        LOGGER.info("Enter Message: ");
		String message = UtilsScan.getString();
		LOGGER.info("Enter Number: ");
		int number =UtilsScan.getInteger();
        PojoClass obj = new PojoClass(message, number);
        LOGGER.info(obj + "\n");
    }

    private void exercise7() throws InvalidException 
    {
        LOGGER.info("Ex_7: Create an instance of POJO using default constructor and use setters & getters\n");
        LOGGER.info("Enter Message: ");
		String message = UtilsScan.getString();
		LOGGER.info("Enter Number: ");
		int number = UtilsScan.getInteger();
        
		PojoClass obj = new PojoClass();
        obj.setMessage(message);
        obj.setNumber(number);
        LOGGER.info("Message: " + obj.getMessage() + "\n");
        LOGGER.info("Number: " + obj.getNumber() + "\n");
    }

    private void exercise8() throws InvalidException
    {
        LOGGER.info("Ex_8: Create a POJO class with default and overloaded constructors, accessed via reflection\n");
        try 
        {
            PojoRunner.main(null);
        } 
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
        {
        	throw new InvalidException("Error occurred while dynamically using POJO class using Reflection", e);
        }
    }

    private void exercise9() 
    {
        LOGGER.info("exercise 9: Define an Enum for rainbow colors with values from 1 to 7 and print them\n");
        LOGGER.info("Rainbow Colours and their Colour Codes:\n");
        for (RainbowColour colour : RainbowColour.values()) 
        {
            LOGGER.info("Colour code of " + colour + " is " + colour.getColourCode() + "\n");
        }
        LOGGER.info("Using ordinal() method:\n");
        for (RainbowColour colour : RainbowColour.values()) 
        {
            LOGGER.info(colour + " is at position " + colour.ordinal() + "\n");
        }
    }

    private void exercise10() 
    {
        LOGGER.info("exercise 10: Implement a Singleton class ensuring a single instance in JVM\n");
        MySingleton singleton1 = MySingleton.getInstance();  
        MySingleton singleton2 = MySingleton.getInstance();  
        if (singleton1 == singleton2) 
        {  
            LOGGER.info("Both objects are the same instance.\n");  
        }  
    }

    private void exercise11() throws InvalidException 
    {
        LOGGER.info("exercise 11: Use java.time package to retrieve various time-related details\n");
        BPDateTime task = new BPDateTime();
        DateTimeFormatter formatter1 = task.pattern("dd MMM yyyy - HH:mm:ss");
        DateTimeFormatter formatter2 = task.pattern("dd MMM yyyy - HH:mm:ss - z");
        
        LocalDateTime currentDateTime = task.getCurrentDateTime();
        LOGGER.info("Current Date & Time: " + task.format(currentDateTime, formatter1) + "\n");
        
        Instant currentInstant = task.getCurrentInstant();
        long instantMillis = task.toMillis(currentInstant);
        LOGGER.info("Current Time in Milliseconds (Instant): " + instantMillis + "\n");
        
        LOGGER.info("Current Time in Milliseconds (System): " + task.nowMillis() + "\n");
           
        ZoneId newyork = task.zoneId("America/New_York");
        ZonedDateTime newyorkDateTime = task.getCurrentZonedDateTime(newyork);
        LOGGER.info("Current Date Time in New York: " + task.format(newyorkDateTime, formatter2) + "\n");
                
        ZoneId london = task.zoneId("Europe/London");
        ZonedDateTime londonDateTime = task.getCurrentZonedDateTime(london);
        LOGGER.info("Current Date Time in London: " + task.format(londonDateTime, formatter2) + "\n");
        
        Instant instant = task.getInstantEpochMilli(instantMillis);
        ZoneId kolkata = task.zoneId("Asia/Kolkata");   
        LocalDateTime dateTime = task.getDateTimeFomInstant (instant, kolkata);
        LOGGER.info("Current Day of The Week: " + task.getWeekDay(dateTime) + "\n");    
        LOGGER.info("Current Month: " + task.getMonth(dateTime) + "\n");       
        LOGGER.info("Current Year: " + task.getYear(dateTime) + "\n"); 
        
        LOGGER.info("Enter time in millis: ");
        long millis = UtilsScan.getLong();
        Instant instant2 = task.getInstantEpochMilli(millis);
        LocalDateTime dateTime2 = task.getDateTimeFomInstant (instant2, kolkata);		
        LOGGER.info("For Given Millis - Day of The Week: " + task.getWeekDay(dateTime2) + "\n");       
        LOGGER.info("For Given Millis - Month: " + task.getMonth(dateTime2) + "\n");
        LOGGER.info("For Given Millis- Year: " + task.getYear(dateTime2) + "\n");         
    }
    
    public  String getWorkingDirectory() 
	{
	    return System.getProperty("user.dir");
	}

   public static void main(String[] args) 
    {
        BPRunner bp = new BPRunner();
        boolean isContinue = true;
        String exercise;
        String dirPath = bp.getWorkingDirectory();
       
        while (isContinue) 
        {
        	try
        	{
        		LOGGER.info("Enter the exercise to carry out : ");
    			exercise = UtilsScan.getString();
    			switch (exercise) 
                {
                    case "1": 
                    	
                    	bp.exercise1(dirPath);
                    	break;
                    	
                    case "2": 
                    	dirPath = ".";
                    	bp.exercise2(dirPath);
                    	break;
                    	
                    case "3":
                    	dirPath = ".";
                    	bp.exercise3(dirPath); 
                    	break;
                    	
                    case "4": 
                    	bp.exercise4(); 
                    	break;
                    	
                    case "5": 
                    	bp.exercise5(); 
                    	break;
                    	
                    case "6": 
                    	bp.exercise6(); 
                    	break;
                    	
                    case "7": 
                    	bp.exercise7(); 
                    	break;
                    	
                    case "8": 
                    	bp.exercise8(); 
                    	break;
                    	
                    case "9": 
                    	bp.exercise9(); 
                    	break;
                    	
                    case "10": 
                    	bp.exercise10(); 
                    	break;
                    	
                    case "11": 
                    	bp.exercise11(); 
                    	break;
                                        	
                    case "0": 
                    	isContinue = false; 
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


	
