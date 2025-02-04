package com.basicprogramming.task;

public enum RainbowColour 
{
	VIOLET(1), INDIGO(2), BLUE(3), GREEN(4), YELLOW(5), ORANGE(6), RED(7);

	private final int colourCode;  

	RainbowColour(int colourCode) 
	{
		this.colourCode = colourCode;
	}

	public int getColourCode() 
	{
		return colourCode;
	}
}
