package com.inout;
import java.util.Scanner;
import com.task.StringTask;

public class Runner
{
	public static void main (String[] abc)
    	{
		boolean isContinue = true;
		Scanner scanner = new Scanner(System.in);

		StringTask stringTask = new StringTask();
            	stringTask.set(abc[0]);

       	 	while(isContinue) 
		{
			System.out.print("Enter the Excercise to carry out : ");
			String exercise = scanner.nextLine();
			switch (exercise) 
			{		
			case "1":
                       		System.out.println("Length Of String : " + stringTask.getLength());
				break;
			case "2":
				System.out.print("CharArray : ");
				char[] characterArray = stringTask.getCharArray();
				for (int i = 0; i < characterArray.length; i++) 
				{
            				System.out.print(characterArray[i]);
					if (i < characterArray.length-1)
					{
						System.out.print(", ");
					}
           			}
				System.out.println();
				break;
			case "3":
				System.out.print("Enter the Position to be fetched from Last : ");
				int fromLast = scanner.nextInt();
				scanner.nextLine();
				System.out.println(fromLast + "Positioned Letter or Char from Last : " + stringTask.getfromLast(fromLast));
				break;
			case "4":
				System.out.print("Enter a character to find it's no of occurances : ");
       				char letter1 = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println("No of Occurance of  " + letter1 + " is " + stringTask.getOccurance(letter1));
				break;
			case "5":
				System.out.print("Enter a character to find it's Greatest position : ");
       				char letter2 = scanner.next().charAt(0);
				scanner.nextLine();
				int greatestPosition = stringTask.getGreatestPosition(letter2);
				if (greatestPosition > 0)
				{
					System.out.println("Greatest Position of  " + letter2 + " is " + greatestPosition);
				}
				else
				{
					System.out.println(letter2 + " is not found in the given String");
        			}  
				break; 
			case "6":
				System.out.print("No Of Last Characters to be printed : ");
				int last = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Last " + last + " Characters of the String : " + stringTask.getLastCharacters(last));
				break;
			case "7":
				System.out.print("No Of First Characters to be printed : ");
				int first = scanner.nextInt();
				scanner.nextLine();
				System.out.println("First " + first + " Characters of the String : " + stringTask.getFirstCharacters(first));
				break;

			case "8":
				System.out.print("Replacement should be made at Start or End : ");
				String startEnd = scanner.nextLine();
				System.out.print("Mention the Characters thats gonna Replace :  ");
				String replaceChars = scanner.nextLine();
				System.out.println("With " + replaceChars.length() + " Characters replaced at " + startEnd + " : " + stringTask.getReplaced(startEnd,replaceChars));  
				break;
			case "9":
				System.out.print("Enter the String to look for at Start : ");
				String startsWith = scanner.nextLine();
				System.out.println("Does the string starts with " + startsWith + " : " + stringTask.checkStartsWith(startsWith)); 
				break;
			case "10":
				System.out.print("Enter the String to look for at End : ");
				String endsWith = scanner.nextLine();
				System.out.println("Does the string ends with " + endsWith + " : " + stringTask.checkEndsWith(endsWith)); 
				break;
			case "11":
				System.out.println("String in Lower Case : " + stringTask.changeToLowerCase());
				break;
			case "12":
				System.out.println("String in Upper Case : " + stringTask.changeToUpperCase());
				break; 
			case "13":
				System.out.println("string in Reverse : " + stringTask.getReverse());
				break;
			case "14":
				System.out.print("Enter The Multiple String Line : ");
				stringTask.set(scanner.nextLine());
				System.out.println("Multiple String Line : " + stringTask.getMultipleStringLine());
				break;
			case "15":
				System.out.print("Enter The Line To be concatenated : ");
				stringTask.set(scanner.nextLine());
				System.out.println("Concatenated Line : " + stringTask.getConcatenatedLine());
				break;
			case "16":
				System.out.print("Enter The Line To be converted into string array : ");
				stringTask.set(scanner.nextLine());
				System.out.println("String Array : " + stringTask.getStringArray());
				
				break;
			case "17":
				System.out.print("Enter the number of strings to be merged: ");
        			int noOfStrings = scanner.nextInt();
				scanner.nextLine();
        			String[] stringArray = new String[noOfStrings];
        			for (int i = 0; i < noOfStrings; i++) 
				{
           				System.out.print("String " + (i + 1) + " : ");
            				stringArray[i] = scanner.nextLine();
				}
				System.out.println("Merged String : " + stringTask.getMergedStrings(stringArray));
        			break;
			case "18":
				System.out.print("String 1: ");
        			stringTask.set(scanner.nextLine());
        			System.out.print("String 2: ");
				String str2 = scanner.nextLine();
				boolean result = stringTask.checkEquals(str2);
        			System.out.println("Case sensitive - Given 2 String are equal : "  + result);
        			break;
			case "19":
				System.out.print("String 1: ");
        			stringTask.set(scanner.nextLine());
        			System.out.print("String 2: ");
				String str3 = scanner.nextLine();
				boolean result2 = stringTask.checkEqualsIgnoreCase(str3);
        			System.out.println("Case insensitive - Given 2 String are equal : "  + result2);
        			break;
			case "20":
				System.out.print("Enter a String with leading  and trailing whitespace : ");
        			stringTask.set(scanner.nextLine());
				System.out.println("Trimmed String : " + stringTask.getTrim());
				break;
			case "change":
				System.out.print("Enter new string: ");
				stringTask.set(scanner.nextLine());
				break;
			case "exit":
				isContinue = false;
				break;	
			default:
				System.out.println("Invalid Input");
				break;
			}
		}
	}
		   
}
