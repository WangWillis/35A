/****************************************************
Program Name: MathExpressions 2
Programer: Willis Wang
Date: 06/22/15
Compiler: JavaC JDK 8
Discription: Recreate Homework 5 using updated
knowledge
****************************************************/
import java.util.*;
import java.io.*;
public class Homework7
{
	public static MathExpression makeExpressionNEW(StringTokenizer num)
	{
		MathExpression left, right;
		if(num.hasMoreTokens())
		{
			String ele = num.nextToken();
			if(ele.equals("+") || ele.equals("-") || ele.equals("*") || ele.equals("/"))
			{
				left = makeExpressionNEW(num);
				right = makeExpressionNEW(num);
				if(left != null && right != null)
				{
					if(ele.equals("+"))
					{
						return new AddExpression(left, right);
					}
					else if(ele.equals("-"))
					{
						return new SubExpression(left, right);
					}
					else if(ele.equals("*"))
					{
						return new MultExpression(left, right);
					}
					else
					{
						return new DivExpression(left, right);
					}
				}
				else
				{
					return null;
				}
			}
			else
			{
				try
				{
					return new MathValue(Double.parseDouble(ele));
				}
				catch(NumberFormatException exp)
				{
					return null;
				}
			}
		}
		else
		{
			return null;
		}
	}
	public static MathExpression makeExpression(StringTokenizer num)
	{
		MathExpression left, right;
		if(num.hasMoreTokens())
		{
			String ele = num.nextToken();
			if(ele.equals("+") || ele.equals("-") || ele.equals("*") || ele.equals("/"))
			{
				left = makeExpressionNEW(num);
				right = makeExpressionNEW(num);
				if(num.hasMoreTokens())
				{
					return null;
				}
				if(left != null && right != null)
				{
					if(ele.equals("+"))
					{
						return new AddExpression(left, right);
					}
					else if(ele.equals("-"))
					{
						return new SubExpression(left, right);
					}
					else if(ele.equals("*"))
					{
						return new MultExpression(left, right);
					}
					else
					{
						return new DivExpression(left, right);
					}
				}
				else
				{
					return null;
				}
			}
			else
			{
				if(num.hasMoreTokens())
				{
					return null;
				}
				try
				{
					return new MathValue(Double.parseDouble(ele));
				}
				catch(NumberFormatException exp)
				{
					return null;
				}
			}
		}
		else
		{
			return null;
		}
	}
	public static TreeMap<String, MathExpression> getMap()
	{
		TreeMap<String, MathExpression> temp = new TreeMap(new Comp());
		try
		{
			Scanner read = new Scanner(new File("HW7-InputFile.txt"));
			while(read.hasNextLine())
			{
				StringTokenizer exp = new StringTokenizer(read.nextLine());
				MathExpression mETemp = makeExpression(exp);
				if(mETemp != null)
				{
					temp.put(mETemp.toString(), mETemp);
				}
				else
				{
					temp.put("(INVALID EXPRESSION)", null);
				}
			}
			read.close();
		}
		catch(FileNotFoundException exp)
		{
			System.err.println(exp);
		}
		return temp;
	}
	public static Iterator getIterator(TreeMap<String, MathExpression> temp)
	{
		Set key = temp.keySet();
		return key.iterator();
	}
	public static int count(TreeMap<String, MathExpression> temp)
	{
		int count = 0;
		for(Iterator i = getIterator(temp); i.hasNext();)
		{
			MathExpression mETemp = temp.get(i.next());
			if(mETemp instanceof MathBinaryExpression)
			{
				MathBinaryExpression ex = (MathBinaryExpression)mETemp;
				if((ex.getLeft() instanceof MathValue) && (ex.getRight() instanceof MathValue))
				{
					count++;
				}
			}
		}
		return count;
	}
	public static void display(TreeMap<String, MathExpression> temp)
	{
		for(Iterator i = getIterator(temp); i.hasNext();)
		{
			String exp = (String)i.next();
			System.out.print(exp);
			if(temp.get(exp) != null)
			{
				System.out.print(" = " + temp.get(exp).evaluate());
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		TreeMap<String, MathExpression> expressions = getMap();
		display(expressions);
		System.out.println("Simple Expressions: " + count(expressions));
	}
}

/*
Test 0

((25.0 / 5.0) - (3.0 * 3.0)) = -4.0
((5.0 + 2.5) * 3.0) = 22.5
((9.8 - 3.0) * (2.0 + 1.0)) = 20.400000000000002
(100.0 / 20.0) = 5.0
(3.5 / 0.0) = Infinity
(4.0 + (30.0 / 2.0)) = 19.0
(5.0 * -7.0) = -35.0
(INVALID EXPRESSION)
54.32 = 54.32
Simple Expressions: 3

*/

/*
Test 1

((78.0 - 901.0) * (234.0 + 56.0)) = -238670.0
(123.456 - 7.8) = 115.656
(3.0 + 2.0) = 5.0
(9.8 / (12.3 + 7.6)) = 0.492462311557789
1928.3746 = 1928.3746
Simple Expressions: 2

*/

/*
Test 2

((10.0 - 3.0) * (500.0 + 20.0)) = 3640.0
((55.0 * 6.0) - 77.0) = 253.0
(33.0 / 444.0) = 0.07432432432432433
(8888.0 + (99.0 / 33.0)) = 8891.0
(INVALID EXPRESSION)
11111.0 = 11111.0
Simple Expressions: 1

*/