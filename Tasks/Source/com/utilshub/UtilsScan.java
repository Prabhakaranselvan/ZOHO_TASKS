package com.utilshub;
import java.util.Scanner;
import com.exception.InvalidException;

public class UtilsScan
{
	private static Scanner scanner = new Scanner(System.in);
	
//method to get an Input from user
	public static String getString()
	{
			return scanner.nextLine();
	}
	
//Method to get an Integer Value
	public static int getInteger() throws InvalidException
	{	
		try
		{ 
			return Integer.parseInt(getString());
		} 
		catch (NumberFormatException e) 
		{
			throw new InvalidException("Input Mismatch: Expected an integer", e);
		} 
	}

//Method to get Double Value	
	public static double getDouble() throws InvalidException 
	{
		try 
		{
			return Double.parseDouble(getString());
		} 
		catch (NumberFormatException e) 
		{
			throw new InvalidException("Input Mismatch: Expected a double value", e);
		}
	}

//Method to get long Value	
	public static long getLong() throws InvalidException 
	{
    try 
	{
        return Long.parseLong(getString());
    } 
	catch (NumberFormatException e) 
	{
        throw new InvalidException("Input Mismatch: Expected a long value", e);
    }
}


}