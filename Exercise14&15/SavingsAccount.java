public class SavingsAccount 
{
	private static double annualIntRate;
	private double balance;
	public SavingsAccount(double bal)
	{
		if( bal > 0 )
		{
			balance = bal;
		}
	}
	public SavingsAccount()
	{ 

	}
	public double getBalance()
	{ 
		return balance; 
	}
	public boolean transaction(double amount)
	{
		if( balance + amount >= 0 )
		{
			balance += amount;
			return true;
		}
		return false;
	}
	public double addMonthlyInterest()
	{
		double interest;
		interest = balance*annualIntRate/12.;
		balance += interest;
		return interest;
	}
	public static boolean modifyIntRate(double newRate)
	{
		if( newRate >= 0 )
		{
			annualIntRate= newRate;
			return true;
		}
		return false;
	}
	public static double getAnnualIntRate()
	{
		return annualIntRate;
	}
}