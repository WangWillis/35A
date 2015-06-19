/********************************************************
|	Class name: Hourly	<<Subclass of Employee>>		|
*********************************************************
|	-hourRate: double									|
*********************************************************
|	+Hourly(double, String, String)						|
|	+getRate(): double									|
|	+changeRate(double): void							|
|	+toString(): String									|
********************************************************/

class Hourly extends Employee
{
	private double hourRate;
	public Hourly(double rate, String name, String ssn)
	{
		super(name, ssn);
		hourRate = rate;
	}
	public double getRate()
	{
		return hourRate;
	}
	public void changeRate(double rate)
	{
		hourRate = rate;
	}
	public String toString()
	{
		return "Hourly " + super.toString() + " , Wage = " + hourRate;
	}
}