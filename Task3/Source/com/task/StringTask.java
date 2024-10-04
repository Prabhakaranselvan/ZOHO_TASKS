package com.task;
import com.exception.InvalidException;

public class StringTask 
{
//Method To Check Whether the String is Null or Empty
	private void checkNullOrEmpty(String str) throws InvalidException 
	{
        if (str == null || str.isEmpty()) 
		{
            throw new InvalidException("String is Null or Empty");
        }
    }

//Method To Check Whether The Given No is Within Range
	private void checkWithinRange(int range, int length) throws InvalidException 	
	{
        if (range > length || range <= 0) 
		{
            throw new InvalidException("Input is not within Required Range");
        }
    }
//Method for Exercise_1
   	public int getLength(String str) throws InvalidException
    {
		checkNullOrEmpty(str);
		return str.length();
    }

//Method for Exercise_2
    public char[] getCharArray(String str) throws InvalidException       
    {
		checkNullOrEmpty(str);
       	return str.toCharArray();
    }

//Method for Exercise_3
    public char getfromLast(String str, int fromLast) throws InvalidException		
    {
		checkNullOrEmpty(str);
       	checkWithinRange(fromLast, str.length());
       	return str.charAt(str.length() - fromLast);
    }

//Method for Exercise_4
	public int getOccurance(String str, char letter) throws InvalidException		
    {
		checkNullOrEmpty(str);
		int i = 0;
		int occurance = 0;
		int length = str.length();
		while (i < length)
		{
			if (letter == str.charAt(i)) 
			{
				occurance++; 
			}
			i++;
		}
       	return occurance;
	}

//Method for Exercise_5
	 public int getGreatestPosition(String str, char letter) throws InvalidException						
    {
		checkNullOrEmpty(str);
		int i = str.lastIndexOf(letter);
		return (i+1);
    }
		
//Method for Exercise_6
	public String getLastCharacters(String str, int last) throws InvalidException						
	{
		checkNullOrEmpty(str);
       	checkWithinRange(last, str.length());
		return str.substring(str.length()-last);
	}

//Method for Exercise_7
	public String getFirstCharacters(String str, int first) throws InvalidException						
	{
		checkNullOrEmpty(str);
       	checkWithinRange(first, str.length());
		return str.substring(0,first);
	}

//Method for Exercise_8
	public String getStartingReplaced(String str, String replaceChars) throws InvalidException			
	{
		checkNullOrEmpty(str);
       	checkNullOrEmpty(replaceChars);
       	checkWithinRange(replaceChars.length(), str.length());
		return str.replaceFirst(str.substring(0,replaceChars.length()), replaceChars);
	}

//Method for Exercise_8
	public String getEndingReplaced(String str, String replaceChars) throws InvalidException					
	{
		checkNullOrEmpty(str);
       	checkNullOrEmpty(replaceChars);
       	checkWithinRange(replaceChars.length(), str.length());
		return str.substring(0, str.length() - replaceChars.length()) + replaceChars;
	}

//Method for Exercise_9
	public boolean checkStartsWith(String str, String startsWith) throws InvalidException				
	{
		checkNullOrEmpty(str);
       	checkNullOrEmpty(startsWith);
		return str.startsWith(startsWith);
	}

//Method for Exercise_10
	public boolean checkEndsWith(String str, String endsWith)	throws InvalidException	
	{
		checkNullOrEmpty(str);
       	checkNullOrEmpty(endsWith);
		return str.endsWith(endsWith);
	}

//Method for Exercise_11	
	public String changeToLowerCase(String str) throws InvalidException
	{
		checkNullOrEmpty(str);
		return str.toLowerCase();
	}

//Method for Exercise_12
	public String changeToUpperCase(String str)	 throws InvalidException
	{
		checkNullOrEmpty(str);
		return str.toUpperCase();
	}

//Method for Exercise_13
	public String getReverse(String str) throws InvalidException
	{
		checkNullOrEmpty(str);
		char[] reverse = str.toCharArray();
		int j = 0;
		int k = reverse.length - 1;
		while (j < k)
		{
			char temp = reverse[j] ;
			reverse[j] = reverse[k] ;
			reverse[k] =temp ;
			j++ ;
			k-- ;
		}
		return new String(reverse);
		
	}

//Method for Exercise_14
	public String getMultipleStringLine(String str) throws InvalidException
	{
		checkNullOrEmpty(str);
		return str;
	}

//Method for Exercise_15
	public String getConcatenatedLine(String str) throws InvalidException
	{
		checkNullOrEmpty(str);
		return str.replaceAll(" ","");
	}

//Method for Exercise_16
	public String[] getStringArray(String str) throws InvalidException
	{
		checkNullOrEmpty(str);
		return str.split(" ");
	}

//Method for Exercise_17
	public String getMergedStrings(String toJoin,String[] mergedStringArray) throws InvalidException
	{
		checkNullOrEmpty(toJoin);
       	if (mergedStringArray == null || mergedStringArray.length == 0) 
		{
        	throw new InvalidException("Invalid input for merging strings");
     	}
		return String.join(toJoin,mergedStringArray);
	}

//Method for Exercise_18
	public boolean checkEquals(String str1, String str2) throws InvalidException
	{
		checkNullOrEmpty(str1);
        checkNullOrEmpty(str2);
		return str1.equals(str2);
	}

//Method for Exercise_19
	public boolean checkEqualsIgnoreCase(String str1,String str2) throws InvalidException
	{
		checkNullOrEmpty(str1);
        checkNullOrEmpty(str2);
		return str1.equalsIgnoreCase(str2);
	}

//Method for Exercise_20
	public String getTrim(String str) throws InvalidException
	{
		checkNullOrEmpty(str);
		return str.trim();
	}

}

	
	

