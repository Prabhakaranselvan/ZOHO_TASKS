package com.basicprogramming.task;

import java.util.Properties;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.exception.InvalidException;
import com.utilshub.UtilsCheck;

public class BPProperties 
{
	BPFile bpFile = new BPFile();
// Constructor for Properties
	public Properties createProperties()  
    {
		return new Properties();
    }
	
//Method to add Key-Value Pairs
	public void addKeyValuePair(Properties properties, String key, String value) throws InvalidException
    {
		UtilsCheck.checkNull(key);
		UtilsCheck.checkNull(value);
		properties.setProperty(key, value);
    }
	
// Method to store Properties to a specified file
    public void storeProperties(Properties properties,String dirPath, String fileName, String comments) throws InvalidException, IOException 
    {
    	UtilsCheck.checkNull(properties);
    	UtilsCheck.checkNull(comments);
        File file = bpFile.createFile(dirPath,fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
        {       
        properties.store(writer, comments);
        } 
		catch (IOException e) 
	    {
	        throw new InvalidException("Error writing to file: ", e);
	    }
    }


//Method to load properties from a file
	public void loadProperties(Properties properties,String dirPath, String fileName) throws InvalidException, IOException 
	{
		UtilsCheck.checkNull(properties);
        File file = bpFile.createFile(dirPath,fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
        
        properties.load(reader); 
        } 
		catch (IOException e) 
	    {
			throw new InvalidException("Error reading from file: ", e);
	    }
	}
}
