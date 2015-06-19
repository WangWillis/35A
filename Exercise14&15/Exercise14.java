/************************************
|	Class name: Customer			|
*************************************
|	-name: String					|
|	-accountNumber: long	  		|
|	-savings: SavingsAccount			|
*************************************
|	+Customer(String, long, double)	|
|	+changeName(String): void		|
|	+getSavings(): double			|
|	+getName(): String				|
|	+getAccountNumber(): double		|
************************************/
class Customer
{
	private String name;
	private long accountNumber;
	private SavingsAccount savings;
	public Customer(String name, long account, double save)
	{
		this.name = name;
		accountNumber = account;
		savings = new SavingsAccount(save);
	}
	public void changeName(String name)
	{
		this.name = name;
	}
	public double getSavings()
	{
		return savings.getBalance();
	}
	public long getAccountNumber()
	{
		return accountNumber;
	}
	public String getName()
	{
		return name;
	}
}