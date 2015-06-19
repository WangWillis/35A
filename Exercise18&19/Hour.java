class Hour extends Employee
{
	private double hourRate, hourWork;
	public Hour(String name, String ssn, double rate, double hours)
	{
		super(name, ssn);
		hourRate = rate;
		hourWork = hours;
	}
	public double getRate()
	{
		return hourRate;
	}
	public void changeRate(double rate)
	{
		hourRate = rate;
	}
	public double computePay()
	{
		return hourWork * hourRate;
	}
	public String toString()
	{
		return "Hourly " + super.toString() + " , Wage = " + hourRate;
	}
}