class RomNumExp extends RuntimeException
{
	public RomNumExp(String exp)
	{
		super(exp);
	}
}
class RomanNumeral implements Comparable<RomanNumeral>
{
	private static RomanNumeral romanArray[] = 
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
	private boolean calcIntValue()
	{
		if(romNumStr.equals(""))
		{
			return false;
		}
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
				return false;
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
		return true;
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
	public void setRomNumStr(String romNum) throws RomNumExp
	{
		if(romNum == null || romNum.length() <= 0)
		{
			throw new RomNumExp("Invalid Roman Numeral!!!");
		}
		else
		{
			romNumStr = (romNum.replaceAll("\\s+", "")).toUpperCase();
			if(!calcIntValue())
			{
				throw new RomNumExp("Invalid Roman Numeral!!!");
			}
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
	public RomanNumeral(String romNum) throws RomNumExp
	{
		if(romNum == null || romNum.length() <= 0)
		{
			throw new RomNumExp("Invalid Roman Numeral!!!");
		}
		else
		{	
			setRomNumStr(romNum);
		}
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
	public int compareTo(RomanNumeral romNum2)
	{
		if(value < romNum2.value)
		{
			return -1;
		}
		else if(value > romNum2.value)
		{
			return 1;
		}
		else
		{
			return romNumStr.compareTo(romNum2.getRomNumStr());
		}
	}5
}