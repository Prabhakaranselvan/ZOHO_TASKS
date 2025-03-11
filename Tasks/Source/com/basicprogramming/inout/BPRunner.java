package com.basicprogramming.inout;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.basicprogramming.task.BPDateTime;
import com.basicprogramming.task.BPFile;
import com.basicprogramming.task.BPProperties;
import com.basicprogramming.task.BillPughSingleton;
import com.basicprogramming.task.Car;
import com.basicprogramming.task.RainbowColour;
import com.exception.InvalidException;
import com.utilshub.Person;
import com.utilshub.UtilsCheck;
import com.utilshub.LoggerUtils;
import com.utilshub.UtilsScan;
import com.utilshub.UtilsSize;

public class BPRunner 
{
	private static final Logger LOGGER = LoggerUtils.createLogger(BPRunner.class, "Basic Programming");
	
	BPFile bpFile = new BPFile();
	BPProperties bpProperties = new BPProperties();
			    
	private void exercise1(String dirPath) throws InvalidException, IOException
	{
		LOGGER.info("Ex_1: Create a file and write specified lines\n");
		bpFile.ensureDirectoryExists(dirPath);
        
        System.out.print("Enter the number of lines: ");
        int noOfLines = UtilsScan.getInteger();
        UtilsCheck.checkNegative(noOfLines);
        String[] lines = new String[noOfLines];
        for (int i = 0; i < noOfLines; i++)
        {
        	 System.out.print("Enter line " + (i + 1) + ": ");
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
        System.out.print("No of Key-Value pairs to Add: ");
		int num = UtilsScan.getInteger();
		UtilsCheck.checkNegative(num);
		for (int i = 1; i <= num; i++) 
		{
			 System.out.print("Enter key" + i + " : ");
			String key = UtilsScan.getString();
			 System.out.print("Enter value" + i + " : ");
			String value = UtilsScan.getString();
			bpProperties.addKeyValuePair(properties, key, value);
		}
		
		 System.out.print("Enter comments: ");
		String comments = UtilsScan.getString();
		
		String fileName = "myprops.txt";
		bpProperties.storeProperties(properties, dirPath, fileName, comments);
		LOGGER.info("Properties stored successfully\n");
    }

    private void exercise3(String dirPath) throws InvalidException, IOException 
    {
        LOGGER.info("Ex_3: Read keys & values from myprops.txt and store them back into Properties object\n");
        bpFile.ensureDirectoryExists(dirPath);
                
        String fileName = "myprops.txt";
        Properties properties = bpProperties.loadProperties(dirPath, fileName);
        LOGGER.info(properties + "\n");
        
    }

    private void exercise4() throws InvalidException, IOException 
    {
        LOGGER.info("Ex_4: Repeat exercises 1, 2, 3 by creating the directory programmatically\n");
        
        System.out.print("Enter the directory path: ");
	    String dirPath = UtilsScan.getString(); 		//  /home/prabha-tt0645/INC*/myDir
	    bpFile.ensureDirectoryExists(dirPath);
        exercise1(dirPath);
        exercise2(dirPath);
        exercise3(dirPath);
    }

    private void exercise5() throws InvalidException 
    {
        LOGGER.info("Ex_5: Create a class with an additional constructor accepting a String and print object\n");
        System.out.print("Creating Person Object. Enter Name: ");
		String name = UtilsScan.getString();
        Person person = new Person(name);
        LOGGER.info(person + "\n");
    }

    private void exercise6() throws InvalidException 
    {
        LOGGER.info("Ex_6: Create a POJO class with String & Integer variables and a constructor to initialize them\n");
        System.out.print("Enter Car Model: ");
		String model = UtilsScan.getString();
		System.out.print("Enter Number: ");
		int number =UtilsScan.getInteger();
		Car obj = new Car(model, number);
        LOGGER.info(obj + "\n");
    }

    private void exercise7() throws InvalidException 
    {
        LOGGER.info("Ex_7: Create an instance of POJO using default constructor and use setters & getters\n");
        System.out.print("Enter Car Model: ");
		String model = UtilsScan.getString();
		 System.out.print("Enter Car Number: ");
		int number = UtilsScan.getInteger();
        
		Car obj = new Car();
        obj.setModel(model);
        obj.setNumber(number);
        LOGGER.info("Message: " + obj.getModel() + "\n");
        LOGGER.info("Number: " + obj.getNumber() + "\n");
    }

    private void exercise8() throws InvalidException
    {
        LOGGER.info("Ex_8: Create a POJO class with default and overloaded constructors, accessed via reflection\n");
        dynamicRunner();
        
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
        BillPughSingleton singleton1 = BillPughSingleton.getInstance();  
        BillPughSingleton singleton2 = BillPughSingleton.getInstance();  
        if (singleton1 == singleton2) 
        {  
            LOGGER.info("Both objects are the same instance.\n");  
        }  
    }

    private void exercise11() throws InvalidException 
    {
        LOGGER.info("exercise 11: Use java.time package to retrieve various time-related details\n");
        BPDateTime task = new BPDateTime();
        DateTimeFormatter formatter = task.pattern("dd MMM yyyy - HH:mm:ss - z");
        ZoneId zoneId = getZoneID(task);
        
        ZonedDateTime date = task.getZonedDateTime(2003, 2, 23, 0, 0, 0, 0, zoneId);
        ZonedDateTime date2 = task.getZonedDateTime(2003, 4, 23, 0, 0, 0, 0, zoneId);
        LOGGER.info("Without DST:"+ task.getZoneOffset(date) + "\n");
        LOGGER.info("With DST:" + task.getZoneOffset(date2) + "\n");
//1. Return the currentTime with Date, seconds etc        
        ZonedDateTime DateTime = task.getCurrentZonedDateTime(zoneId);
        LOGGER.info("Current Date Time in " + zoneId + ": " + task.format(DateTime, formatter) + "\n");
        
//2. Return the currentTime in milliseconds
        Instant currentInstant = task.getCurrentInstant();
        long instantMillis = task.toMillis(currentInstant);
        LOGGER.info("Current Time in Milliseconds (Instant): " + instantMillis + "\n");
        
//2. Return the currentTime in milliseconds using System Class
        LOGGER.info("Current Time in Milliseconds (System): " + task.nowMillis() + "\n");
               
//4. Return the Weekday, Month and Year for the currentTime        
        Instant instant = task.getInstantEpochMilli(instantMillis);
        ZonedDateTime dateTime = task.getZonedDateTimeFomInstant (instant, zoneId);
        LOGGER.info("Current Day of The Week: " + task.getWeekDay(dateTime) + "\n");    
        LOGGER.info("Current Month: " + task.getMonth(dateTime) + "\n");       
        LOGGER.info("Current Year: " + task.getYear(dateTime) + "\n"); 
 
//4. Return the Weekday, Month and Year for the Given Time In Millis
        System.out.print("Enter time in millis: ");
        long millis = UtilsScan.getLong();
        Instant instant2 = task.getInstantEpochMilli(millis);
        ZonedDateTime dateTime2 = task.getZonedDateTimeFomInstant (instant2, zoneId);		
        LOGGER.info("For Given Millis - Day of The Week: " + task.getWeekDay(dateTime2) + "\n");       
        LOGGER.info("For Given Millis - Month: " + task.getMonth(dateTime2) + "\n");
        LOGGER.info("For Given Millis- Year: " + task.getYear(dateTime2) + "\n");         
    }
    
    private ZoneId getZoneID(BPDateTime task) throws InvalidException
    {
    	System.out.print("Want to use System Default ZoneID [Y/N]: ");
    	String given = UtilsScan.getString();
    	ZoneId zoneID;
		if (given.equalsIgnoreCase("Y"))
    	{
    		 zoneID = task.defaultZoneId();
    	}
    	else if (given.equalsIgnoreCase("N"))
    	{
    		System.out.println("Available ZoneIDs:");
    		List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());
            Collections.sort(zoneList);
            int size = UtilsSize.getSize(zoneList);
            int  num = 1;
            for (String zone : zoneList) 
            {
            	System.out.println(num + ". " + zone);
            	num++;
            }
            System.out.print("Enter The Serial No Of Selected ZoneID: ");
            int selected = UtilsScan.getInteger();
            UtilsCheck.checkZero(selected);
            UtilsCheck.checkWithinRange(selected, size);
            String zone = zoneList.get(selected-1);
            zoneID = task.zoneId(zone);
    	}
    	else
    	{
    		throw new InvalidException("InvalidInput");
    	}
    	return zoneID;
    }
    
    public  String getWorkingDirectory() 
	{
	    return System.getProperty("user.dir");
	}
    
	private void dynamicRunner() throws InvalidException
	{
		try
		{
			Class<?> pojoClass = Class.forName("com.utilshub.MessageInfo");
	        
	        Constructor<?>[] allConstructors = pojoClass.getDeclaredConstructors();
	        LOGGER.info("Constructors:\n");
	        for (Constructor<?> constructor : allConstructors) 
	        {
	            LOGGER.info(constructor + "\n");
	        }
	
	        Field[] fields = pojoClass.getDeclaredFields();
	        LOGGER.info("Fields:\n");
	        for (Field field : fields) 
	        {
	            LOGGER.info(field + "\n");
	        }
	
	        Method[] methods = pojoClass.getDeclaredMethods();
	        LOGGER.info("Methods:\n");
	        for (Method method : methods) 
	        {
	            LOGGER.info(method + "\n");
	        }
	            
// 1. Get and Invoke the Default Constructor
	        Constructor<?> defaultConstructor = pojoClass.getDeclaredConstructor();
	        Object pojoInstance1 = defaultConstructor.newInstance();
	        // pojoInstance1 = pojoClass.getDeclaredConstructor().newInstance();
	        LOGGER.info(pojoInstance1+ "\n");
	            
// 2. Get and Invoke the Overloaded Constructor
	        Constructor<?> overloadedConstructor = pojoClass.getDeclaredConstructor(String.class, int.class);
	        Object pojoInstance2 = overloadedConstructor.newInstance("Hello, Reflection!", 42);
	        // pojoInstance2 = pojoClass.getDeclaredConstructor().newInstance("Hello, Reflection!", 42);
	        LOGGER.info(pojoInstance2+ "\n");
	            
// 3. Get and Invoke a Getter Method (getMessage)
	        Method getMessageMethod = pojoClass.getMethod("getMessage");
	        String message = (String)getMessageMethod.invoke(pojoInstance2);
	        LOGGER.info(message + "\n");
	
// 4. Get and Invoke a Setter Method (setMessage)
	        Method setMessageMethod = pojoClass.getMethod("setMessage", String.class);
	        setMessageMethod.invoke(pojoInstance2, "Updated via Reflection!");
	        LOGGER.info("Updated Pojo Instance: " + pojoInstance2 + "\n");
		} 
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
        {
        	throw new InvalidException("Error occurred while dynamically using POJO class using Reflection", e);
        }
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
        		System.out.print("Enter the exercise to carry out : ");
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


	
