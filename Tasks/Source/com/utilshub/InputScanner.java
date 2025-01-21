package com.utilshub;
import com.exception.InvalidException;

@FunctionalInterface
public interface InputScanner<T> 
{
    T scan() throws InvalidException;
}
