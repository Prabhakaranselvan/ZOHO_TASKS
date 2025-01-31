package com.basicprogramming.task;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BPDateTime 
{
// Method to get currentTime with Date, seconds, etc.
    public LocalDateTime getCurrentDateTime() 
    {
        return LocalDateTime.now();
    }
    
// Method to get current Instant time
    public Instant getCurrentInstant() 
    {
        return Instant.now();
    }

// Method to get current time in milliseconds using System class
    public long nowMillis() 
    {
        return System.currentTimeMillis();
    }

// Method to get epoch milliseconds from an Instant
    public long toMillis(Instant instant) 
    {
        return instant.toEpochMilli();
    }
    
// Method to get ZoneId for a given time zone
    public ZoneId zoneId(String zone) 
    {
        return ZoneId.of(zone);
    }

// Method to get current ZonedDateTime for a given time zone
    public ZonedDateTime getCurrentZonedDateTime(ZoneId zoneId) 
    {
        return ZonedDateTime.now(zoneId);
    }

// Return a DateTimeFormatter with a given pattern
    public DateTimeFormatter pattern(String format) 
    {
        return DateTimeFormatter.ofPattern(format);
    }
    
 // Format a LocalDateTime using a given formatter
    public String format(LocalDateTime dateTime, DateTimeFormatter formatter) 
    {
        return dateTime.format(formatter);
    }

// Format a ZonedDateTime using a given formatter
    public String format(ZonedDateTime dateTime, DateTimeFormatter formatter) 
    {
        return dateTime.format(formatter);
    }
 
//  Method to get Instant from epoch milliseconds
    public Instant getInstantEpochMilli(long epochMilli)
    {
    	return Instant.ofEpochMilli(epochMilli);
    }

//  Method to get Date and Time from Instant
    public LocalDateTime getDateTimeFomInstant (Instant instant, ZoneId zone)
    {
    	return LocalDateTime.ofInstant(instant, zone);
    }

//  Method to get Day of the Week
    public DayOfWeek getWeekDay (LocalDateTime dateTime)
    {
    	return dateTime.getDayOfWeek();
    }

//  Method to get Month Name
    public Month getMonth(LocalDateTime dateTime)
    {
    	return dateTime.getMonth();
    }
 
//  //  Method to get Year
    public int getYear(LocalDateTime dateTime)
    {
    	return dateTime.getYear();
    }

}
