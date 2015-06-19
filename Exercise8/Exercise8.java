public class Exercise8
{
	public static float [] arrayStuff(float coff, int numElems)
	{
		float array[] = new float [numElems];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = i * coff;
		}
		return array;
	}
	public static void backDisp(float array[])
	{
		for(int i = array.length - 1; i >= 0; i--)
		{
			System.out.print(array[i] + " ");
		}
	}
	public static void main(String arg[])
	{
		float mainArr[] = arrayStuff(10, 8);
		backDisp(mainArr);
	}
}