import java.util.*;

public class InputMethods 
{
	public static Scanner scanner = new Scanner( System.in );
	public static boolean wantsToRepeat()
	{
		//to consume blank space char
		scanner.nextLine();
		System.out.println("Do you want to try again? (Y/N)");
		String answer = scanner.nextLine();
		char temp = answer.charAt(0);
		if('y' == temp|| 'Y' == temp)
		{
			return true;
		}
		else 
		{
			return false;
		}
	} 
	public static int readInt(String prompt, int min, int max)
	{
		int inputInt;
		do
		{
			System.out.println(prompt);
			System.out.println("Input range, must be >= "+ min + " and <= " + max);
			inputInt = scanner.nextInt();
			System.out.print("\n");
			if(inputInt < min || inputInt > max)
			{
				System.out.println("Invalid Input");
			}
		}while(inputInt < min || inputInt > max);
		return inputInt;
	}
}