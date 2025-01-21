package com.utilshub;
import java.util.Scanner;
import java.util.InputMismatchException;
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
			return scanner.nextInt();
		} 
		catch (InputMismatchException e) 
		{
			throw new InvalidException("Input Mismatch: Expected an integer", e);
		}
		finally
		{
			scanner.nextLine();
		}
	}

//Method to get a Double Value
	public static double getDouble() throws InvalidException
	{   
		try
		{ 
			return scanner.nextDouble();
		} 
		catch (InputMismatchException e) 
		{
			throw new InvalidException("Input Mismatch: Expected a double", e);
		}
		finally
		{
			scanner.nextLine();
		}
	}

//Method to get a Long Value
	public static long getLong() throws InvalidException
	{   
		try
		{ 
			return scanner.nextLong();
		} 
		catch (InputMismatchException e) 
		{
			throw new InvalidException("Input Mismatch: Expected a long", e);
		}
		finally
		{
			scanner.nextLine();
		}
	}


}