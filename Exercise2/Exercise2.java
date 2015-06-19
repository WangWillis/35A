public class Exercise2
{
	public static void main(String temp[])
	{
		short mask = 0x000F, num1 = 0x7ABC, num2;
		num2 = (short)((num1 <<  8) & (mask << 11));
		System.out.println(num2);
	}
}
/*
1111 1111 1(111 1)111
0000 0000 0000 (1111)
0(000 0)000 0000 0000

0101 0000 0000 0000
0111 1000 0000 0000
0000 0000 0000 0000
*/