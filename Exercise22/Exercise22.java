//From Exercise 3.2
import java.util.*;
public class Exercise22
{
	static Scanner in = new Scanner(System.in);
	public static int getInt()
	{
		int j = 0;
		boolean exp;
		do
		{
			System.out.println("Please Enter an Int");
			try
			{
				exp = false;
				j = in.nextInt();
			}
			catch(InputMismatchException e)
			{
				exp = true;
				System.out.println("Int was not entered");
			}
			in.nextLine();
		}while(exp);
		return j;
	}
	public static double average(int num1, int num2, int num3)
	{
		return (num1 + num2 + num3) / 3.0;
	}

	public static int largest(int num1, int num2, int num3)
	{
		int big = num1;
		if(num2 > big)
		{
			big = num2;
		}
		if(num3 > big)
		{
			big = num3;
		}
		return big;
	}
	public static void main(String temp[])
	{
		int a, b, c;
		a = getInt();
		b = getInt();
		c = getInt();
		System.out.println("Average: " + average(a, b, c));
		System.out.println("Largest: " + largest(a, b, c));
	}
}