package com.task;


public class StringTask 
{
	private String str;
    	public void set(String str)
   	{
        	this.str = str;
    	}
   	public int getLength()										//Method for Exercise_1
    	{
		return str.length();
    	}
    	public void getCharArray() 									//Method for Exercise_2         
    	{
        	char[] characterArray = str.toCharArray();
		for (int i = 0; i < characterArray.length; i++) 
		{
            		System.out.print(characterArray[i]);
			if (i < characterArray.length-1)
			{
				System.out.print(", ");
			}
           	}
		System.out.println();
    	}
    	public char getLastBefore()									//Method for Exercise_3
    	{
        	return str.charAt(str.length() - 2);
    	}
	public int getOccurance(char letter)							//Method for Exercise_4
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
	 public int getGreatestPosition(char letter)						//Method for Exercise_5
    	{
		int i = str.lastIndexOf(letter);
		return (i+1);
    	}
	public String getLastFive()									//Method for Exercise_6
	{
		return str.substring(str.length()-5);
	}
	public String getFirstThree()								//Method for Exercise_7
	{
		return str.substring(0,3);
	}
	public String getReplaced()									//Method for Exercise_8
	{
		return str.replaceFirst(str.substring(0,3),"XYZ");
	}
	public boolean checkStartsWith()							//Method for Exercise_9
	{
		return str.startsWith("ent");
	}
	public boolean checkEndsWith()								//Method for Exercise_10
	{
		return str.endsWith("le");
	}	
	public String changeToLowerCase()							//Method for Exercise_11
	{
		return str.toLowerCase();
	}
	public String changeToUpperCase()							//Method for Exercise_12
	{
		return str.toUpperCase();
	}
	public void getReverse()									//Method for Exercise_13
    	{
		int i = str.length() - 1;
		while (i  >= 0)
		{
			System.out.print(str.charAt(i));
			i--;
		}
		System.out.println("");
	}
	public String getMultipleStringLine()							//Method for Exercise_14
	{
		return str;
	}
	public String getConcatenatedLine()							//Method for Exercise_15
	{
		return str.replaceAll(" ","");
	}
	public void getStringArray()								//Method for Exercise_16
	{
		String[] stringArray = str.split(" ");
		System.out.print("{");
		for (int i = 0; i < stringArray.length; i++) 
		{
            		System.out.print("\"" + stringArray[i] + "\"");
           		 if (i < stringArray.length - 1) 
			{
				System.out.print(",");
			}
		}
		System.out.println("}");	
	}
	public String getMergedStrings(String[] stringArray)				//Method for Exercise_17
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
	public boolean checkEquals(String str2)						//Method for Exercise_18
	{
		return str.equals(str2);
	}
	public boolean checkEqualsIgnoreCase(String str2)				//Method for Exercise_19
	{
		return str.equalsIgnoreCase(str2);
	}
	public String getTrim()									//Method for Exercise_20
	{
		return str.trim();
	}

}
