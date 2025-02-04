package com.basicprogramming.task;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import com.exception.InvalidException;
import com.utilshub.UtilsCheck;

public class BPDateTime 
{
//Method to get current ZonedDateTime for a given time zone
    public ZonedDateTime getCurrentZonedDateTime(ZoneId zoneId) throws InvalidException 
    {
    	UtilsCheck.checkNull(zoneId); 
        return ZonedDateTime.now(zoneId);
    }
    
//Method to get ZonedDateTime
    public ZonedDateTime getZonedDateTime(int year, int month, int dayOfMonth,int hour, int minute, int second, int nanoOfSecond, ZoneId zoneId) throws InvalidException 
    {
    	UtilsCheck.checkNull(zoneId); 
        return ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zoneId);
    }

//Method to get current Instant time
    public ZoneOffset getZoneOffset(ZonedDateTime dateTime) throws InvalidException 
    {
    	UtilsCheck.checkNull(dateTime);
        return dateTime.getOffset();
    }

//Method to get current Instant time
    public Instant getCurrentInstant() 
    {
        return Instant.now();
    }

//Method to get current time in milliseconds using System class
    public long nowMillis() 
    {
        return System.currentTimeMillis();
    }

//Method to get epoch milliseconds from an Instant
    public long toMillis(Instant instant) throws InvalidException 
    {
    	UtilsCheck.checkNull(instant);
        return instant.toEpochMilli();
    }

//Method to get default system ZoneId
    public ZoneId defaultZoneId() 
    {
        return ZoneId.systemDefault();
    }

//Method to get all available ZoneIds
    public Set<String> getAvailableZoneIds() 
    {
        return ZoneId.getAvailableZoneIds();
    }
    
//Method to get ZoneId for a given time zone
    public ZoneId zoneId(String zone) throws InvalidException 
    {
    	UtilsCheck.checkNull(zone); 
        return ZoneId.of(zone);
    }
    
//Return a DateTimeFormatter with a given pattern
    public DateTimeFormatter pattern(String format) throws InvalidException 
    {
    	UtilsCheck.checkNull(format); 
        return DateTimeFormatter.ofPattern(format);
    }
 
//Format a ZonedDateTime using a given formatter
    public String format(ZonedDateTime dateTime, DateTimeFormatter formatter) throws InvalidException 
    {
    	UtilsCheck.checkNull(dateTime);
    	UtilsCheck.checkNull(formatter);
        return dateTime.format(formatter);
    }
 
//Method to get Instant from epoch milliseconds
    public Instant getInstantEpochMilli(long epochMilli) throws InvalidException
    {
    	UtilsCheck.checkNull(epochMilli);
    	return Instant.ofEpochMilli(epochMilli);
    }

//Method to get Date and Time from Instant
    public ZonedDateTime getZonedDateTimeFomInstant (Instant instant, ZoneId zone) throws InvalidException
    {
    	UtilsCheck.checkNull(instant); 
    	UtilsCheck.checkNull(zone); 
    	return ZonedDateTime.ofInstant(instant, zone);
    }

//Method to get Day of the Week
    public DayOfWeek getWeekDay (ZonedDateTime dateTime) throws InvalidException
    {
    	UtilsCheck.checkNull(dateTime); 
    	return dateTime.getDayOfWeek();
    }

//Method to get Month Name
    public Month getMonth(ZonedDateTime dateTime) throws InvalidException
    {
    	UtilsCheck.checkNull(dateTime); 
    	return dateTime.getMonth();
    }
 
//Method to get Year
    public int getYear(ZonedDateTime dateTime) throws InvalidException
    {
    	UtilsCheck.checkNull(dateTime); 
    	return dateTime.getYear();
    }
    


    public LocalDateTime getCurrentDateTime() 
    {
        return LocalDateTime.now();
    }
    public String format(LocalDateTime dateTime, DateTimeFormatter formatter) throws InvalidException 
    {
    	UtilsCheck.checkNull(dateTime);
    	UtilsCheck.checkNull(formatter); 
    	return dateTime.format(formatter);
    }
  
    public LocalDateTime getLocalDateTimeFomInstant (Instant instant, ZoneId zone) throws InvalidException
    {
    	UtilsCheck.checkNull(instant); 
    	UtilsCheck.checkNull(zone); 
    	return LocalDateTime.ofInstant(instant, zone);
    }
    
    public Month getMonth(LocalDateTime dateTime) throws InvalidException
    {
    	UtilsCheck.checkNull(dateTime); 
    	return dateTime.getMonth();
    }
    
    public DayOfWeek getWeekDay (LocalDateTime dateTime) throws InvalidException
    {
    	UtilsCheck.checkNull(dateTime); 
    	return dateTime.getDayOfWeek();
    }
    
    public int getYear(LocalDateTime dateTime) throws InvalidException
    {
    	UtilsCheck.checkNull(dateTime); 
    	return dateTime.getYear();
    }
    
    
    
    
    
    
    

}
