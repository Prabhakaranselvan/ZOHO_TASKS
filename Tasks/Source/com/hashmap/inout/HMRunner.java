package com.hashmap.inout;
import java.util.Map;
import java.util.function.BiFunction;
import com.exception.InvalidException;
import com.utilshub.UtilsScan;
import com.utilshub.UtilsSize;
import com.utilshub.InputScanner;
import com.utilshub.Person;
import com.hashmap.task.HMTasks;

public class HMRunner
{
	HMTasks hmTask = new HMTasks();
	
	private void exercise1() throws InvalidException 
	{
		System.out.println("EXERCISE 1: Create an empty HashMap\n");
		Map<Object, Object> map = hmTask.createHM();
		hmDetails(map);
		
	}

	private void exercise2() throws InvalidException 
	{
		System.out.println("EXERCISE 2: Add 3 pairs of String keys and String values\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
	}

	private void exercise3() throws InvalidException 
	{
		System.out.println("EXERCISE 3: Add 3 pairs of Integer keys and Integer values\n");
		Map<Integer, Integer> map = getHM(Integer.class);
		hmDetails(map);
	}

	private void exercise4() throws InvalidException 
	{
		System.out.println("EXERCISE 4: Add 3 pairs of String keys and Integer values\n");
		Map<String, Integer> map = getHM(String.class, Integer.class);
		hmDetails(map);
	}

	private void exercise5() throws InvalidException 
	{
		System.out.println("EXERCISE 5: Add 3 pairs of String keys and custom object values\n");
		System.out.print("No of Key-Value pairs to Add: ");
		int num = UtilsScan.getInteger();
		Map<String, Person> map = hmTask.createHM(num);
		for (int i = 1; i <= num; i++) 
			{
				System.out.print("Enter key" + i + " : ");
				String key = UtilsScan.getString();
				System.out.print("Enter Person"+ i +" Name : ");
				String name = UtilsScan.getString();
				Person person = new Person(name);
				hmTask.addKeyValuePair(map, key, person);
			}
		hmDetails(map);
	}

	private void exercise6() throws InvalidException 
	{
		System.out.println("EXERCISE 6: Add 3 keys with one having a null value\n");
		Map<String, String> map = getHM(String.class);
		hmTask.addKeyValuePair(map, "Key", null);
		hmDetails(map);
	}

	private void exercise7() throws InvalidException 
	{
		System.out.println("EXERCISE 7: Add a null key with a non-null value\n");
		Map<String, String> map = getHM(String.class);
		hmTask.addKeyValuePair(map, null, "Value");
		hmDetails(map);
	}

	private void exercise8() throws InvalidException 
	{
		System.out.println("EXERCISE 8: Check if a key exists in a HashMap\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter key to check for Existance: ");
		String input = UtilsScan.getString();
		System.out.print(input + " Present: " + hmTask.checkKey(map,input));
	}

	private void exercise9() throws InvalidException 
	{
		System.out.println("EXERCISE 9: Check if a value exists in a HashMap\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter value to check for Existance: ");
		String input = UtilsScan.getString();
		System.out.print(input + " Present: " + hmTask.checkValue(map,input));
	}

	private void exercise10() throws InvalidException 
	{
		System.out.println("EXERCISE 10: Update values for all keys\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		
		BiFunction<String, String, String> updateFunction = (key, oldValue) -> {
			System.out.println("Current Entry: Key = " + key + ", Value = " + oldValue);
			System.out.print("Enter new value: ");
			return UtilsScan.getString();
		};
		hmTask.replaceAllValues(map, updateFunction);
		System.out.print("Updated Map: ");
		hmDetails(map);
	}

	private void exercise11() throws InvalidException 
	{
		System.out.println("EXERCISE 11: Get value of an existing key\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter the key to retrieve value: ");
        String key = UtilsScan.getString();
        String value = hmTask.getValue(map, key);
        System.out.println("Value for the key '" + key + "': " + value);
	}

	private void exercise12() throws InvalidException 
	{
		System.out.println("EXERCISE 12: Get value of a non-existing key\n");
		Map<Integer, Integer> map = getHM(Integer.class);
		hmDetails(map);
		System.out.print("Enter the key to retrieve value: ");
        int key = UtilsScan.getInteger();
        Integer value = hmTask.getValue(map, key);
        System.out.println("Value for the key '" + key + "': " + value);
		
	}

	private void exercise13() throws InvalidException 
	{
		System.out.println("EXERCISE 13: Return a default value for a non-existing key\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter the key: ");
        String key = UtilsScan.getString();
        System.out.print("Enter the default value: ");
        String defaultValue = UtilsScan.getString();
        String value = hmTask.getOrDefault(map, key, defaultValue);
        System.out.println("Value for the key '" + key + "': " + value);
	}

	private void exercise14() throws InvalidException 
	{
		System.out.println("EXERCISE 14: Remove an existing key\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter the key to remove: ");
        String key = UtilsScan.getString();
		if (!hmTask.checkKey(map, key)) 
		{
            System.out.println("Given Key does not exist");
        }
		else
		{
			hmTask.removeKey(map, key);
			System.out.println("Key '" + key + "' removed.");
			hmDetails(map);
		}
	}

	private void exercise15() throws InvalidException 
	{
		System.out.println("EXERCISE 15: Remove a key only if its value matches\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter the key to remove: ");
        String key = UtilsScan.getString();
        System.out.print("Enter the value to match: ");
        String value = UtilsScan.getString();
        boolean isRemoved = hmTask.removeKeyIfValueMatches(map, key, value);
        System.out.println(isRemoved ? "Key '" + key + "' with matching value removed." : "Key '" + key + "' not removed. Either it does not exist or the value does not match.");
        hmDetails(map);
	}

	private void exercise16() throws InvalidException 
	{
		System.out.println("EXERCISE 16: Replace the value of an existing key\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter the key to replace the value: ");
		String key = UtilsScan.getString();
		if (!hmTask.checkKey(map, key)) 
		{
			System.out.println("Given Key does not exist");
        }
		else
		{
			System.out.print("Enter the new value: ");
			String newValue = UtilsScan.getString();
			hmTask.replaceValue(map, key, newValue);
			System.out.println("Value for key '" + key + "' replaced.");
			hmDetails(map);
		}
	}

	private void exercise17() throws InvalidException 
	{
		System.out.println("EXERCISE 17: Replace value only if it matches existing value\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.print("Enter the key to replace the value: ");
		String key = UtilsScan.getString();
		System.out.print("Enter the current value to match: ");
		String oldValue = UtilsScan.getString();
		System.out.print("Enter the new value: ");
		String newValue = UtilsScan.getString();
		boolean replaced = hmTask.replaceValueIfMatches(map, key, oldValue, newValue);
		System.out.println(replaced ? "Value for key '" + key + "' replaced." : "Replacement failed. Either the key does not exist or the value does not match.");
		hmDetails(map);
	}

	private void exercise18() throws InvalidException 
	{
		System.out.println("EXERCISE 18: Transfer all entries to another HashMap\n");
		Map<String, String> sourceMap = getHM(String.class);
		hmDetails(sourceMap);
		Map<String, String> targetMap = getHM(String.class);
		hmDetails(targetMap);
		hmTask.transferEntries(sourceMap, targetMap);
		System.out.println("All entries transferred from source to target.");
		System.out.println("Source HashMap:");
		hmDetails(sourceMap);
		System.out.println("Target HashMap:");
		hmDetails(targetMap);
	}

	private void exercise19() throws InvalidException 
	{
		System.out.println("EXERCISE 19: Iterate and print all keys and values\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		System.out.println("HashMap contents:");
		Iterable<Map.Entry<String, String>> entries = hmTask.getEntries(map);
		for (Map.Entry<String, String> entry : entries) 
		{
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

	private void exercise20() throws InvalidException 
	{
		System.out.println("EXERCISE 20: Remove all entries from a HashMap\n");
		Map<String, String> map = getHM(String.class);
		hmDetails(map);
		hmTask.clearMap(map);
		System.out.println("All entries removed from the HashMap.");
		hmDetails(map);
	}
	
	public <T> Map<T, T> getHM(Class<T> type) throws InvalidException 
	{
		System.out.print("No of Key-Value pairs to Add: ");
		int num = UtilsScan.getInteger();
		Map<T, T> map = hmTask.createHM();

		System.out.println("Enter " + type.getSimpleName() + " for Keys and Values");

		InputScanner<T> inputScanner = UtilsScan.getInputScanner(type);

		for (int i = 1; i <= num; i++) 
		{
			System.out.print("Key " + i + ": ");
			T key = inputScanner.scan();
			System.out.print("Value " + i + ": ");
			T value = inputScanner.scan();
			hmTask.addKeyValuePair(map, key, value);
		}
		return map;
	}
	public <K, V> Map<K, V> getHM(Class<K> keyType, Class<V> valueType) throws InvalidException 
	{
		System.out.print("No of Key-Value pairs to Add: ");
		int num = UtilsScan.getInteger();
		Map<K, V> map = hmTask.createHM(num);

		System.out.println("Enter " + keyType.getSimpleName() + " for Keys");
		System.out.println("Enter " + valueType.getSimpleName() + " for Values");
		InputScanner<K> keyScanner = UtilsScan.getInputScanner(keyType);
		InputScanner<V> valueScanner = UtilsScan.getInputScanner(valueType);

		for (int i = 1; i <= num; i++) 
		{
			System.out.print("Key " + i + ": ");
			K key = keyScanner.scan();
			System.out.print("Value " + i + ": ");
			V value = valueScanner.scan();
			hmTask.addKeyValuePair(map, key, value);
		}
		return map;
	}
	
	private <K, V> void hmDetails(Map<K, V> map) throws InvalidException
	{
		System.out.println("HashMap: " + map);
        System.out.println("Size: " + UtilsSize.getSize(map));
	}
	
	public static void main(String[] abc) throws InvalidException
	{
		boolean isContinue = true;
		String exercise;
		HMRunner hmRunner = new HMRunner();
		System.out.print("\nTASK : HASHMAP\n\n1. Create an empty HashMap\n2. Add 3 pairs of String keys and String values\n3. Add 3 pairs of Integer keys and Integer values\n4. Add 3 pairs of String keys and Integer values\n5. Add 3 pairs of String keys and custom object values\n6. Add 3 keys with one having a null value\n7. Add a null key with a non-null value\n8. Check if a key exists in a HashMap\n9. Check if a value exists in a HashMap\n10. Update values for all keys\n11. Get value of an existing key\n12. Get value of a non-existing key\n13. Return a default value for a non-existing key\n14. Remove an existing key\n15. Remove a key only if its value matches\n16. Replace the value of an existing key\n17. Replace value only if it matches existing value\n18. Transfer all entries to another HashMap\n19. Iterate and print all keys and values\n20. Remove all entries from a HashMap\nEnter 0 to Exit\n");
		while(isContinue)
		{
			try
			{
				System.out.print("\nEnter the Excercise to carry out : ");
				exercise = UtilsScan.getString();
				switch (exercise)
				{	
				case "1":
					hmRunner.exercise1();
					break;
					
				case "2":
					hmRunner.exercise2();
					break;
				
				case "3":
					hmRunner.exercise3();
					break;
					
				case "4":
					hmRunner.exercise4();
					break;
				
				case "5":
					hmRunner.exercise5();
					break;
				
				case "6":
					hmRunner.exercise6();
					break;
				
				case "7":
					hmRunner.exercise7();
					break;
					
				case "8":
					hmRunner.exercise8();
					break;
					
				case "9":
					hmRunner.exercise9();
					break;
				
				case "10":
					hmRunner.exercise10();
					break;
				
				case "11":
					hmRunner.exercise11();
					break;
					
				case "12":
					hmRunner.exercise12();
					break;
				
				case "13":
					hmRunner.exercise13();
					break;
				
				case "14":
					hmRunner.exercise14();
					break;
					
				case "15":
					hmRunner.exercise15();
					break;
					
				case "16":
					hmRunner.exercise16();
					break;
				
				case "17":
					hmRunner.exercise17();
					break;
					
				case "18":
					hmRunner.exercise18();
					break;
					
				case "19":
					hmRunner.exercise19();
					break;
					
				case "20":
					hmRunner.exercise20();
					break;
				
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
	