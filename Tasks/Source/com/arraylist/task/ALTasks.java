package com.arraylist.task;
import java.util.*;
import com.exception.InvalidException;
import com.utilshub.*;

public class ALTasks
{

//Method to create an ArrayList of a specific type	
	public <T> ArrayList<T> createAL() 
	{
        return new ArrayList<>();
    }
	
	public <T> ArrayList<T> createAL(Collection<T> collection) 
	{
		UtilsCheck.checkNull(collection);
        return new ArrayList<>(collection);
	}
	
    public <T> ArrayList<T> createAL(int initialCapacity) 
	{
        return new ArrayList<>(initialCapacity);
	}

//Method to Add Elements
	public <T> void addElement(ArrayList<T> list, T element) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		list.add(element);
	}

//Method to Add Elements at specified Index
	public <T> void addElement(ArrayList<T> list, T element, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index, size);
		list.add(index, element);
	}
	
//Method to Add All Elements from One AL to Another
	public <T> void addAllElements(ArrayList<T> mainList, ArrayList<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(mainList);
		UtilsCheck.checkNull(list);
		MainList.addAll(list);
	}

//Method to Add All Elements from One AL to Another at specified Index	
	public <T> void addAllElementsAtIndex(ArrayList<T> mainList, ArrayList<T> list, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(mainList);
		UtilsCheck.checkWithinRange(index, size);
		UtilsCheck.checkNull(list);
		MainList.addAll(index, list);
	}
	
//Method to Find First Occurance OF Given Object
	public <T> int getIndex(ArrayList<T> list, Object Obj) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.indexOf(Obj);
	}

//Method to Find Last Occurance OF Given Object
	public <T> int getLastIndex(ArrayList<T> list, Object Obj) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.lastIndexOf(Obj);
	}

//Method to Find Element at Specified Index
	public <T> T getElement(ArrayList<T> list, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index, size);
		return list.get(index);
	}

//Method to Check presence of Element
	public <T> boolean checkElement(ArrayList<T> list, Object Obj) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.contains(Obj);
	}
	
//Method to find Duplicates
	public <T> ArrayList<T> findDuplicates(ArrayList<T> list) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		ArrayList<T> duplicates = createAL() ;
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
	
//Method to create Sublist from an ArrayList
	public <T> ArrayList<T> getSubList(ArrayList<T> list,int index1, int index2) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index2, size);
		UtilsCheck.checkWithinRange(index1, index2);
		return createAL(list.subList(index1, index2));
	}
	
//Method to Remove Element at Specified Index
	public <T> void removeElement(ArrayList<T> list, int index) throws InvalidException
	{
		int size = UtilsSize.getSize(list);
		UtilsCheck.checkWithinRange(index, size);
		list.remove(index);
	}
	
//Method to Remove common Elements
	public <T> void removeAllElements(ArrayList<T> mainList, ArrayList<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(mainList);
		UtilsCheck.checkNull(list);
		mainList.removeAll(list);
	}
	
//Method to Retain common Elements
	public <T> void retainAllElements(ArrayList<T> mainList, ArrayList<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(mainList);
		UtilsCheck.checkNull(list);
		mainList.retainAll(list);
	}
	
//Method to clear all Elements
	public <T> void clearAllElements(ArrayList<T> list) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		list.clear();
	}
}