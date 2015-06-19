import java.util.Scanner;
public class Exercise15
{
	static Scanner in = new Scanner(System.in);
	public static Customer [] memAlloc()
	{
		Customer temp[];
		System.out.println("How many customers do you have?");
		temp = new Customer[in.nextInt()];
		return temp;
	}
	public static void main(String args[])
	{
		Customer bank[];
		String name;
		long accountNumber;
		double savings;
		bank = memAlloc();
		for(int i = 0; i < bank.length; i++)
		{
			in.nextLine();
			System.out.println("What is customer " + i+1 + " name?");
			name = in.nextLine();
			System.out.println("What is this customers account number?");
			accountNumber = in.nextLong();
			System.out.println("How much does this customer have in their Savings?");
			savings = in.nextDouble();
			bank[i] = new Customer(name, accountNumber, savings);
		}
	}
}