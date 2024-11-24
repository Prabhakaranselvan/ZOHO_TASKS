package com.stringbuilder.task;
import com.helper.UtilsHub;
import com.exception.InvalidException;

public class SBTasks
{
	//Methods to Create String Builder
	public StringBuilder createSB()
	{
		StringBuilder sb = new StringBuilder();
		return sb;
	}
	
	public StringBuilder createSB(int capacity)
	{
		StringBuilder sb = new StringBuilder(capacity);
		return sb;
	}
	
	public StringBuilder createSB(String str) throws InvalidException
	{
		UtilsHub.checkNull(str);
		StringBuilder sb = new StringBuilder(str);
		return sb;
	}
	
	public StringBuilder createSB(CharSequence cs) throws InvalidException
	{
		UtilsHub.checkNull(cs);
		StringBuilder sb = new StringBuilder(cs);
		return sb;
	}
	
	//Method To Get Length
   	public static int getLength(CharSequence cs) throws InvalidException
    {
		UtilsHub.checkNull(cs);
		return cs.length();
    }
	public static int getLength(String[] strArray) throws InvalidException
    {
		UtilsHub.checkNull(strArray);
		return strArray.length;
    }
	public static int getLength(int[] intArray) throws InvalidException
    {
		UtilsHub.checkNull(intArray);
		return intArray.length;
    }
	
	
	//Method To check Negative Index
	public static void checkNegIndex(int index) throws InvalidException
	{
		if (index < 0)
		{
			throw new InvalidException("Negative Indexing Occured : Searched String Unavailable");
		}
	}

	//Method for Exercise_1
	public void addString(StringBuilder sb, String str) throws InvalidException
	{
		sb.append(str);
	}
	
	//Method for Exercise_2
	public void addStrings(StringBuilder sb, String[] strings, String delimiter) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		int length = getLength(strings);
        for(int i=0; i<length; i++) 
		{
			sb.append(delimiter);
            sb.append(strings[i]);
        }
    }

	//Method for Exercise_3
	public void insertStrings(StringBuilder sb, String[] strings, String delimiter, int position) throws InvalidException
	{   
		int length = getLength(strings);
		int delimiterLen = getLength(delimiter);
		int insertIndex = customIndexOf(sb, delimiter, position);
        for (int i=length; i>0; i--)
		{
            sb.insert(insertIndex, strings[i-1]);
			sb.insert(insertIndex, delimiter);
        }
    }
	
	//Method for Exercise_4
	public void deleteStrings(StringBuilder sb, String[] strings, String delimiter, int[] num) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		int length = getLength(strings);
		int numLen = getLength(num);
		int delimiterLen = getLength(delimiter);
		String str;
		int index,strLen,check;
        for (int i = 0; i < numLen; i++) 
		{
			check = num[i];
			UtilsHub.checkWithinRange(check, length);
			str = strings[check-1];
			index = firstIndexOf(sb, str);
			strLen = getLength(str);
			if (num[i]==1)
			{
				sb.delete(index,(index+strLen+delimiterLen));
			}
			if (num[i]>1)
			{
				sb.delete((index-delimiterLen),(index+strLen));
			}
        }
    }
	
	//Method for Exercise_5
	public void replacedelimiter(StringBuilder sb, String delimiter1, String delimiter2, int noOfReplacement) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(delimiter2);
		int delimiterLen = getLength(delimiter1);
		int fromIndex = 0;
        for(int i=0 ; i<noOfReplacement; i++) 
		{
			int replaceIndex = indexOfFromSpecified(sb,delimiter1, fromIndex);
			sb.replace(replaceIndex,(replaceIndex+delimiterLen), delimiter2);
			fromIndex = replaceIndex+delimiterLen ;
		}
    }
	
	//Method for Exercise_6
	public void reverseStrings(StringBuilder sb) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		sb.reverse();
	}
	
	//Method for Exercise_7
	public void deleteCharacters(StringBuilder sb, int start, int end) throws InvalidException
	{
		int length = getLength(sb);
		UtilsHub.checkWithinRange(start, end);
		UtilsHub.checkWithinRange(end, length);
		sb.delete(start, end);
	}
	
	//Method for Exercise_8
	public void replaceCharacters(StringBuilder sb, int start, int end, String str) throws InvalidException
	{
		UtilsHub.checkNull(str);
		int length = getLength(sb);
		UtilsHub.checkWithinRange(start, end);
		UtilsHub.checkWithinRange(end, length);
		sb.replace(start, end, str);
	}
	
	//Method for Exercise_9
	public int firstIndexOf(StringBuilder sb, String str) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(str);
		int index = sb.indexOf(str);
		checkNegIndex(index); 
		return index;
	}
	
	//Method for Exercise_10
	public int lastIndexOf(StringBuilder sb, String str) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(str);
		int index = sb.lastIndexOf(str);
		checkNegIndex(index);
		return index;
		
	}
	
	//Method for custom Index position of a String
	public int customIndexOf(StringBuilder sb, String str, int position) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(str);
		int index = 0;
		int fromIndex = 0;    
		for (int i=0; i<position; i++)
		{
			index = sb.indexOf(str, fromIndex);
			fromIndex = index+1;
		}
		checkNegIndex(index); 
		return index;
	}
	
	//Method for First Index Of String from Specified Index
	public int indexOfFromSpecified(StringBuilder sb, String str, int fromIndex) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(str);
		int index = sb.indexOf(str, fromIndex);
		checkNegIndex(index); 
		return index;
	}
}
