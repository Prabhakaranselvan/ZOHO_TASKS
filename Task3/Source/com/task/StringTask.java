package com.task;


public class StringTask 
{
	private String str;
    	public void set(String str)
   	{
        	this.str = str;
    	}
   	public int getLength()												//Method for Exercise_1
    	{
		return str.length();
    	}
    	public char[] getCharArray() 											//Method for Exercise_2         
    	{
        	return str.toCharArray();
    	}
    	public char getfromLast(int fromLast)									//Method for Exercise_3
    	{
        	return str.charAt(str.length()-fromLast);
    	}
	public int getOccurance(char letter)									//Method for Exercise_4
    	{
		int i = 0;
		int occurance = 0;
		while (i < str.length())
		{
			if (letter == str.charAt(i)) 
			{
				occurance++; 
			}
			i++;
		}
        	return occurance;
	}
	 public int getGreatestPosition(char letter)								//Method for Exercise_5
    	{
		int i = str.lastIndexOf(letter);
		return (i+1);
    	}
	public String getLastCharacters(int last)									//Method for Exercise_6
	{
		return str.substring(str.length()-last);
	}
	public String getFirstCharacters(int first)									//Method for Exercise_7
	{
		return str.substring(0,first);
	}
	public String getReplaced(String startEnd, String replaceChars)				//Method for Exercise_8
	{
		if (startEnd.equalsIgnoreCase("start"))
		{
			return str.replaceFirst(str.substring(0,replaceChars.length()), replaceChars);
			
		}
		if (startEnd.equalsIgnoreCase("end"))
		{
			return str.substring(0, str.length() - replaceChars.length()) + replaceChars;
		}
		else 
		{
			startEnd = "Invalid Input was provided";
			return startEnd;
		}
	}
	public boolean checkStartsWith(String startsWith)							//Method for Exercise_9
	{
		return str.startsWith(startsWith);
	}
	public boolean checkEndsWith(String endsWith)							//Method for Exercise_10
	{
		return str.endsWith(endsWith);
	}	
	public String changeToLowerCase()									//Method for Exercise_11
	{
		return str.toLowerCase();
	}
	public String changeToUpperCase()									//Method for Exercise_12
	{
		return str.toUpperCase();
	}
	public String getReverse()											//Method for Exercise_13
    	{
		int i = str.length() - 1;
		String reverse = "";
		while (i  >= 0)
		{
			reverse += str.charAt(i);
			i--;
		}
		return reverse;
	}
	public String getMultipleStringLine()									//Method for Exercise_14
	{
		return str;
	}
	public String getConcatenatedLine()									//Method for Exercise_15
	{
		return str.replaceAll(" ","");
	}
	public String getStringArray()											//Method for Exercise_16
	{
		String[] stringArray = str.split(" ");
		String stringResult="{";
		for (int i = 0; i < stringArray.length; i++) 
		{
            		stringResult += "\"" + stringArray[i] + "\"";
           		 if (i < stringArray.length - 1) 
			{
				stringResult += ",";
			}
		}
		stringResult += "}";	
		return stringResult;
	}
	public String getMergedStrings(String[] stringArray)						//Method for Exercise_17
	{
		String mergedString = "";
        	for (int i = 0; i < stringArray.length; i++) 
		{
            		mergedString += stringArray[i];
           		 if (i < stringArray.length - 1) 
			{
                		mergedString += "-";
			}	
		}
		return mergedString;
	}
	public boolean checkEquals(String str2)									//Method for Exercise_18
	{
		return str.equals(str2);
	}
	public boolean checkEqualsIgnoreCase(String str2)						//Method for Exercise_19
	{
		return str.equalsIgnoreCase(str2);
	}
	public String getTrim()												//Method for Exercise_20
	{
		return str.trim();
	}

}
