package com.utilshub;
import com.exception.InvalidException;

public class UtilsCheck
{

//Method To Check Whether the String is Null or Empty
	public static void checkNull(Object input) throws InvalidException 
	{
        if (input == null) 
		{
            throw new InvalidException("Null Input Occured");
        }
    }

//Method To Check Whether The Given No is Within Range
	public static void checkWithinRange(int range, int length) throws InvalidException 	
	{
		
        if (range > length || range < 0) 
		{
            throw new InvalidException("Input is not within Required Range");
        }
    }
	
//Method To check Negative Index
	public static void checkNegative(int input) throws InvalidException
	{
		if (input < 0)
		{
			throw new InvalidException("Negative Input Occured");
		}
	}
	
//Method To Check Whether the Input is Zero
	public static void checkZero(int input) throws InvalidException 
	{
        if (input == 0) 
		{
            throw new InvalidException("Input cannot be Zero");
        }
    }
}
	