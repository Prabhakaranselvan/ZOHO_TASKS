package com.stringbuilder.task;
import com.exception.InvalidException;
import com.utilshub.UtilsCheck;
import com.utilshub.UtilsSize;
import java.util.Arrays;

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
		UtilsCheck.checkNull(str);
		StringBuilder sb = new StringBuilder(str);
		return sb;
	}
	
	public StringBuilder createSB(CharSequence cs) throws InvalidException
	{
		UtilsCheck.checkNull(cs);
		StringBuilder sb = new StringBuilder(cs);
		return sb;
	}

	//Method for Exercise_1
	public void addString(StringBuilder sb, String str) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		sb.append(str);
	}
	
	//Method for Exercise_2
	public void addStrings(StringBuilder sb, String[] strings, String delimiter) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		int length = UtilsSize.getLength(strings);
        for(int i=0; i<length; i++) 
		{
			sb.append(delimiter);
            sb.append(strings[i]);
        }
    }

	//Method for Exercise_3
	public void insertStrings(StringBuilder sb, String[] strings, String delimiter, int position) throws InvalidException
	{   
		UtilsCheck.checkNull(sb);
		int length = UtilsSize.getLength(strings);
		int delimiterLen = UtilsSize.getLength(delimiter);
		UtilsCheck.checkZero(position);
		UtilsCheck.checkNegative(position);
		int insertIndex;
		if (position == 1)
		{
			insertIndex = 0;
		}
		else
		{
			insertIndex = customIndexOf(sb, delimiter, position-1);
			UtilsCheck.checkNegative(insertIndex);
			insertIndex = insertIndex+delimiterLen;
		}
		for (int i=length; i>0; i--)
		{
			sb.insert(insertIndex, delimiter);
			sb.insert(insertIndex, strings[i-1]);
		}
    }
	
	//Method for Exercise_4
	public void deleteStrings(StringBuilder sb, String delimiter, int position) throws InvalidException
	{
		int Length = UtilsSize.getLength(sb);
		int delimiterLen = UtilsSize.getLength(delimiter);
		UtilsCheck.checkZero(position);
		UtilsCheck.checkNegative(position);
		int index1 = customIndexOf(sb, delimiter, position-1);
		UtilsCheck.checkNegative(index1);
		int index2 = customIndexOf(sb, delimiter, position);
		if (position == 1)
		{
			index2 = index2+delimiterLen;
		}
		else if (index2 == -1)
		{
			index2 = Length;
		}
		sb.delete(index1,index2);
    }
	
	//Method for Exercise_5
	public void replaceDelimiter(StringBuilder sb, String delimiter1, String delimiter2) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		int delimiterLen = UtilsSize.getLength(delimiter1);
		UtilsCheck.checkNull(delimiter2);
		boolean replace = true;
        while(replace) 
		{
			int index = firstIndexOf(sb, delimiter1);
			if (index != -1)
			{
				sb.replace(index,(index+delimiterLen), delimiter2);
			}
			else
			{
				replace = false;
			}
		}
    }
	
	//Method for Exercise_6
	public void reverseStrings(StringBuilder sb) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		sb.reverse();
	}
	
	//Method for Exercise_7
	public void deleteCharacters(StringBuilder sb, int start, int end) throws InvalidException
	{
		int length = UtilsSize.getLength(sb);
		UtilsCheck.checkWithinRange(start, end);
		UtilsCheck.checkWithinRange(end, length);
		sb.delete(start, end);
	}
	
	//Method for Exercise_8
	public void replaceCharacters(StringBuilder sb, int start, int end, String str) throws InvalidException
	{
		int length = UtilsSize.getLength(sb);
		UtilsCheck.checkWithinRange(start, end);
		UtilsCheck.checkWithinRange(end, length);
		UtilsCheck.checkNull(str);
		sb.replace(start, end, str);
	}
	
	//Method for Exercise_9
	public int firstIndexOf(StringBuilder sb, String str) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		UtilsCheck.checkNull(str);
		return sb.indexOf(str);
	}
	
	//Method for Exercise_10
	public int lastIndexOf(StringBuilder sb, String str) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		UtilsCheck.checkNull(str);
		return sb.lastIndexOf(str);	
	}
	
	//Method for custom Index position of a String
	public int customIndexOf(StringBuilder sb, String str, int position) throws InvalidException
	{
		UtilsCheck.checkNull(sb);
		UtilsCheck.checkNull(str);
		UtilsCheck.checkNegative(position);
		int index = 0;
		int fromIndex = 0;    
		for (int i=0; i<position; i++)
		{
			index = sb.indexOf(str, fromIndex);
			fromIndex = index+1;
		} 
		return index;
	}
	
	//Method for Delete Multiple Strings
	public void deleteStrings(StringBuilder sb, String delimiter, Integer[] stringPosition) throws InvalidException
	{
		int Length = UtilsSize.getLength(sb);
		int delimiterLen = UtilsSize.getLength(delimiter);
		int numOfStrings = UtilsSize.getLength(stringPosition);
		int index1,index2,num,position;
		Arrays.sort(stringPosition);
        for (int i = 0; i < numOfStrings; i++) 
		{
			num = stringPosition[i];
			if (num==1)
			{
				index1 = firstIndexOf(sb, delimiter);
				sb.delete(0,(index1+delimiterLen));
			}
			if (num>1)
			{
				position = num-i-1;
				index1 = customIndexOf(sb, delimiter, position);
				index2 = customIndexOf(sb, delimiter, position+1);
				if (index2 != -1)
				{
					sb.delete(index1,index2);
				}
				else
				{
					sb.delete(index1,Length);
				}
			}
        }
    }
}
