package com.helper;
import com.exception.InvalidException;

public class UtilsHub
{

//Method To Check Whether the String is Null or Empty
	public static void checkNull(Object str) throws InvalidException 
	{
        if (str == null) 
		{
            throw new InvalidException("Given Input is Null");
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
	
//Method To Check Whether the Input is Zero
	public static void checkZero(int str) throws InvalidException 
	{
        if (str == 0) 
		{
            throw new InvalidException("Input cannot be Zero");
        }
    }
	
}
	