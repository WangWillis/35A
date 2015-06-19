import java.util.*;
public class Exercise29
{
	static Set<Character> charSet = new HashSet<Character>()
	{{
		add('0'); add('1'); add('2'); add('3'); add('4'); add('5'); add('6'); add('7'); add('8'); add('9');
		add('A'); add('B'); add('C'); add('D'); add('E'); add('F');
		add('a'); add('b'); add('c'); add('d'); add('e'); add('f');
	}};
	public static boolean isThere(char temp)
	{
		return charSet.contains(temp);
	}
	public static void main(String args[])
	{
		if(isThere('3'))
		{
			System.out.println("There");
		}
		if(!isThere('r'))
		{
			System.out.println("NOT THERE");
		}
		if(isThere('z'))
		{
			System.out.println("THIS IS BROKEN");
		}
		else
		{
			System.out.println("THIS WORKS");
		}
	}
}
/*
There
NOT THERE
THIS WORKS
*/