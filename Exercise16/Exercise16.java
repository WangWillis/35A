/************************************
|	Class name: Customer			|
*************************************
|	-name: String					|
|	-accountNumber: long	  		|
|	-savings: SavingsAccount		|
*************************************
|	+Customer(String, long, double)	|
|	+changeName(String): void		|
|	+getSavings(): double			|
|	+getName(): String				|
|	+getAccountNumber(): double		|
************************************/
class Customer
{
	private StringBuilder lastName = new StringBuilder();
	private StringBuilder firstName = new StringBuilder();
	private long accountNumber;
	private SavingsAccount savings;
	public Customer(String name, long account, double save)
	{
		int split = name.indexOf(',');
		lastName.append(name.substring(0, split));
		firstName.append(name.substring(split));
		accountNumber = account;
		savings = new SavingsAccount(save);
	}
	public boolean changeName(String name)
	{
		int split = name.indexOf(',');
		firstName.setLength(0);
		lastName.setLength(0);
		if(split == -1 || split == 0)
		{
			System.out.println("Wrong Format");
			return false;
		}
		lastName.append(name.substring(0, split));
		firstName.append(name.substring(split));
		return true;
	}
	public SavingsAccount getSavings()
	{
		return savings;
	}
	public long getAccountNumber()
	{
		return accountNumber;
	}
	public String getName()
	{
		return lastName.toString() + firstName.toString();
	}
}