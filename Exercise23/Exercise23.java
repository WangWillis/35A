//Exercise 5.2
import java.util.*;
public class Exercise23
{
	static Scanner in = new Scanner(System.in);
	public static void main(String args[])
	{
		boolean exp;
		Rectangle r1 = null;
		do
		{
			exp = false;
			try
			{
				System.out.println("Please enter two dimentions for Rectangles");
				r1 = new Rectangle(in.nextInt(), in.nextInt());
			}
			catch(MyException e)
			{
				exp = true;
				System.out.println(e);
			}
		}while(exp);
		System.out.println("Width: " + r1.getWidth());
		System.out.println("Length: " + r1.getLength());
		System.out.println("Area: " + r1.getArea());
	}
}