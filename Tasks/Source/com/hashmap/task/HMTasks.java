package com.hashmap.task;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;
import com.exception.InvalidException;
import com.utilshub.UtilsCheck;
import com.utilshub.UtilsSize;

public class HMTasks
{
// 1. Default constructor
    public <K, V> Map<K, V> createHM() 
	{
        return new HashMap<>();
    }

// 2. Constructor with initial capacity
    public <K, V> Map<K, V> createHM(int initialCapacity) 
	{
        return new HashMap<>(initialCapacity);
    }

// 3. Constructor with initial capacity and load factor
    public <K, V> Map<K, V> createHM(int initialCapacity, float loadFactor) 
	{
        return new HashMap<>(initialCapacity, loadFactor);
    }

// 4. Constructor with another Map
    public <K, V> Map<K, V> createHM(Map<? extends K, ? extends V> existingMap) throws InvalidException
	{
		UtilsCheck.checkNull(existingMap);
        return new HashMap<>(existingMap);
    }

// Method To add Keys and Values	
	public <K, V> void addKeyValuePair(Map<K, V> map, K key, V value) throws InvalidException
	{
		UtilsCheck.checkNull(map);
        map.put(key, value);
    }
	
//Method to Check if a key exists
	public <K, V> boolean checkKey(Map<K, V> map, Object key) throws InvalidException
	{
		UtilsCheck.checkNull(map);
        return map.containsKey(key);
    }
	
//Method to Check if a value exists
	public <K, V> boolean checkValue(Map<K, V> map, Object value) throws InvalidException
	{
		UtilsCheck.checkNull(map);
        return map.containsValue(value);
    }
	
// Method to Replace All Values in a Map Based on a Function
public <K, V> void replaceAllValues(Map<K, V> map, BiFunction<? super K, ? super V, ? extends V> function) throws InvalidException 
{
    UtilsCheck.checkNull(map);
	UtilsCheck.checkNull(function);
    map.replaceAll(function);
}

// Method to get the value for an existing key
    public <K, V> V getValue(Map<K, V> map, K key) throws InvalidException 
	{
        UtilsCheck.checkNull(map);
        return map.get(key);
    }

// Method to get the value for a non-existing key with a default value
    public <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) throws InvalidException 
	{
        UtilsCheck.checkNull(map);
        return map.getOrDefault(key, defaultValue);
    }

// Method to remove an existing key
    public <K, V> void removeKey(Map<K, V> map, K key) throws InvalidException 
	{
        UtilsCheck.checkNull(map);
        map.remove(key);
    }

// Method to remove a key only if its value matches
    public <K, V> boolean removeKeyIfValueMatches(Map<K, V> map, K key, V value) throws InvalidException 
	{
        UtilsCheck.checkNull(map);
        return map.remove(key, value);
    }
	
// Method to replace the value of an existing key
	public <K, V> void replaceValue(Map<K, V> map, K key, V newValue) throws InvalidException 
	{
		UtilsCheck.checkNull(map);
		map.replace(key, newValue);
	}

// Method to replace the value of an existing key only if its value matches
	public <K, V> boolean replaceValueIfMatches(Map<K, V> map, K key, V oldValue, V newValue) throws InvalidException 
	{
		UtilsCheck.checkNull(map);
		return map.replace(key, oldValue, newValue);
	}

// Method to transfer all entries from one HashMap to another
	public <K, V> void transferEntries(Map<K, V> sourceMap, Map<K, V> targetMap) throws InvalidException 
	{
		UtilsCheck.checkNull(sourceMap);
		UtilsCheck.checkNull(targetMap);
		targetMap.putAll(sourceMap);
	}

// Method to return all entries in the map as a set
	public <K, V> Iterable<Map.Entry<K, V>> getEntries(Map<K, V> map) throws InvalidException 	
	{
		UtilsCheck.checkNull(map);
		return map.entrySet();
	}

// Method to clear all entries in a HashMap
	public <K, V> void clearMap(Map<K, V> map) throws InvalidException 
	{
		UtilsCheck.checkNull(map);
		map.clear();
	}

}
