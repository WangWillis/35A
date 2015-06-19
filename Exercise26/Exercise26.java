public class Exercise26
{
   public static <E> void printArray(E [] inputArray)
	{           
        for(int i = inputArray.length-1; i >= 0; i--)
        {
        	System.out.println(inputArray[i]);
        }
    }
    public static void main(String args[])
    {
        Double [] doubleArray = {1.1, 2.2, 3.3, 4.4, 0.};
        String [] str = {"How", "do", "I", "use", "this", "thing", "omg"};
        printArray(doubleArray);
        printArray(str);
    } 
}
/*
0.0
4.4
3.3
2.2
1.1
omg
thing
this
use
I
do
How
*/