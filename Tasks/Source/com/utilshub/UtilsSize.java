package com.utilshub;
import java.util.List;
import com.exception.InvalidException;

public class UtilsSize
{
//Methods To Get Length
   	public static int getLength(CharSequence cs) throws InvalidException
    {
		UtilsCheck.checkNull(cs);
		return cs.length();
    }
	
	public static int getLength(Object[] objectArray) throws InvalidException
    {
		UtilsCheck.checkNull(objectArray);
		return objectArray.length;
    }
	
	public static int getSize(List<?> list) throws InvalidException
	{
		UtilsCheck.checkNull(list);
		return list.size();
	}
}