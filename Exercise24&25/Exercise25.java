//Exercise 3.2
import java.io.*;
public class Exercise25
{
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
		try
		{
			FileReader in = new FileReader("Wang_Willis_Infile.txt");
			BufferedReader read = new BufferedReader(in);
			System.out.println("Please enter 3 Numbers");
			a = Integer.parseInt(read.readLine());
			b = Integer.parseInt(read.readLine());
			c = Integer.parseInt(read.readLine());
			System.out.println("Average: " + average(a, b, c));
			System.out.println("Largest: " + largest(a, b, c));
			in.close();
		}
		catch(IOException exp)
		{
			System.err.println(exp);
		}
	}
}
