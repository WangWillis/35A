import java.util.Scanner;
public class Exercise7
{
	static Scanner in = new Scanner(System.in);
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
		System.out.println("Please enter 3 Numbers");
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		System.out.println("Average: " + average(a, b, c));
		System.out.println("Largest: " + largest(a, b, c));
	}
}