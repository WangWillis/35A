import java.util.*;
public class Homework5
{
	static Scanner in = new Scanner(System.in);
	/*
	public static MathExpression [] getTestMathExpressions()
	{
		MathExpression [] mathExpArray = new MathExpression[] 
		{
			new SubExpression(new MathValue(123.456), new MathValue(7.8)),
			new DivExpression( new MathValue(9.8), new AddExpression(new MathValue(12.3), new MathValue(7.6))),
			new MathValue(1928.3746),
			new AddExpression(new MathValue(3.0), new MathValue(2.0)),
			new MultExpression(new SubExpression(new MathValue(78.), new MathValue(901.)), new AddExpression(new MathValue(234.), new MathValue(56.)))
		};
		return mathExpArray;
	}
	*/
	//Helper Function Starting function is on line 63
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
	//first call only (Line 18 Other calls) tests for invalids
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
	/*
	non prefix notation evaluation doesent test for invaid expressions though
	reverse string/right and left before use though if want to evaluate from left to right
	public static MathExpression makeExpression(StringTokenizer num)
	{
		MathExpression left, right;
		String ele = num.nextToken();
		left = new MathValue(Double.parseDouble(ele));
		if(num.hasMoreTokens())
		{
			ele = num.nextToken();
			right = makeExpression(num);
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
			else if(ele.equals("/"))
			{
				return new DivExpression(left, right);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return left;
		}
	}
	*/
	public static MathExpression [] getMathExpressions()
	{
		MathExpression [] temp;
		System.out.println("How many expressions do you want?");
		int ele = in.nextInt();
		in.nextLine();
		if(ele <= 0)
		{
			ele = 1;
			temp = new MathExpression[1];
		}
		else
		{
			temp = new MathExpression[ele];
		}
		for(int i = 0; i < ele; i++)
		{
			System.out.println("Enter your expression seperated by a space and writen in prefix notation!");
			String exp = in.nextLine();
			StringTokenizer num = new StringTokenizer(exp);
		 	num = new StringTokenizer(exp);
		 	temp[i] = makeExpression(num);
		}
		return temp;
	}
	public static int countSimpExp(MathExpression exp[])
	{
		int count = 0;
		for(int i = 0; i < exp.length; i++)
		{
			if(exp[i] instanceof MathBinaryExpression)
			{
				MathBinaryExpression ex = (MathBinaryExpression) exp[i];
				if((ex.getLeft() instanceof MathValue) && (ex.getRight() instanceof MathValue))
				{
					count++;
				}
			}
		}
		return count;
	}
	public static void display(MathExpression exp[])
	{
		System.out.println("\nEquations:\n");
		for(int i = 0; i < exp.length; i++)
		{
			if(exp[i] != null)
			{
				System.out.println(exp[i] + " = " + exp[i].evaluate());
			}
			else
			{
				System.out.println("INVALID");
			}
		}
		System.out.println("Simple Expressions: " + countSimpExp(exp));
	}
	public static void main(String args[])
	{
		MathExpression [] exp = getMathExpressions();
		//MathExpression [] exp = getTestMathExpressions();
		display(exp);

	}
}
/*
Sample Input Values tested values
Equations:

(123.456 - 7.8) = 115.656
(9.8 / (12.3 + 7.6)) = 0.492462311557789
1928.3746 = 1928.3746
(3.0 + 2.0) = 5.0
((78.0 - 901.0) * (234.0 + 56.0)) = -238670.0
Simple Expressions: 2
*/ 

/*
Test 1

How many expressions do you want?
5
Enter your expression seperated by a space and writen in prefix notation!
- 123.456 7.8
Enter your expression seperated by a space and writen in prefix notation!
/ 9.8 + 12.3 7.6
Enter your expression seperated by a space and writen in prefix notation!
1928.3746
Enter your expression seperated by a space and writen in prefix notation!
+ -3 -2
Enter your expression seperated by a space and writen in prefix notation!
* - 78 901 + 234 56

Equations:

(123.456 - 7.8) = 115.656
(9.8 / (12.3 + 7.6)) = 0.492462311557789
1928.3746 = 1928.3746
(-3.0 + -2.0) = -5.0
((78.0 - 901.0) * (234.0 + 56.0)) = -238670.0
Simple Expressions: 2
*/

/*
Test 2

How many expressions do you want?
7
Enter your expression seperated by a space and writen in prefix notation!
-11111
Enter your expression seperated by a space and writen in prefix notation!
/ 33    444
Enter your expression seperated by a space and writen in prefix notation!
* 9 + 3
Enter your expression seperated by a space and writen in prefix notation!
- * 55     6     77
Enter your expression seperated by a space and writen in prefix notation!
/ 1010
Enter your expression seperated by a space and writen in prefix notation!
* - 10 3 + 500 20
Enter your expression seperated by a space and writen in prefix notation!
+ 8888 / 99 33

Equations:

-11111.0 = -11111.0
(33.0 / 444.0) = 0.07432432432432433
INVALID
((55.0 * 6.0) - 77.0) = 253.0
INVALID
((10.0 - 3.0) * (500.0 + 20.0)) = 3640.0
(8888.0 + (99.0 / 33.0)) = 8891.0
Simple Expressions: 1
*/

/*
Test 3

How many expressions do you want?
9
Enter your expression seperated by a space and writen in prefix notation!
* 5.0 -7.0
Enter your expression seperated by a space and writen in prefix notation!
+ 4.0 / 30. 2
Enter your expression seperated by a space and writen in prefix notation!
- / 25. 5. * 3. 3. 54.32
Enter your expression seperated by a space and writen in prefix notation!
/ 3.5 0.
Enter your expression seperated by a space and writen in prefix notation!
+ - * 11.1 22.2
Enter your expression seperated by a space and writen in prefix notation!
/ -100. 20.
Enter your expression seperated by a space and writen in prefix notation!
- 78.9 45.6 12.3
Enter your expression seperated by a space and writen in prefix notation!
* + 5.0 2.5 3.0
Enter your expression seperated by a space and writen in prefix notation!
* - 9.8 3. +  2. 1.

Equations:

(5.0 * -7.0) = -35.0
(4.0 + (30.0 / 2.0)) = 19.0
INVALID
(3.5 / 0.0) = Infinity
INVALID
(-100.0 / 20.0) = -5.0
INVALID
((5.0 + 2.5) * 3.0) = 22.5
((9.8 - 3.0) * (2.0 + 1.0)) = 20.4
Simple Expressions: 3
*/