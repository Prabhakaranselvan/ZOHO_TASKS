package com.string.task;
import com.utilshub.UtilsCheck;
import com.exception.InvalidException;

public class StringTask 
{

//Method for Exercise_1
   	public int getLength(String str) throws InvalidException
    {
		UtilsCheck.checkNull(str);
		return str.length();
    }

//Method for Exercise_2
    public char[] getCharArray(String str) throws InvalidException       
    {
		UtilsCheck.checkNull(str);
       	return str.toCharArray();
    }

//Method for Exercise_3
    public char getFromLast(String str, int fromLast) throws InvalidException		
    {
		int length = getLength(str);
		UtilsCheck.checkZero(length);
		UtilsCheck.checkZero(fromLast);
		UtilsCheck.checkWithinRange(fromLast, length);
		return str.charAt(length - fromLast);
    }

//Method for Exercise_4
	public int getOccurance(String str, char letter) throws InvalidException		
    {
		UtilsCheck.checkNull(str);
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
	 public int getGreatestIndex(String str, char letter) throws InvalidException						
    {
		UtilsCheck.checkNull(str);
		int i = str.lastIndexOf(letter);
		return (i);
    }
		
//Method for Exercise_6
	public String getLastCharacters(String str, int last) throws InvalidException						
	{
		int length = getLength(str);
       	UtilsCheck.checkWithinRange(last, length);
		return str.substring(length - last);
	}

//Method for Exercise_7
	public String getFirstCharacters(String str, int first) throws InvalidException						
	{
		int length = getLength(str);
       	UtilsCheck.checkWithinRange(first, length);
		return str.substring(0,first);
	}

//Method for Exercise_8
	public String getStartingReplaced(String str,int noOfChar, String replaceChars) throws InvalidException			
	{
		int length = getLength(str);
       	UtilsCheck.checkNull(replaceChars);
		UtilsCheck.checkWithinRange(noOfChar, length);
		return str.replaceFirst(str.substring(0,noOfChar), replaceChars);	
	}

//Method for Exercise_8
	public String getEndingReplaced(String str,int noOfChar, String replaceChars) throws InvalidException					
	{
		int length = getLength(str);
		UtilsCheck.checkNull(replaceChars);
       	UtilsCheck.checkWithinRange(noOfChar, length);
		return str.substring(0, length - noOfChar) + replaceChars;
	}

//Method for Exercise_9
	public boolean checkStartsWith(String str, String startsWith) throws InvalidException				
	{
		UtilsCheck.checkNull(str);
       	UtilsCheck.checkNull(startsWith);
		return str.startsWith(startsWith);
	}

//Method for Exercise_10
	public boolean checkEndsWith(String str, String endsWith)	throws InvalidException	
	{
		UtilsCheck.checkNull(str);
       	UtilsCheck.checkNull(endsWith);
		return str.endsWith(endsWith);
	}

//Method for Exercise_11	
	public String changeToLowerCase(String str) throws InvalidException
	{
		UtilsCheck.checkNull(str);
		return str.toLowerCase();
	}

//Method for Exercise_12
	public String changeToUpperCase(String str)	 throws InvalidException
	{
		UtilsCheck.checkNull(str);
		return str.toUpperCase();
	}

//Method for Exercise_13
	public String getReverse(String str) throws InvalidException
	{
		char[] reverse = getCharArray(str);
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
		UtilsCheck.checkNull(str);
		return str;
	}

//Method for Exercise_15
	public String getConcatenatedLine(String str, String concatenateAt, String concatenateWith) throws InvalidException
	{
		UtilsCheck.checkNull(str);
		return str.replaceAll(concatenateAt, concatenateWith);
	}

//Method for Exercise_16
	public String[] getStringArray(String str, String splitAt) throws InvalidException
	{
		UtilsCheck.checkNull(str);
		return str.split(splitAt);
	}

//Method for Exercise_17
	public String getMergedStrings(String toJoin,String[] mergedStringArray) throws InvalidException
	{
       	UtilsCheck.checkNull(mergedStringArray);
		return String.join(toJoin,mergedStringArray);
	}

//Method for Exercise_18
	public boolean checkEquals(String str1, String str2) throws InvalidException
	{
		UtilsCheck.checkNull(str1);
        UtilsCheck.checkNull(str2);
		return str1.equals(str2);
	}

//Method for Exercise_19
	public boolean checkEqualsIgnoreCase(String str1,String str2) throws InvalidException
	{
		UtilsCheck.checkNull(str1);
        UtilsCheck.checkNull(str2);
		return str1.equalsIgnoreCase(str2);
	}

//Method for Exercise_20
	public String getTrim(String str) throws InvalidException
	{
		UtilsCheck.checkNull(str);
		return str.trim();
	}

}

	
	

