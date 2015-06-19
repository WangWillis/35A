class RomanNumeral
{
	public static RomanNumeral romanArray[] = 
	{
		new RomanNumeral("M"),
		new RomanNumeral("CM"),
		new RomanNumeral("D"),
		new RomanNumeral("CD"),
		new RomanNumeral("C"),
		new RomanNumeral("XC"),
		new RomanNumeral("L"),
		new RomanNumeral("XL"),
		new RomanNumeral("X"),
		new RomanNumeral("IX"),
		new RomanNumeral("V"),
		new RomanNumeral("IV"),
		new RomanNumeral("I")
	};
	private String romNumStr = "";
	private int value = 0;
	private void calcIntValue()
	{
		int digitValues[] = new int [romNumStr.length()];
		for(int i = 0; i < digitValues.length; i++)
		{
			char temp = romNumStr.charAt(i);
			if(temp == 'M')
			{
				digitValues[i] = 1000;
			}
			else if(temp == 'D')
			{
				digitValues[i] = 500;
			}
			else if(temp == 'C')
			{
				digitValues[i] = 100;
			}
			else if(temp == 'L')
			{
				digitValues[i] = 50;
			}
			else if(temp == 'X')
			{
				digitValues[i] = 10;
			}
			else if(temp == 'V')
			{
				digitValues[i] = 5;
			}
			else if(temp == 'I')
			{
				digitValues[i] = 1;
			}
			else
			{
				value = 0;
				romNumStr = "";
				return;
			}
		}
		for(int i = 0; i < digitValues.length-1; i++)
		{
			if(digitValues[i] >= digitValues[i+1])
			{
				value += digitValues[i];
			}
			else
			{
				value -= digitValues[i];
			}
		}
		value += digitValues[digitValues.length-1];
	}
	private void calcRomStrVal()
	{
		int val = value;
		StringBuilder romNumber = new StringBuilder(val);
		for(int i = 0; i < romanArray.length; i++)
		{
			while((val - romanArray[i].value) >= 0)
			{
				romNumber.append(romanArray[i].romNumStr);
				val -= romanArray[i].value;
			}
		}
		romNumStr = romNumber.toString();
		romNumStr.trim();
	}
	public void setRomNumStr(String romNum)
	{
		if(romNum != null)
		{
			romNumStr = (romNum.replaceAll("\\s+", "")).toUpperCase();
			calcIntValue();
		}
	}
	public void setValue(int val)
	{
		if(val > 0)
		{
			value = val;
			calcRomStrVal();
		}
	}
	public RomanNumeral(String romNum)
	{
		setRomNumStr(romNum);
	}
	public RomanNumeral(int num)
	{
		setValue(num);
	}
	public RomanNumeral()
	{
		romNumStr = "";
		value = 0;
	}
	public String getRomNumStr()
	{
		return romNumStr;
	}
	public int getValue()
	{
		return value;
	}
	public RomanNumeral addRomNum(RomanNumeral temp)
	{
		if(temp == null)
		{
			return new RomanNumeral(value);
		}
		return new RomanNumeral(value+temp.getValue());
	}
	public String toString()
	{
		return "RomanNumeral: " + romNumStr + " " + value;
	}
}