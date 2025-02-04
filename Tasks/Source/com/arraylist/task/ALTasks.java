package com.arraylist.task;
import java.util.List;
import java.util.Properties;
import java.lang.reflect.Constructor;
//import java.util.ArrayList;
import java.util.Collection;

import com.basicprogramming.task.BPProperties;
import com.exception.InvalidException;
import com.utilshub.UtilsCheck;
import com.utilshub.UtilsSize;

public class ALTasks
{
	
	
	private static Class<?> arrayListClass;
    static 
    {
        try 
        {
        	BPProperties bpProperties = new BPProperties();
        	Properties properties = bpProperties.loadProperties("config", "list-config.properties");
            String className = bpProperties.getValue(properties, "ListImplementation");
            arrayListClass = Class.forName(className);
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        
    }
    
//Method to create an List of a specific type
    @SuppressWarnings("unchecked")
	public <T> List<T> createAL() throws InvalidException 
	{
		try
		{
	         Constructor<?> constructor = arrayListClass.getDeclaredConstructor();
	         return (List<T>) constructor.newInstance();
	         //return new ArrayList<>();
		}
		catch (Exception e)
		{
			throw new InvalidException ("Failed to create ArrayList via Reflection", e);
		}
    }
	
    @SuppressWarnings("unchecked")
	public <T> List<T> createAL(Collection<T> collection) throws InvalidException
	{
		UtilsCheck.checkNull(collection);
		try 
		{
            Constructor<?> constructor = arrayListClass.getDeclaredConstructor(Collection.class);
            return (List<T>) constructor.newInstance(collection);
	        //return new ArrayList<>(collection);
		}
		catch (Exception e)
		{
			throw new InvalidException ("Failed to create ArrayList via Reflection", e);
		}
	}
	
    @SuppressWarnings("unchecked")
    public <T> List<T> createAL(int initialCapacity) throws InvalidException 
	{
    	try 
		{
    		Class<?> arrayListClass = Class.forName("java.util.ArrayList");
    		Constructor<?> constructor = arrayListClass.getDeclaredConstructor(int.class);
            return (List<T>) constructor.newInstance(initialCapacity);
    		//return new ArrayList<>(initialCapacity);
		}
		catch (Exception e)
		{
			throw new InvalidException ("Failed to create ArrayList via Reflection", e);
		}
	}

//Method to Add Elements
	public <T> void addElement(List<T> list, T element) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		list.add(element);
	}

//Method to Add Elements at specified Index
	public <T> void addElement(List<T> list, T element, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index, size);
		list.add(index, element);
	}
	
//Method to Add All Elements from One AL to Another
	public <T> void addAllElements(List<T> mainList, List<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(mainList);
		UtilsCheck.checkNull(list);
		mainList.addAll(list);
	}

//Method to Add All Elements from One AL to Another at specified Index	
	public <T> void addAllElementsAtIndex(List<T> mainList, List<T> list, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(mainList);
		UtilsCheck.checkWithinRange(index, size);
		UtilsCheck.checkNull(list);
		mainList.addAll(index, list);
	}
	
//Method to Find First Occurance OF Given Object
	public <T> int getIndex(List<T> list, Object Obj) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.indexOf(Obj);
	}

//Method to Find Last Occurance OF Given Object
	public <T> int getLastIndex(List<T> list, Object Obj) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.lastIndexOf(Obj);
	}

//Method to Find Element at Specified Index
	public <T> T getElement(List<T> list, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index, size);
		return list.get(index);
	}

//Method to Check presence of Element
	public <T> boolean checkElement(List<T> list, Object Obj) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.contains(Obj);
	}
	
//Method to create Sublist from an List
	public <T> List<T> getSubList(List<T> list,int index1, int index2) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index2, size);
		UtilsCheck.checkWithinRange(index1, index2);
		return createAL(list.subList(index1, index2));
	}
	
//Method to Remove Element at Specified Index
	public <T> void removeElement(List<T> list, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index, size);
		list.remove(index);
	}
	
//Method to Remove common Elements
	public <T> void removeAllElements(List<T> mainList, List<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(mainList);
		UtilsCheck.checkNull(list);
		mainList.removeAll(list);
	}
	
//Method to Retain common Elements
	public <T> void retainAllElements(List<T> mainList, List<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(mainList);
		UtilsCheck.checkNull(list);
		mainList.retainAll(list);
	}
	
//Method to clear all Elements
	public <T> void clearAllElements(List<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		list.clear();
	}
	
//Method to find Duplicates
	public <T> List<T> findDuplicates(List<T> list) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		List<T> duplicates = createAL() ;
		for (int i = 0; i < size; i++) 
		{
			T element = getElement(list,i);
			for (int j = i + 1; j < size; j++) 
			{
				if (element.equals(getElement(list,j)) && !checkElement(duplicates,element))
				{
					addElement(duplicates,element);
					break;
				}
			}
		}
		return duplicates;
	}
}