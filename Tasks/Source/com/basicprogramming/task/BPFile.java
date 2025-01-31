package com.basicprogramming.task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.exception.InvalidException;
import com.utilshub.UtilsCheck;

public class BPFile 
{
	
// Constructor for File
	public File createFile(String pathname) throws InvalidException 
    {
		UtilsCheck.checkNull(pathname);
		return new File(pathname);
    }
	
	public File createFile(String parent, String child) throws InvalidException 
    {
		UtilsCheck.checkNull(parent);
		UtilsCheck.checkNull(child);
		return new File(parent, child);
    }
	
//Create Directory if not found
	public void ensureDirectoryExists(String dirPath) throws InvalidException 
	{
        File dir = createFile(dirPath);
        if (!dir.exists()) 
        {
            dir.mkdirs();
        }
    }
	
// Method to write lines to a file
    public void writeToFile(String dirPath, String fileName, String[] lines) throws InvalidException, IOException 
    {
        UtilsCheck.checkNull(lines);
        File file = createFile(dirPath, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
        {
		    for (String line : lines) 
		    {
		    	UtilsCheck.checkNull(line);
		        writer.write(line);
		        writer.write(System.lineSeparator());
		    }
        } 
        catch (IOException e) 
        {
            throw new InvalidException("Error writing to file: ", e);
        }   
    }
    
}
