package com.stringbuilder.task;
import java.util.ArrayList;
import com.helper.UtilsHub;
import com.exception.InvalidException;

public class SBTasks
{
	//constructors
	public StringBuilder createSB()
	{
		StringBuilder sb = new StringBuilder();
		return sb;
	}
	
	public StringBuilder createSB(CharSequence cs) throws InvalidException
	{
		UtilsHub.checkNull(cs);
		StringBuilder sb = new StringBuilder(cs);
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
	
	//Method To Get Length
   	public static int getLength(CharSequence cs) throws InvalidException
    {
		UtilsHub.checkNull(cs);
		return cs.length();
    }

	//Method for Exercise_1
	public void addString(StringBuilder sb, String str) throws InvalidException
	{
		sb.append(str);
		System.out.println(sb);
	}
	
	//Method for Exercise_2
	public void addStrings(StringBuilder sb, ArrayList<String> strings, int startIndex, String delimiter) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(strings);
		UtilsHub.checkNull(delimiter);
		int length = strings.size();
        for(int i=startIndex; i<length; i++) 
		{
			sb.append(delimiter);
            sb.append(strings.get(i));
        }
    }

	//Method for Exercise_3
	public void insertStrings(StringBuilder sb, ArrayList<String> strings, String delimiter1, String delimiter2, int position, int size) throws InvalidException
	{   
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(strings);
		UtilsHub.checkNull(delimiter1);
		UtilsHub.checkNull(delimiter2);
		int i = position+size;
		String str = strings.get(i);
		int insertIndex = firstIndexOf(sb,str);
		int start = insertIndex - getLength(delimiter1);
		
		replaceCharacters(sb, start, insertIndex, delimiter2);
        for (int j=i-1; j >= position; j--) 
		{
			sb.insert(insertIndex, delimiter2);
            sb.insert(insertIndex, strings.get(j));
			
        }
    }
	
	//Method for Exercise_4
	public void deleteStrings(StringBuilder sb, ArrayList<String> strings, String delimiter, int[] num) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(strings);
		UtilsHub.checkNull(delimiter);
		String str;
		int index,strLen;
		int length = num.length;
		int delimiterLen = getLength(delimiter);
        for (int i = 0; i < length; i++) 
		{
			str = strings.get(num[i]-1);
			index = sb.indexOf(str);
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
		int fromIndex = 0;
		int delimiterLen = getLength(delimiter1);
        for(int i=0 ; i<noOfReplacement; i++) 
		{
			int replaceIndex = sb.indexOf(delimiter1, fromIndex);
			if (replaceIndex != -1)
			{
				sb.replace(replaceIndex,(replaceIndex+delimiterLen), delimiter2);
				fromIndex = replaceIndex+delimiterLen ;
			}
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
	public int firstIndexOf(StringBuilder sb, String delimiter) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(delimiter);
		return sb.indexOf(delimiter);
	}
	
	//Method for Exercise_10
	public int lastIndexOf(StringBuilder sb, String delimiter) throws InvalidException
	{
		UtilsHub.checkNull(sb);
		UtilsHub.checkNull(delimiter);
		return sb.lastIndexOf(delimiter);
	}
}
