class AddExpression extends MathBinaryExpression
{
	public AddExpression(MathExpression exp1, MathExpression exp2)
	{
		super(exp1, exp2);
	}
	public double evaluate()
	{
		return leftExpression.evaluate() + rightExpression.evaluate();
	}
	public String toString()
	{
		return "(" + leftExpression.toString() + " + " + rightExpression.toString() + ")";
	}
}
class SubExpression extends MathBinaryExpression
{
	public SubExpression(MathExpression exp1, MathExpression exp2)
	{
		super(exp1, exp2);
	}
	public double evaluate()
	{
		return leftExpression.evaluate() - rightExpression.evaluate();
	}
	public String toString()
	{
		return "(" + leftExpression.toString() + " - " + rightExpression.toString() + ")";
	}
}
class MultExpression extends MathBinaryExpression
{
	public MultExpression(MathExpression exp1, MathExpression exp2)
	{
		super(exp1, exp2);
	}
	public double evaluate()
	{
		return leftExpression.evaluate() * rightExpression.evaluate();
	}
	public String toString()
	{
		return "(" + leftExpression.toString() + " * " + rightExpression.toString() + ")";
	}
}
class DivExpression extends MathBinaryExpression
{
	public DivExpression(MathExpression exp1, MathExpression exp2)
	{
		super(exp1, exp2);
	}
	public double evaluate()
	{
		return leftExpression.evaluate() / rightExpression.evaluate();
	}
	public String toString()
	{
		return "(" + leftExpression.toString() + " / " + rightExpression.toString() + ")";
	}
}