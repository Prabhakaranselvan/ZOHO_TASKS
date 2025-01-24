package com.arraylist.inout;
import java.util.List;
import java.util.Iterator;
import com.exception.InvalidException;
import com.utilshub.UtilsScan;
import com.utilshub.UtilsSize;
import com.utilshub.InputScanner;
import com.utilshub.Person;
import com.arraylist.task.ALTasks;

public class ALRunner
{
	ALTasks alTask = new ALTasks();
	
	private void exercise1() throws InvalidException
	{
		System.out.println("EXERCISE 1 : Create an ArrayList\n");
		
		List<?> list = alTask.createAL();
		alDetails(list);
	}
	
	private void exercise2() throws InvalidException
	{
		System.out.println("EXERCISE 2 : Create AL and Add Strings\n");
		
		getAL(String.class);
	}
	
	private void exercise3() throws InvalidException
	{
		System.out.println("EXERCISE 3 : Create AL and Add Integer\n");
		
		getAL(Integer.class);
	}
	
	private void exercise4() throws InvalidException 
	{
		System.out.println("EXERCISE 4 : Create AL and Add Custom Objects\n");

		System.out.print("No of Person Objects to add : ");
		int num = UtilsScan.getInteger();
		List<Person> list = alTask.createAL(num);
		
		addPersonObjToAL(list,num);
		alDetails(list);
	}
	
	private void exercise5() throws InvalidException 
	{
		System.out.println("EXERCISE 5 : Create AL and Add Strings, Integers & Custom Objects\n");

		System.out.print("No. of Strings to add: ");
		int num1 = UtilsScan.getInteger();
		System.out.print("No Of Integers to add : ");
		int num2 = UtilsScan.getInteger();
		System.out.print("No of Person Objects to add : ");
		int num3 = UtilsScan.getInteger();
		List<Object> list = alTask.createAL(num1+num2+num3);
		
		addStringsToAL(list,num1);
		addIntegersToAL(list,num2);
		addPersonObjToAL(list,num3);
		alDetails(list);
	}
	
	private void exercise6() throws InvalidException
	{
		System.out.println("EXERCISE 6 : Find Index for Given String\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.print("\nEnter the String To Find Its Index : ");
		String input = UtilsScan.getString();
		System.out.println("Index Of " + input + " : " + alTask.getIndex(strings, input));
	}
	
	private void exercise7() throws InvalidException
	{
		System.out.println("EXERCISE 7 : Iterator & For Loop Method To Print each Element\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.println("\nPrinting elements using iterator():");
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		
		System.out.println("Printing elements using for loop:");
		for (String str : strings) 
		{
			System.out.println(str);
		}
	}
	
	private void exercise8() throws InvalidException
	{
		System.out.println("EXERCISE 8 : Find String at Given Index\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.print("\nEnter Index To Find String: ");
		int input = UtilsScan.getInteger();
		System.out.println("String at Index " + input + " : " + alTask.getElement(strings, input));
	}
	
	private void exercise9() throws InvalidException
	{
		System.out.println("EXERCISE 9 : Find 1st & last Index Of Duplicate Strings\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.print("\nEnter The String To find its First and Last: ");
		String str = UtilsScan.getString();
		System.out.println("First Index Of " + str + " : " + alTask.getIndex(strings, str));
		System.out.println("Last Index Of " + str + " : " + alTask.getLastIndex(strings, str));
		
		/*List<String> duplicates = alTask.findDuplicates(strings);
		System.out.println("\nElements with Duplicates : " + duplicates);
		for (String str : duplicates)
		{
			System.out.println("First Index Of " + str + " : " + alTask.getIndex(strings, str));
			System.out.println("Last Index Of " + str + " : " + alTask.getLastIndex(strings, str));
		}*/
	}
	
	
	private void exercise10() throws InvalidException
	{
		System.out.println("EXERCISE 10 : Add Strings at specified Index\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.print("\nEnter the String To Add : ");
		String str = UtilsScan.getString();
		System.out.print("Enter Index : ");
		int index = UtilsScan.getInteger();
		alTask.addElement(strings, str, index);
		alDetails(strings);
	}
	
	private void exercise11() throws InvalidException
	{
		System.out.println("EXERCISE 11 : Create a SubList\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.print("\nEnter FromIndex : ");
		int index1 = UtilsScan.getInteger();
		System.out.print("Enter ToIndex : ");
		int index2 = UtilsScan.getInteger();
		
		List<String> subList = alTask.getSubList(strings,index1, index2);
		alDetails(subList);
	}
	
	private void exercise12() throws InvalidException
	{
		System.out.println("EXERCISE 12 : Merge Two ArrayLists Without Loop\n");
		
		System.out.println("ArrayList 1"); 
		List<String> strings1 = getAL(String.class);
		
		System.out.println("\nArrayList 2");
		List<String> strings2 = getAL(String.class);
		
		System.out.print("\nArrayList 3");
		List<String> strings3 = alTask.createAL(strings1);
		alTask.addAllElements(strings3,strings2);
		
		alDetails(strings3);
	}
	
	private void exercise13() throws InvalidException
	{
		System.out.println("EXERCISE 13 : Prepend One ArrayList to Another Without Loop\n");
		
		System.out.println("ArrayList 1"); 
		List<String> strings1 = getAL(String.class);
		
		System.out.println("\nArrayList 2");
		List<String> strings2 = getAL(String.class);
		
		System.out.print("\nArrayList 3");
		List<String> strings3 = alTask.createAL(strings1);
		alTask.addAllElementsAtIndex(strings3,strings2,0);
		
		alDetails(strings3);
	}
	
	private void exercise14() throws InvalidException
	{
		System.out.println("EXERCISE 14 : Remove an Element\n");
		
		List<Double> list = getAL(Double.class);
		
		System.out.print("\nEnter the Index To Remove Element : ");
		int index = UtilsScan.getInteger();
		alTask.removeElement(list, index);
		alDetails(list);
	}
	
	private void exercise15() throws InvalidException
	{
		System.out.println("EXERCISE 15 : Remove Commom Elements\n");
		
		System.out.println("ArrayList 1"); 
		List<String> strings1 = getAL(String.class);
		
		System.out.println("\nArrayList 2");
		List<String> strings2 = getAL(String.class);
		
		System.out.println("\nAfter Removing Common Elements");
		alTask.removeAllElements(strings1, strings2);
		alDetails(strings1);
	}
	
	private void exercise16() throws InvalidException
	{
		System.out.println("EXERCISE 16 : Retain Commom Elements\n");
		
		System.out.println("ArrayList 1"); 
		List<String> strings1 = getAL(String.class);
		
		System.out.println("\nArrayList 2");
		List<String> strings2 = getAL(String.class);
		
		System.out.println("\nAfter Retaining Common Elements");
		alTask.retainAllElements(strings1, strings2);
		alDetails(strings1);
	}
	
	private void exercise17() throws InvalidException
	{
		System.out.println("EXERCISE 17 : Clear ArrayList\n");
		
		List<Long> strings = getAL(Long.class);
		
		System.out.println("\nAfter Clearing All Elements");
		alTask.clearAllElements(strings);
		alDetails(strings);
		
	}
	
	private void exercise18() throws InvalidException
	{
		System.out.println("EXERCISE 18 : Check Element in ArrayList\n");
		
		List<String> strings = getAL(String.class);
		
		System.out.print("\nEnter the String To Check : ");
		String input = UtilsScan.getString();
		System.out.println(input + " present : " + alTask.checkElement(strings, input));
		
	}
	
	public <T> List<T> getAL(Class<T> type) throws InvalidException 
	{
		System.out.print("No Of Elements to add: ");
		int num = UtilsScan.getInteger();
		List<T> list = alTask.createAL(num);

		System.out.println("Enter " + type.getSimpleName() + " values");

		InputScanner<T> inputScanner = getInputScanner(type);

		for (int i = 1; i <= num; i++) 
		{
			System.out.print("Element " + i + ": ");
			T element = inputScanner.scan();
			alTask.addElement(list,element);
		}
		alDetails(list);
		return list;
	}
	
	public <T> InputScanner<T> getInputScanner(Class<T> type) throws InvalidException 
	{
        if (type == String.class) 
		{
            return () -> type.cast(UtilsScan.getString());
        } 
		else if (type == Integer.class) 
		{
            return () -> type.cast(UtilsScan.getInteger());
        } 
		else if (type == Double.class) 
		{
            return () -> type.cast(UtilsScan.getDouble());
        } 
		else if (type == Long.class) 
		{
            return () -> type.cast(UtilsScan.getLong());
        } 
		else 
		{
            throw new InvalidException("Unsupported type: " + type.getTypeName());
        }
    }
	
	private void addStringsToAL(List<? super String> list, int num) throws InvalidException
	{
		for (int i=1; i<=num; i++)
			{
				System.out.print("Enter String" + i + " : ");
				String input = UtilsScan.getString();
				alTask.addElement(list,input);
			}
	}
	
	private <T> void addIntegersToAL(List<? super Integer> list,int num) throws InvalidException
	{
		for (int i=1; i<=num; i++)
			{
				System.out.print("Enter Integer" + i + " : ");
				int input = UtilsScan.getInteger();
				alTask.addElement(list,input);
			}
	}
	
	private <T> void addPersonObjToAL(List<? super Person> list,int num) throws InvalidException
	{
		for (int i = 1; i <= num; i++) 
			{
				System.out.print("Enter Person"+ i +" Name : ");
				String name = UtilsScan.getString();
				Person person = new Person(name);
				alTask.addElement(list, person);
			}
	}
	
	private <T> void alDetails(List<T> list) throws InvalidException
	{
		System.out.println("ArrayList : " + list);
		System.out.println("Size of the ArrayList : " + UtilsSize.getSize(list));
	}
	
	public static void main(String[] abc) throws InvalidException
	{
		boolean isContinue = true;
		String exercise;
		ALRunner alRunner = new ALRunner();
		System.out.print("\nTASK : ARRAY_LIST\n\n1. Create an ArrayList\n2. Create AL and Add Strings\n3. Create AL and Add Integers\n4. Create AL and Add Custom Objects\n5. Create AL and Add Strings, Integers & Custom Objects\n6. Find Index\n7. Iterator & For Loop Method To Print each Element\n8. Find String at Given Index\n9. Find 1st & last Index Of Duplicate Strings\n10. Add Strings at specified Index\n11. Create a SubList\n12. Merge Two ArrayLists Without Loop\n13. Merge Two ArrayLists Without Loop\n14. Remove an Element\n15. Remove Commom Elements\n16. Retain Commom Elements\n17. Clear ArrayList\n18. Check Element in ArrayList\nEnter 0 to Exit\n");
		while(isContinue)
		{
			try
			{
				System.out.print("\nEnter the Excercise to carry out : ");
				exercise = UtilsScan.getString();
				switch (exercise)
				{	
				case "1":
					alRunner.exercise1();
					break;
					
				case "2":
					alRunner.exercise2();
					break;
				
				case "3":
					alRunner.exercise3();
					break;
					
				case "4":
					alRunner.exercise4();
					break;
				
				case "5":
					alRunner.exercise5();
					break;
				
				case "6":
					alRunner.exercise6();
					break;
				
				case "7":
					alRunner.exercise7();
					break;
					
				case "8":
					alRunner.exercise8();
					break;
					
				case "9":
					alRunner.exercise9();
					break;
				
				case "10":
					alRunner.exercise10();
					break;
				
				case "11":
					alRunner.exercise11();
					break;
					
				case "12":
					alRunner.exercise12();
					break;
				
				case "13":
					alRunner.exercise13();
					break;
				
				case "14":
					alRunner.exercise14();
					break;
					
				case "15":
					alRunner.exercise15();
					break;
					
				case "16":
					alRunner.exercise16();
					break;
				
				case "17":
					alRunner.exercise17();
					break;
					
				case "18":
					alRunner.exercise18();
					break;
				
				case "0":
					isContinue = false;
					break;
				
			    /*case"t":
					List<String> list1 = new ArrayList<>(Arrays.asList("Hello", "World", "Java",null));
					String str = null;
					List<String> list2 = null;
					int num = list1.indexOf(str);
					System.out.print(list1.contains(str));
					list1.removeAll(list2);
					break; */
					
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

/*	@SuppressWarnings("unchecked")
	private <T> List<T> getAL(Class<T> type) throws InvalidException
	{
		System.out.print("No Of Elements to add : ");
		int num = UtilsScan.getInteger();
		List<T> list = alTask.createAL(num);
		System.out.println("Enter " + type.getSimpleName() + " values"); 
		
		for (int i=1; i<=num; i++)
			{
				System.out.print("Element" + i + " : ");
				T element;
			try
			{
				if (type == String.class)
				{
					element = type.cast(UtilsScan.getString());
				} 
				else if (type == Integer.class) 
				{
					element = type.cast(UtilsScan.getInteger());
				}
				else if (type == Double.class) 
				{
					element = type.cast(UtilsScan.getDouble());
				}
				else if (type == Long.class) 
				{
					element = type.cast(UtilsScan.getLong());
				}
				else 
				{
					throw new InvalidException("Unsupported type: " + type.getTypeName());
				}
				alTask.addElement(list,element);
			}	 
			catch (ClassCastException e) 
			{
				throw new InvalidException("Input type does not match the specified ArrayList type", e);
			}
			}
		alDetails(list);
		return list;
	} 
*/
