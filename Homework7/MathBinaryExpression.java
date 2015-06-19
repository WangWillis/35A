abstract class MathBinaryExpression implements MathExpression
{
	protected MathExpression leftExpression, rightExpression;
	public MathBinaryExpression(MathExpression exp1, MathExpression exp2)
	{
		if(!(exp1 == null || exp2 == null))
		{
			leftExpression = exp1;
		}
		else
		{
			leftExpression = new MathValue(0);
		}
		if(exp2 != null)
		{
			rightExpression = exp2;
		}
		else
		{
			rightExpression = new MathValue(0);
		}
	}
	public MathExpression getLeft()
	{
		return leftExpression;
	}
	public MathExpression getRight()
	{
		return rightExpression;
	}
}