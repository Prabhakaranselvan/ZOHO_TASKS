package com.stringbuilder.inout;
import java.util.Scanner;
import com.exception.InvalidException;
import com.stringbuilder.task.SBTasks;

public class SBRunner
{	
	private static SBTasks sbTask = new SBTasks();
	private static Scanner scanner = new Scanner(System.in);
	
	//Method to get Initial Strings
	private static String[] getStringList()
	{
		System.out.print("Enter the number of strings : ");
		int numStrings = scanner.nextInt();
		scanner.nextLine();
		String[] strings = new String[numStrings];
		for (int i = 0; i < numStrings; i++) 
		{
			System.out.print("Enter string " + (i+1) + " : ");
			strings[i] = scanner.nextLine();
		}
		return strings;
	}
	
	//Method to create Initial StringBuilder
	private static StringBuilder getInitialSB(String[] strings, String delimiter) throws InvalidException
	{
		int length = SBTasks.getLength(strings);
		StringBuilder sb = sbTask.createSB(strings[0]);
        for(int i=1; i<length; i++) 
		{
			sbTask.addString(sb, delimiter);
            sbTask.addString(sb, strings[i]);
        }
		return sb;
	}
	
	//Method to get Delimiter
	private static String getDelimiter()
	{
		System.out.print("Enter the delimiter  : ");
		return scanner.nextLine();
	}
	
	//Method To Print
	private static void printSBDetails(StringBuilder sb, String str) throws InvalidException
    {
		int length = SBTasks.getLength(sb);
		System.out.println("\n" + str + " StringBuilder : " + sb);
		System.out.println(str + " Length Of the StringBuilder : " + length);
    }
	
	private static void exercise1() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 1 : APPEND A STRING\n");
			
			StringBuilder sb = sbTask.createSB();
			printSBDetails(sb, "Initial" );
			
			System.out.print("Enter the String To be Added : ");	
			String str = scanner.nextLine();
			sbTask.addString(sb, str);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
			
	}	
	
	private static void exercise2() throws InvalidException
	{
		try
		{	System.out.println("\nEXCERCISE 2 : APPEND STRINGS\n");
			
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
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
	}
	
	private static void exercise3() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 3 : INSERT STRINGS\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			System.out.print("\nInsertion takes place between n and n+1 Strings\nHere, n is ");
			int position = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Insertion takes place between strings " + position + " and " + (position + 1));
			
			System.out.println("\nFINAL STRINGS");
			strings = getStringList();
			sbTask.insertStrings(sb, strings, delimiter, position);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
	}
	
	private static void exercise4() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 4 : DELETE STRINGS\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			System.out.print("\nEnter the No Of Strings To be Deleted : ");
			int numStrings = scanner.nextInt();
			scanner.nextLine();
			int[] numbers = new int[numStrings];
			for (int i=1; i<=numStrings ; i++)
			{
				System.out.print("Enter string Num : ");
				numbers[i-1] = scanner.nextInt();
				scanner.nextLine();
			}
			
			sbTask.deleteStrings(sb, strings, delimiter, numbers);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}	
	}
	
	private static void exercise5() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 5 : REPLACE DELIMITER\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			System.out.print("\nEnter the Replacement delimiter : ");
			String delimiter2 = scanner.nextLine();
			
			int noOfReplacement = SBTasks.getLength(strings)-1;
			sbTask.replacedelimiter(sb, delimiter, delimiter2, noOfReplacement);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}	
	}
	
	private static void exercise6() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 6 : REVERSE STRINGBUILDER\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			sbTask.reverseStrings(sb);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}	
	}
	
	private static void exercise7() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 7 : DELETE CHARACTERS\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			System.out.print("\nStart Deleting Characters from Index : ");
			int start = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Delete Characters Till Index :");
			int end = scanner.nextInt();
			scanner.nextLine();
			
			sbTask.deleteCharacters(sb, start, end);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
	}
	
	private static void exercise8() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 8 : REPLACE CHARACTERS\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			System.out.print("\nStart replacing Characters from Index : ");
			int start = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Replace Characters Till Index :");
			int end = scanner.nextInt();
			scanner.nextLine();
			System.out.print ("Replacement String : ");
			String replaceStr = scanner.nextLine();
			
			sbTask.replaceCharacters(sb, start, end, replaceStr);
			printSBDetails(sb, "Final");
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
	}
	
	private static void exercise9() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 9 : GET FIRST INDEX OF DELIMITER\n");
			
			System.out.println("INITIAL STRINGS");
			String[] strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			int index = sbTask.firstIndexOf(sb, delimiter);
			System.out.println("\nFirst Index of " + delimiter + " : " + index); 
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
	}
	
	private static void exercise10() throws InvalidException
	{
		try
		{	System.out.println("\nEXERCISE 10 : GET LAST INDEX OF DELIMITER\n");
			
			System.out.println("INITIAL STRINGS");
			String[]strings = getStringList();
			String delimiter = getDelimiter();
			StringBuilder sb = getInitialSB(strings, delimiter);
			printSBDetails(sb, "Initial");
			
			int index = sbTask.lastIndexOf(sb, delimiter);
			System.out.println("\nLast Index of " + delimiter + " : " + index);
		}
		catch (InvalidException e) 
		{
			throw new InvalidException("Exception Occured", e);
		}
	}
	
	public static void main (String[] abc) throws InvalidException
    {
		boolean isContinue = true;
		String exercise;

		try
		{
			while(isContinue)
			{
				try
				{
					System.out.print("\nEnter the Excercise to carry out : ");
					exercise = scanner.nextLine();
					switch (exercise)
					{		
					case "1":
						exercise1();
						break;
							
					case "2":
						exercise2();
						break;

					case "3":
						exercise3();
						break;
					
					case "4":
						exercise4();
						break;
						
					case "5":
						exercise5();
						break;
					
					case "6":
						exercise6();
						break;
						
					case "7":
						exercise7();
						break;
						
					case "8":
						exercise8();
						break;
						
					case "9":
						exercise9();
						break;
					
					case "10":
						exercise10();
						break; 
					
				/*	case "test":
						StringBuilder sb = sbTask.createSB("1");
						//StringBuilder sb = null;
						String[] strings ={"2","3", "4"};
						//String[] strings = null;
						String delimiter = null;
						sbTask.addStrings(sb, strings, delimiter);
						System.out.println(sb);
						int num = sb.indexOf("null");
						sb.replace(1,5,delimiter);
						//String []strings2 = {"123","456"};
						//int num = sb.lastIndexOf(delimiter);
						//int num = sbTask.customIndexOf(sb,delimiter,4);
						//sbTask.insertStrings(sb,strings2,delimiter,2);
						System.out.println(num);
						System.out.println(sb); */
						
					case "exit":
						isContinue = false;
						break;
						
					default:
						System.out.println("Invalid Input");
						break;
					}
				}

				catch (InvalidException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		finally
		{
			scanner.close();
		}
	}
}