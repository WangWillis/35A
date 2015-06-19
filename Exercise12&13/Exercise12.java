/************************************************
|	Class name: Rectangle						|
*************************************************
|	-length: int								|
|	-width: int				   					|
*************************************************
|	+Rectangle(l: double, w: double)			|
|	+changeRect(len: double, wid: dobule): void	|
|	+getWidth(): double							|
|	+getLength(): double						|
|	+getArea(): double							|
|	+getPerimeter: double						|
************************************************/

class Rectangle
{
	private double length, width;
	public Rectangle(double l, double w)
	{
		if(l <= 0 || w <= 0)
		{
			System.out.println("Length and width must be greater than 0!!!");
			length = 1;
			width = 1;
		}
		else 
		{
			length = l;
			width = w;
		}
	}
	public void changeRect(double len, double wid)
	{
		if(len <= 0 || wid <= 0)
		{
			System.out.println("Length and width must be greater than 0!!!");
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