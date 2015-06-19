abstract class MathBinaryExpression implements MathExpression
{
	protected MathExpression leftExpression, rightExpression;
	public MathBinaryExpression(MathExpression exp1, MathExpression exp2)
	{
		if(!(exp1 == null || exp2 == null))
		{
			leftExpression = exp1;
			rightExpression = exp2;
		}
		else
		{
			leftExpression = new MathValue(0);
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