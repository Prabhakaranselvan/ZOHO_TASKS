package com.regex.inout;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.exception.InvalidException;
import com.regex.task.RegExTask;
import com.utilshub.LoggerUtils;
import com.utilshub.UtilsScan;

public class RegExRunner 
{
	private static final Logger LOGGER = LoggerUtils.createLogger(RegExRunner.class, "RegEx");
	RegExTask task = new RegExTask();
	
	
	private void exercise1() throws InvalidException
	{
		LOGGER.info("Ex_1: Mobile Number Validation");
		
		System.out.print("Enter your MobileNo: ");
		String mobileNo = UtilsScan.getString();
		
		boolean isValid = task.validatePhoneNo(mobileNo);
		LOGGER.info( isValid ? "Valid  Mobile No\n" : "Invalid  Mobile No\n");
	}
	
	private void exercise2() throws InvalidException
	{
		LOGGER.info("Ex_2: Validating Alphanumeric Strings");
		
		System.out.print("Enter an AlphaNumeric String: ");
		String alphaNumeric = UtilsScan.getString();
		
		boolean isValid = task.validateAlphaNumeric(alphaNumeric);
		LOGGER.info( isValid ? "Valid AlphaNumeric String\n" : "Invalid AlphaNumeric String\n");
	}
	
	private void exercise3a() throws InvalidException 
	{
	    LOGGER.info("Ex_3a: Starts with Matching String");
	    
	    System.out.print("Enter a String: ");
		String given = UtilsScan.getString();
		System.out.print("Enter Matching String: ");
		String match = UtilsScan.getString();
		
		boolean isValid = task.startsWith(match, given);
		LOGGER.info(given + " starts with " +  match + " : " + isValid + "\n");
	}

	private void exercise3b() throws InvalidException 
	{
	    LOGGER.info("Ex_3b: Contains Matching String");
	    
	    System.out.print("Enter a String: ");
		String given = UtilsScan.getString();
		System.out.print("Enter Matching String: ");
		String match = UtilsScan.getString();
		
		boolean isValid = task.contains(match, given);
		LOGGER.info(given + " contains " +  match + " : " + isValid + "\n");
	}

	private void exercise3c() throws InvalidException 
	{
	    LOGGER.info("Ex_3c: Ends with the Matching String");
	    
	    System.out.print("Enter a String: ");
		String given = UtilsScan.getString();
		System.out.print("Enter Matching String: ");
		String match = UtilsScan.getString();
		
		boolean isValid = task.endsWith(match, given);
		LOGGER.info(given + " ends with " +  match + " : " + isValid + "\n");
	}

	private void exercise3d() throws InvalidException 
	{
	    LOGGER.info("Ex_3d: Exact match for Matching String");
	    
	    System.out.print("Enter a String: ");
		String given = UtilsScan.getString();
		System.out.print("Enter Matching String: ");
		String match = UtilsScan.getString();
		
		boolean isValid = task.isExactMatch(match, given);
		LOGGER.info(given + " is a exact match of " +  match + " : " + isValid + "\n");
	}

	private void exercise4() throws InvalidException
	{
		LOGGER.info("Ex_4: Case-Insensitive String Matching in a List");
		
		List<String> list = getList();
		System.out.print("Enter Matching String: ");
		String match = UtilsScan.getString();
		
		LOGGER.info("Case_Insensitive - Matched Strings: ");
		LOGGER.info(task.getMatchingStrings(match, list) + "\n");
	}
	
	private void exercise5() throws InvalidException
	{
		LOGGER.info("Ex_5: Email Format Validation");
		
		System.out.print("Enter your Email: ");
		String email = UtilsScan.getString();
		
		boolean isValid = task.validateEmail(email);
		LOGGER.info( isValid ? "Valid Email format\n" : "Invalid Email format\n");
	}
	
	private void exercise6() throws InvalidException
	{
		LOGGER.info("Ex_6: Filtering Strings Based on Length Constraints (1 to 6 Characters)");
		
		List<String> list = getList();
		System.out.print("Enter Range-Minimum: ");
		int min = UtilsScan.getInteger();
		System.out.print("Enter Range-Maximum: ");
		int max = UtilsScan.getInteger();
		
		LOGGER.info("Strings Ranging between Length" + min +"-" + max + ": ");
		LOGGER.info(task.filterByLengthConstraint(list, min, max) + "\n");
		
	}
	
	private void exercise7() throws InvalidException
	{
		LOGGER.info("Ex_7: Mapping Matching Strings Between Two Lists");
		
		List<String> list1 = getList();
		LOGGER.info("Matcher Strings ");
		List<String> list2 = getList();
		
		LOGGER.info("Map Matching Strings Between Two Lists: ");
		LOGGER.info(task.getMatchesInList(list1, list2) + "\n");
	}
	
	private void exercise8() throws InvalidException
	{
		LOGGER.info("Ex_8: Extracting HTML Tags from a Raw HTML String");
		System.out.print("Enter Input: ");
		String input = UtilsScan.getString();
		List<String> list = task.getHtmlTags(input);
		int i=1;
		LOGGER.info("HTML Tags in the Input: ");
		for (String tags : list)
		{
			LOGGER.info(i + ". " + tags);
			i++;
		}
	}
	
	private List<String> getList() throws InvalidException 
	{
		System.out.print("Enter The No Of String: ");
		int num = UtilsScan.getInteger();
		List<String> list = new ArrayList<>();
		for (int i=1 ; i<=num ; i++ )
		{
			System.out.print("Enter String-" + i +" : ");
			list.add(UtilsScan.getString());
		}
		return list;
	}
	
	public static void main(String[] args)
	{
		boolean isContinue = true;
		String exercise;
		RegExRunner regEx = new RegExRunner();
		System.out.print("TASK : REGEX\n"
				+ "1. Mobile Number Validation\n"
				+ "2. Validating Alphanumeric Strings\n"
				+ "3a. Starts with Matching String\n"
				+ "3b. Contains Matching String\n"
				+ "3c. Ends with Matching String\n"
				+ "3d. Exact Match for Matching String\n"
				+ "4. Case-Insensitive String Matching in a List\n"
				+ "5. Email Format Validation\n"
				+ "6. Filtering Strings Based on Length Constraints (1 to 6 Characters)\n"
				+ "7. Mapping Matching Strings Between Two Lists\n"
				+ "8. Extracting HTML Tags from a Raw HTML String\n");
		while(isContinue)
		{
			try
			{
				System.out.print("\nEnter the Excercise to carry out : ");
				exercise = UtilsScan.getString();
				switch (exercise)
				{		
				case "1":
					regEx.exercise1();
					break;
					
				case "2":
					regEx.exercise2();
					break;
				
				case "3a":
					regEx.exercise3a();
					break;
					
				case "3b":
					regEx.exercise3b();
					break;
					
				case "3c":
					regEx.exercise3c();
					break;
					
				case "3d":
					regEx.exercise3d();
					break;
					
				case "4":
					regEx.exercise4();
					break;
				
				case "5":
					regEx.exercise5();
					break;
					
				case "6":
					regEx.exercise6();
					break;
					
				case "7":
					regEx.exercise7();
					break;
					
				case "8":
					regEx.exercise8();
					break;
					
				case "0":
					isContinue = false;
					break;
					
				default:
					LOGGER.info("Invalid Input\n");
					break;
				}
			}

			catch (Exception e) 
			{
				LOGGER.log(Level.SEVERE, "An exception occurred" , e);
			}
		}
	}
		
}
