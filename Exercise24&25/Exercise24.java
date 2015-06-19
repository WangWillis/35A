//Exercise 2.4
import java.io.*;
public class Exercise24
{
	public static void main(String temp[])
	{
		FileOutputStream out = null;
		try
		{
			out = new FileOutputStream("stuff.txt");
		}
		catch(FileNotFoundException err)
		{
			System.err.println(err);
			return;
		}
		PrintWriter printer = new PrintWriter(out, true);
		for(int i = 2; i <= 20; i++)
		{
			printer.println(Math.pow(i, 2) + " " + Math.pow(i, 3));
		}
	}
}