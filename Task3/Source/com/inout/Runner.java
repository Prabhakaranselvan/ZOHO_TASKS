package com.inout;
import java.util.Scanner;
import com.task.StringTask;
import com.exception.InvalidException;


public class Runner
{
	public static void main (String[] abc)
    {
		boolean isContinue = true;
		Scanner scanner = new Scanner(System.in);
		StringTask stringTask = new StringTask();
		String taskInput;
		if (abc.length == 0) 
		{
            System.out.println("Initial input string is not provided");
			System.out.print("Enter new String :");
			taskInput = scanner.nextLine();
		}
		else
		{
			taskInput = abc[0];
		}
       	while(isContinue) 
		{
			System.out.print("Enter the Excercise to carry out : ");
			String exercise = scanner.nextLine();
			
			switch (exercise) 
			{		
			case "1":
				try
				{
					System.out.println("GET LENGTH OF STRING");
                    System.out.println("Length Of String : " + stringTask.getLength(taskInput));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;

			case "2":
				try
				{
					System.out.println("GET CHARACTER ARRAY");
					System.out.print("Enter a string: ");
                	taskInput = scanner.nextLine();
					System.out.print("CharArray : ");
					char[] characterArray = stringTask.getCharArray(taskInput);
					int charArrayLen = characterArray.length;
					for (int i = 0; i < charArrayLen; i++) 
					{
            			System.out.print(characterArray[i]);
						if (i < charArrayLen-1)
						{
							System.out.print(", ");
						}
           			}
					System.out.println();
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }				
				break;

			case "3":
				try
				{
					System.out.println("GET CHARACTER FROM LAST");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("Enter the Position to be fetched from Last : ");
					int fromLast = scanner.nextInt();
					scanner.nextLine();
					System.out.println(fromLast + " Positioned Letter or Char from Last : " + stringTask.getFromLast(taskInput, fromLast));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "4":
				try
				{	System.out.println("GET OCCURANCE OF CHARACTER");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("Enter a character to find it's no of occurances : ");
					char letter1 = scanner.next().charAt(0);
					scanner.nextLine();
					System.out.println("No of Occurance of  " + letter1 + " is " + stringTask.getOccurance(taskInput, letter1));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "5":
				try
				{
					System.out.println("GET GREATEST INDEX OF A CHARACTER");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("Enter a character to find it's Greatest Index : ");
					char letter2 = scanner.next().charAt(0);
					scanner.nextLine();
					int greatestIndex = stringTask.getGreatestIndex(taskInput, letter2);
					if (greatestIndex > 0)
					{
						System.out.println("Greatest Index of " + letter2 + " is " + greatestIndex);
					}
					else
					{
						System.out.println(letter2 + " is not found in the given String");
						}  
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break; 
				
			case "6":
				try
				{
					System.out.println("GET LAST N CHARACTERS");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("No Of Last Characters to be printed : ");
					int last = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Last " + last + " Characters of the String : " + stringTask.getLastCharacters(taskInput, last));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "7":
				try
				{
					System.out.println("GET FIRST N CHARACTERS");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("No Of First Characters to be printed : ");
					int first = scanner.nextInt();
					scanner.nextLine();
					System.out.println("First " + first + " Characters of the String : " + stringTask.getFirstCharacters(taskInput, first));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "8":
				try
				{
					System.out.println("REPLACE STARTING/ENDING CHARACTERS");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("Replacement should be made at Start or End : ");
					String startEnd = scanner.nextLine();
					System.out.print("No of characters to be Replaced at " + startEnd + " : ");
					int noOfChar = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Mention the Characters thats gonna Replace : ");
					String replaceChars = scanner.nextLine();
					if (startEnd.equalsIgnoreCase("start"))
					{
						System.out.println("With " + noOfChar + " Characters replaced at " + startEnd + " : " + stringTask.getStartingReplaced(taskInput, noOfChar, replaceChars)); 
					}
					else if (startEnd.equalsIgnoreCase("end"))
					{
						System.out.println("With " + noOfChar + " Characters replaced at " + startEnd + " : " + stringTask.getEndingReplaced(taskInput, noOfChar, replaceChars)); 
					} 
					else
					{
						System.out.println("Invalid Condition was Given");
					}
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "9":
				try
				{
					System.out.println("CHECK IF STRING STARTS WITH");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("Enter the String to look for at Start : ");
					String startsWith = scanner.nextLine();
					System.out.println("Does the string starts with " + startsWith + " : " + stringTask.checkStartsWith(taskInput, startsWith)); 
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "10":
				try
				{
					System.out.println("CHECK IF STRING ENDS WITH");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.print("Enter the String to look for at End : ");
					String endsWith = scanner.nextLine();
					System.out.println("Does the string ends with " + endsWith + " : " + stringTask.checkEndsWith(taskInput, endsWith)); 
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "11":
				try
				{
					System.out.println("CHANGE TO LOWERCASE");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.println("String in Lower Case : " + stringTask.changeToLowerCase(taskInput));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "12":
				try
				{
					System.out.println("CHANGE TO UPPERCASE");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();
					System.out.println("String in Upper Case : " + stringTask.changeToUpperCase(taskInput));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "13":
				try
				{
					System.out.println("REVERSE STRING");
					System.out.print("Enter a string: ");
					taskInput = scanner.nextLine();		
					System.out.println("reversed String : " + stringTask.getReverse(taskInput));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
           		case "14":
				try
				{	System.out.println("MULTIPLE STRING LINE");
					System.out.print("Enter The Multiple String Line : ");
					taskInput = scanner.nextLine();
					System.out.println("Multiple String Line : " + stringTask.getMultipleStringLine(taskInput));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
			case "15":
				try
				{
					System.out.println("CONCATENATE LINE");
					System.out.print("Enter The Line To be concatenated: ");
					taskInput = scanner.nextLine();
					System.out.print("Enter The Character for Concatenation: ");
					String concatenateAt = scanner.nextLine();
					System.out.print("Enter The Character to Concatenate: ");
					String concatenateWith = scanner.nextLine();
					System.out.println("Concatenated Line : " + stringTask.getConcatenatedLine(taskInput, concatenateAt, concatenateWith));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "16":
				try
				{
					System.out.println("GET STRING ARRAY");
					System.out.print("Enter The Line To be converted into string array : ");
					taskInput = scanner.nextLine();
					System.out.print("Enter Where the Split must Occur: ");
					String splitAt = scanner.nextLine();
					String[] stringArray = stringTask.getStringArray(taskInput, splitAt);
					int strArrayLen = stringArray.length;
					String stringResult="{";
					for (int i = 0; i < strArrayLen; i++) 
					{
						stringResult += "\"" + stringArray[i] + "\"";
						if (i < strArrayLen - 1) 
						{
							stringResult += ",";
						}
					}
					stringResult += "}";	
					System.out.println("String Array : " + stringResult);
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }	
				break;
				
			case "17":
				try
				{
					System.out.println("MERGE STRINGS");
					System.out.print("Enter the number of strings to be merged: ");
					int noOfStrings = scanner.nextInt();
					scanner.nextLine(); 
					System.out.print("Enter the Character used to merge: ");
					String toJoin = scanner.nextLine();
					String[] mergedStringArray = new String[noOfStrings];
					for (int i = 0; i < noOfStrings; i++) 
					{
						System.out.print("String " + (i + 1) + " : ");
						mergedStringArray[i] = scanner.nextLine();
					}
					System.out.println("Merged String : " + stringTask.getMergedStrings(toJoin,mergedStringArray));
        		}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "18":
				try
				{
					System.out.println("CHECK IF STRINGS ARE EQUAL");
					System.out.print("String 1: ");
					String taskInput1 = scanner.nextLine();
					System.out.print("String 2: ");
					String taskInput2 = scanner.nextLine();
					boolean result = stringTask.checkEquals(taskInput1, taskInput2);
					System.out.println("Case sensitive - Given 2 String are equal : "  + result);
        		}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
				
			case "19":
				try
				{
					System.out.println("CHECK IF STRINGS ARE EQUAL(Ignore Case)");
					System.out.print("String 1: ");
					String taskInput1 = scanner.nextLine();
					System.out.print("String 2: ");
					String taskInput2 = scanner.nextLine();
					boolean result2 = stringTask.checkEqualsIgnoreCase(taskInput1, taskInput2);
					System.out.println("Case insensitive - Given 2 String are equal : "  + result2);
        		}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
			case "20":
				try
				{
					System.out.println("REMOVE LEADING & TRAILING WHITE SPACES");
					System.out.print("Enter a String with leading  and trailing whitespace : ");
					taskInput = scanner.nextLine();
					System.out.println("Trimmed String : " + stringTask.getTrim(taskInput));
				}
				catch (InvalidException e) 
				{
                    System.out.println(e.getMessage());
                }
				break;
					
			case "change":
				System.out.print("Enter new string: ");
				taskInput = scanner.nextLine();
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
