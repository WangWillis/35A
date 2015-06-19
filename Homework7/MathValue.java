class MathValue implements MathExpression
{
	private double doubVal;
	public double evaluate()
	{
		return doubVal;
	}
	public MathValue(double temp)
	{
		doubVal = temp;
	}
	public String toString()
	{
		return Double.toString(doubVal);
	}
}