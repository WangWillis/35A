class MyException extends Exception
{
	public MyException(String statement)
	{
		super(statement);
	}
}
class Rectangle
{
	private double length, width;
	public Rectangle(double l, double w) throws MyException
	{
		if(l <= 0 || w <= 0)
		{
			throw new MyException("Length and width must be greater than 0!!!");
		}
		else 
		{
			length = l;
			width = w;
		}
	}
	public void changeRect(double len, double wid) throws MyException
	{
		if(len <= 0 || wid <= 0)
		{
			throw new MyException("Length and width must be greater than 0!!!");
		}
		else
		{
			length = len;
			width = wid;			
		}
	}
	public double getWidth()
	{
		return width;
	}
	public double getLength()
	{
		return length;
	}
	public double getArea()
	{
		return width * length;
	}
	public double getPerimeter()
	{
		return (2*width) + (2*length);
	}
}