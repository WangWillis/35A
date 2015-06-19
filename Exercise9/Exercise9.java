import java.util.Scanner;
public class Exercise9
{
	static Scanner in = new Scanner(System.in);
	public static int [][] memalloc()
	{
		System.out.println("Enter the dimensions of the array.");
		return new int [in.nextInt()] [in.nextInt()];
	}
	public static void initialize(int array[][])
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				array[i][j] = i + j;
				System.out.printf(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String arg[])
	{
		int array[][];
		array = memalloc();
		initialize(array);
	}
}