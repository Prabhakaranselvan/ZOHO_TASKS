package com.basicprogramming.inout;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PojoRunner 
{
	private static final Logger LOGGER = Logger.getLogger(PojoRunner.class.getName());
	static 
	{
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) 
            {
                return record.getMessage();
            } });
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);
    }
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
    {
		Class<?> pojoClass = Class.forName("com.utilshub.PojoClass");
        
        Constructor<?>[] allConstructors = pojoClass.getDeclaredConstructors();
        LOGGER.info("Constructors:\n");
        for (Constructor<?> constructor : allConstructors) 
        {
            LOGGER.info(constructor + "\n");
        }

        Field[] fields = pojoClass.getDeclaredFields();
        LOGGER.info("Fields:\n");
        for (Field field : fields) 
        {
            LOGGER.info(field + "\n");
        }

        Method[] methods = pojoClass.getDeclaredMethods();
        LOGGER.info("Methods:\n");
        for (Method method : methods) 
        {
            LOGGER.info(method + "\n");
        }
            
// 1. Get and Invoke the Default Constructor
        Constructor<?> defaultConstructor = pojoClass.getDeclaredConstructor();
        Object pojoInstance1 = defaultConstructor.newInstance();
        // pojoInstance1 = pojoClass.getDeclaredConstructor().newInstance();
        LOGGER.info(pojoInstance1+ "\n");
            
// 2. Get and Invoke the Overloaded Constructor
        Constructor<?> overloadedConstructor = pojoClass.getDeclaredConstructor(String.class, int.class);
        Object pojoInstance2 = overloadedConstructor.newInstance("Hello, Reflection!", 42);
        // pojoInstance2 = pojoClass.getDeclaredConstructor().newInstance("Hello, Reflection!", 42);
        LOGGER.info(pojoInstance2+ "\n");
            
// 3. Get and Invoke a Getter Method (getMessage)
        Method getMessageMethod = pojoClass.getMethod("getMessage");
        String message = (String)getMessageMethod.invoke(pojoInstance2);
        LOGGER.info(message + "\n");

// 4. Get and Invoke a Setter Method (setMessage)
        Method setMessageMethod = pojoClass.getMethod("setMessage", String.class);
        setMessageMethod.invoke(pojoInstance2, "Updated via Reflection!");
        LOGGER.info("Updated Pojo Instance: " + pojoInstance2 + "\n");
    }
}
 
