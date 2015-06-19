class Customer implements Comparable
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
	public int compareTo(Object obj)
	{
		if(this.name.equals(((Customer)obj).getName()))
		{
			if(this.accountNumber < ((Customer)obj).getAccountNumber())
			{
				return -1;
			}
			else if(this.accountNumber > ((Customer)obj).getAccountNumber())
			{
				return 1;
			}
			else
			{
				if(this.savings.getBalance() < ((Customer)obj).savings.getBalance())
				{
					return -1;
				}
				else if(this.savings.getBalance() > ((Customer)obj).savings.getBalance())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		}
		return this.name.compareToIgnoreCase(((Customer)obj).getName());
	}
}