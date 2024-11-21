package com.stringbuilder.inout;
import java.util.Scanner;
import java.util.ArrayList;
import com.exception.InvalidException;
import com.stringbuilder.task.SBTasks;

public class SBRunner
{	
	//Method to get Initial Strings
	private static String[] getStringList(Scanner scanner)
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
	
	//Method to get Additional Strings
	private static void updateStringList(ArrayList<String> strings,Scanner scanner, int position)
	{
		System.out.print("Enter the number of strings : ");
		int numStrings = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < numStrings; i++) 
		{
			System.out.print("Enter string " + (i+1) + " : ");
			strings.add(position,scanner.nextLine());
			position++;
		}
	}
	
	//Method to get Delimiter
	private static String getDelimiter(Scanner scanner)
	{
		System.out.print("Enter the delimiter  : ");
		return scanner.nextLine();
	}
	
	//Method To Print
	private static void printSBDetails(StringBuilder sb, String str) throws InvalidException 
    {
		int length = SBTasks.getLength(sb);
		System.out.println(str + " StringBuilder : " + sb);
		System.out.println(str + " Length Of the StringBuilder : " + length);
    }
		
	public static void main (String[] abc) throws InvalidException
    {
		SBTasks sbTask = new SBTasks();
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> strings = new ArrayList<>();
		boolean isContinue = true;
		String taskInput,exercise;
		StringBuilder sb = sbTask.createSB();
		
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
						printSBDetails(sb, "Initial" );
						System.out.print("Enter the String To be Added : ");	
						taskInput = scanner.nextLine();
						sbTask.addString(sb, taskInput);
						printSBDetails(sb, "Final");
						break;
							
					case "2":
						System.out.println("INITIAL STRINGS");
						Strings[] strings = getStringList(scanner);
						String delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB();
						printSBDetails(sb, "Initial");
						
						int size = strings.size();
						
						System.out.println("FINAL STRINGS");
						getStringList(strings, scanner);
						String delimiter2 = getDelimiter(scanner);
						/*
						sb = null;
						strings = null;
						String delimiter2 = null;
						int size = 0;*/
						sbTask.addStrings(sb, strings, size, delimiter2);
						printSBDetails(sb, "Final");
						
						break;

					case "3":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						size = strings.size();
						
						System.out.print("Insertion takes place between n and n+1 Strings\nHere, n is ");
						int position = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Insertion takes place between strings " + position + " and " + (position + 1));
						
						System.out.println("FINAL STRINGS");
						updateStringList(strings, scanner, position);
						delimiter2 = getDelimiter(scanner);
						size = strings.size()-size;
						sbTask.insertStrings(sb, strings, delimiter1, delimiter2, position, size);
						printSBDetails(sb, "Final");
						break;
					
					case "4":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						System.out.print("Enter the No Of Strings To be Deleted : ");
						int numStrings = scanner.nextInt();
						scanner.nextLine();
						int[] numbers = new int[numStrings];
						for (int i=1; i<=numStrings ; i++)
						{
							System.out.print("Enter string Num : ");
							numbers[i-1] = scanner.nextInt();
							scanner.nextLine();
						}
						
						sbTask.deleteStrings(sb, strings, delimiter1, numbers);
						printSBDetails(sb, "Final");
						break;
						
					case "5":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						System.out.print("Enter the Replacement delimiter : ");
						delimiter2 = scanner.nextLine();
						
						size = strings.size();
						
						int noOfReplacement = size-1;
						sbTask.replacedelimiter(sb, delimiter1, delimiter2, noOfReplacement);
						printSBDetails(sb, "Final");
						break;
					
					case "6":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						sbTask.reverseStrings(sb);
						printSBDetails(sb, "Final");
						break;
						
					case "7":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						System.out.print("Start Deleting Characters from Index : ");
						int start = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Delete Characters Till Index :");
						int end = scanner.nextInt();
						scanner.nextLine();
						
						sbTask.deleteCharacters(sb, start, end);
						printSBDetails(sb, "Final");
						break;
						
					case "8":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						System.out.print("Start replacing Characters from Index : ");
						start = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Replace Characters Till Index :");
						end = scanner.nextInt();
						scanner.nextLine();
						System.out.print (" Replacement String");
						String replaceStr = scanner.nextLine();
						
						sbTask.replaceCharacters(sb, start, end, replaceStr);
						printSBDetails(sb, "Final");
						break;
						
					case "9":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						int index = sbTask.firstIndexOf(sb, delimiter1);
						System.out.print("First Index of " + delimiter1 + " : " + index); 
						break;
					
					case "10":
						strings.clear();
						System.out.println("INITIAL STRINGS");
						getStringList(strings, scanner);
						delimiter1 = getDelimiter(scanner);
						sb = sbTask.createSB(String.join(delimiter1, strings));
						printSBDetails(sb, "Initial");
						
						index = sbTask.lastIndexOf(sb, delimiter1);
						System.out.print("Last Index of " + delimiter1 + " : " + index); 
						break; 
					
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