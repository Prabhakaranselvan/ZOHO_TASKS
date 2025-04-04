package com.stringbuilder.inout;
import com.exception.InvalidException;
import com.utilshub.UtilsCheck;
import com.utilshub.UtilsSize;
import com.utilshub.UtilsScan;
import com.stringbuilder.task.SBTasks;

public class SBRunner
{	
	SBTasks sbTask = new SBTasks();
		
	//Method to get Initial Strings
	private String[] getStringList() throws InvalidException
	{
		System.out.print("Enter the number of strings : ");
		int numOfStrings = UtilsScan.getInteger();
		UtilsCheck.checkNegative(numOfStrings);
		String[] strings = new String[numOfStrings];
		for (int i = 0; i < numOfStrings; i++) 
		{
			System.out.print("Enter string " + (i+1) + " : ");
			strings[i] = UtilsScan.getString();
		}
		return strings;
	}
	
	//Method to create Initial StringBuilder
	private StringBuilder getInitialSB(String[] strings, String delimiter) throws InvalidException
	{
		int length = UtilsSize.getLength(strings);
		if (length != 0)
		{
			StringBuilder sb = sbTask.createSB(strings[0]);
			for(int i=1; i<length; i++) 
			{
				sbTask.addString(sb, delimiter);
				sbTask.addString(sb, strings[i]);
			}
			return sb;
		}
		else
		{
			StringBuilder sb = sbTask.createSB();
			return sb;
		}
		
	}
	
	//Method to get Delimiter
	private String getDelimiter()
	{
		System.out.print("Enter the delimiter  : ");
		return UtilsScan.getString();
	}
	
	//Method To Print
	private void printSBDetails(StringBuilder sb, String str) throws InvalidException
    {
		int length = UtilsSize.getLength(sb);
		System.out.println("\n" + str + " StringBuilder : " + sb);
		System.out.println(str + " Length Of the StringBuilder : " + length);
    }
	
	private void exercise1() throws InvalidException
	{
		System.out.println("\nEXERCISE 1 : APPEND A STRING");
		
		StringBuilder sb = sbTask.createSB();
		printSBDetails(sb, "Initial");
		
		System.out.print("Enter the String To be Added : ");	
		String str = UtilsScan.getString();
		sbTask.addString(sb, str);
		printSBDetails(sb, "Final");
	}	
	
	private void exercise2() throws InvalidException
	{
		System.out.println("\nEXCERCISE 2 : APPEND STRINGS\n");
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		System.out.println("\nFINAL STRINGS");
		strings = getStringList();
		sbTask.addStrings(sb, strings, delimiter);
		printSBDetails(sb, "Final");
	}
	
	private void exercise3() throws InvalidException
	{
		System.out.println("\nEXERCISE 3 : INSERT STRINGS\n");
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		System.out.print("\nEnter the String Num before which Insertion must occur : ");
		int position = UtilsScan.getInteger();
		
		System.out.println("\nFINAL STRINGS");
		strings = getStringList();
		sbTask.insertStrings(sb, strings, delimiter, position);
		printSBDetails(sb, "Final");
	}
	
	private void exercise4() throws InvalidException
	{
		System.out.println("\nEXERCISE 4 : DELETE A STRING\n");
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		System.out.print("\nEnter the String Number To be Deleted : ");
		int position = UtilsScan.getInteger();
		
		sbTask.deleteStrings(sb, delimiter, position);
		printSBDetails(sb, "Final");	
	}
	
	private void exercise5() throws InvalidException
	{
		System.out.println("\nEXERCISE 5 : REPLACE DELIMITER\n");
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		System.out.print("\nEnter the Replacement delimiter : ");
		String delimiter2 = UtilsScan.getString();
		
		sbTask.replaceDelimiter(sb, delimiter, delimiter2);
		printSBDetails(sb, "Final");	
	}
	
	private void exercise6() throws InvalidException
	{
		System.out.println("\nEXERCISE 6 : REVERSE STRINGBUILDER\n");
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		sbTask.reverseStrings(sb);
		printSBDetails(sb, "Final");	
	}
	
	private void exercise7() throws InvalidException
	{
		System.out.println("\nEXERCISE 7 : DELETE CHARACTERS\n"); 
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		System.out.print("\nStart Deleting Characters from Index : ");
		int start = UtilsScan.getInteger();
		System.out.print("Delete Characters Till Index :");
		int end = UtilsScan.getInteger();
		
		sbTask.deleteCharacters(sb, start, end);
		printSBDetails(sb, "Final");
	}
	
	private void exercise8() throws InvalidException
	{
		System.out.println("\nEXERCISE 8 : REPLACE CHARACTERS\n");
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		System.out.print("\nStart replacing Characters from Index : ");
		int start = UtilsScan.getInteger();
		System.out.print("Replace Characters Till Index :");
		int end = UtilsScan.getInteger();
		System.out.print ("Replacement String : ");
		String replaceStr = UtilsScan.getString();
		
		sbTask.replaceCharacters(sb, start, end, replaceStr);
		printSBDetails(sb, "Final");
	}
	
	private void exercise9() throws InvalidException
	{
		System.out.println("\nEXERCISE 9 : GET FIRST INDEX OF DELIMITER\n");
		
		System.out.println("INITIAL STRINGS");
		String[] strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		int index = sbTask.firstIndexOf(sb, delimiter);
		System.out.println("\nFirst Index of " + delimiter + " : " + index); 
	}
	
	private void exercise10() throws InvalidException
	{
		System.out.println("\nEXERCISE 10 : GET LAST INDEX OF DELIMITER\n");
		
		System.out.println("INITIAL STRINGS");
		String[]strings = getStringList();
		String delimiter = getDelimiter();
		StringBuilder sb = getInitialSB(strings, delimiter);
		printSBDetails(sb, "Initial");
		
		int index = sbTask.lastIndexOf(sb, delimiter);
		System.out.println("\nLast Index of " + delimiter + " : " + index);
	}
	
	public static void main (String[] abc) throws InvalidException
    {
		boolean isContinue = true;
		String exercise;
		SBRunner sbRunner = new SBRunner();
		System.out.print("TASK : STRING_BUILDER\n\n1. APPEND A STRING\n2. APPEND STRINGS\n3. INSERT STRINGS\n4. DELETE A STRING\n5. REPLACE DELIMITER\n6. REVERSE STRINGBUILDER\n7. DELETE CHARACTERS\n8. REPLACE CHARACTERS\n9. GET FIRST INDEX OF DELIMITER\n10. GET LAST INDEX OF DELIMITER\nEnter 0 to Exit\n");
		while(isContinue)
		{
			try
			{
				System.out.print("\nEnter the Excercise to carry out : ");
				exercise = UtilsScan.getString();
				switch (exercise)
				{		
				case "1":
					sbRunner.exercise1();
					break;
						
				case "2":
					sbRunner.exercise2();
					break;

				case "3":
					sbRunner.exercise3();
					break;
				
				case "4":
					sbRunner.exercise4();
					break;
					
				case "5":
					sbRunner.exercise5();
					break;
				
				case "6":
					sbRunner.exercise6();
					break;
					
				case "7":
					sbRunner.exercise7();
					break;
					
				case "8":
					sbRunner.exercise8();
					break;
					
				case "9":
					sbRunner.exercise9();
					break;
				
				case "10":
					sbRunner.exercise10();
					break; 
				
			/*	case "test":
					StringBuilder sb = sbTask.createSB("1");
					String[] strings ={"2","3", "4"};
					String[] strings2 = {"123","456"};
					//String delimiter = "--";
					//StringBuilder sb = null;
					//String[] strings = null;
					String delimiter = null;
					
					sbTask.addStrings(sb, strings, delimiter);
					
					int num = sb.indexOf("null");
					//int num = sb.lastIndexOf(delimiter);
					//int num = sbTask.customIndexOf(sb,delimiter,4);
					//sbTask.insertStrings(sb,strings2,delimiter,2);
					System.out.println(num);
					System.out.println(sb); */
					
				case "0":
					isContinue = false;
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
				}
			}

			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}