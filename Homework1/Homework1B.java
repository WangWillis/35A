/**************************************************************
Program Name: Find e
Programer: Willis Wang
Date: 04/21/15
Compiler: JDK 8
Discription: Find e using Maclaurin series
Variables: n is count of how many terems were needed to apprx e
error is the maximum error of e
eGuess is the apprx of e
***************************************************************/

public class Homework1B
{
	static final double error = 0.0000000001;
	static final int start = 2;
	public static double inverseFactorial(double n)
	{
		if(n <= 1)
		{
			return 1;
		}
		else
		{
			return 1/n * inverseFactorial(n - 1);
		}
	}
	public static double appxE(Counter count)
	{
		double eGuess = 2;
		count.n = start;
		for(;Math.abs(Math.E - eGuess) > error; count.n++)
		{
			eGuess += inverseFactorial(count.n);
		}
		return eGuess;
	}
	public static void main(String temp[])
	{
		Counter count = new Counter();
		System.out.println("e approximation: " + appxE(count));
		System.out.println("How many n's: " + count.n);	
	}
}
class Counter
{
	public int n;
}