package pack1;
import pack2.*;

public class TryMyMath
{
	public static void math1(double num2)
	{
		System.out.println(MyMath.method(num2*num2) + " " + MyMath.method(num2*num2*num2));
	}

	public static void main(String temp[])
	{
		math1(Math.E);
	}
}
//7.39 20.09