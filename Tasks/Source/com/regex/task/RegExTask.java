package com.regex.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.basicprogramming.task.BPProperties;
import com.exception.InvalidException;
import com.utilshub.UtilsCheck;
import com.utilshub.UtilsSize;

public class RegExTask 
{
	private static String phoneNo;
    private static String alphaNumeric;
    private static String email;
    private static String htmlTag;
    
	static 
    {
        try 
        {
        	BPProperties bpProperties = new BPProperties();
        	Properties properties = bpProperties.loadProperties("config", "regEx-config.properties");
            phoneNo = bpProperties.getValue(properties, "PhoneNo");
            alphaNumeric = bpProperties.getValue(properties, "AlphaNumeric");
            email = bpProperties.getValue(properties, "Email");
            htmlTag = bpProperties.getValue(properties, "HTMLTag");
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        
    }
	
	public boolean checkPattern(String regEx, String input) throws InvalidException
	{
		UtilsCheck.checkNull(regEx);
		UtilsCheck.checkNull(input);
        return Pattern.matches(regEx, input);
	}
	
//1. Mobile Number Validation
	public boolean validatePhoneNo(String input) throws InvalidException
	{
		return checkPattern(phoneNo, input);
	}

//2. Validating Alphanumeric Strings
	public boolean validateAlphaNumeric(String input) throws InvalidException
	{
		return checkPattern(alphaNumeric, input);
	}
	
//3. String Matching: Start, Contain, End, and Exact Match
	public boolean startsWith(String match, String given) throws InvalidException 
	{
        return checkPattern("^" + match + ".*", given);
    }

    public boolean contains(String match, String given) throws InvalidException 
    {
        return checkPattern(".*" + match + ".*", given);
    }

    public boolean endsWith(String match, String given) throws InvalidException 
    {
        return checkPattern(".*" + match + "$", given);
    }

    public boolean isExactMatch(String match, String given) throws InvalidException 
    {
        return checkPattern("^" + match + "$", given);
    }
    
//4. Case-Insensitive String Matching in a List
    public List<String> getMatchingStrings(String match, List<String> list) throws InvalidException
    {
    	UtilsCheck.checkNull(list);
    	UtilsCheck.checkNull(match);
    	String regex = "(?i)" + Pattern.quote(match);
    	List<String> resultList = new ArrayList<>();
    	for (String given : list)
    	{
    		if(checkPattern(regex, given))
			{
    			resultList.add(given);
			}
    	}
    	return resultList;
    }
  
//5. Email Format Validation
    public boolean validateEmail(String input) throws InvalidException
	{
		return checkPattern(email, input);
	}

//6. Filtering Strings Based on Length Constraints (1 to 6 Characters)
    public List<String> filterByLengthConstraint(List<String> list, int min, int max) throws InvalidException
    {
    	UtilsCheck.checkNull(list);
    	UtilsCheck.checkWithinRange(min, max);
    	String regex = "^.{"+ min + "," + max + "}$";
    	List<String> resultList = new ArrayList<>();
    	for (String given : list)
    	{
    		if(checkPattern(regex, given))
			{
    			resultList.add(given);
			}
    	}
    	return resultList;
    }

//7. Mapping Matching Strings Between Two Lists
    public Map<String, List<Integer>> getMatchesInList(List<String> list1, List<String> list2) throws InvalidException
    {
    	int length = UtilsSize.getSize(list1);
        UtilsCheck.checkNull(list2);
       
        Map<String, List<Integer>> resultMap = new HashMap<>();
        
    	for (String matches : list2)
    	{
    		List<Integer> indices = new ArrayList<>();
        	for (int i=0; i<length ; i++)
        	{
        		if(checkPattern(matches, list1.get(i)))
    			{
        			indices.add(i);
    			}
        	}
    		resultMap.put(matches, indices);
    	}
    	return resultMap;
    }
    
//8. Extracting HTML Tags from a Raw HTML String
    public List<String> getHtmlTags(String input) throws InvalidException
    {
    	UtilsCheck.checkNull(input);
    	List<String> resultList = new ArrayList<>();
    	Pattern pattern = Pattern.compile(htmlTag);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) 
        {
            resultList.add(matcher.group());
        }
    	return resultList;
    }
}
