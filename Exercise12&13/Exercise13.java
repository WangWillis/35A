public class Exercise13
{
	public static void main(String args[])
	{
		Rectangle r1, r2;
		r1 = new Rectangle(3, 4.5);
		r2 = new Rectangle(-1, -2);
		System.out.println(r1.getWidth() + " " + r1.getLength());
		System.out.println(r2.getWidth() + " " + r2.getLength());
		System.out.println(r1.getArea() + " " + r1.getPerimeter());
		System.out.println(r2.getArea() + " " + r2.getPerimeter());
		r1.changeRect(5, 5);
		r2.changeRect(3, 7);
		System.out.println(r1.getWidth() + " " + r1.getLength());
		System.out.println(r2.getWidth() + " " + r2.getLength());
		System.out.println(r1.getArea() + " " + r1.getPerimeter());
		System.out.println(r2.getArea() + " " + r2.getPerimeter());
	}
}
/*
Length and width must be greater than 0!!!
4.5 3.0
1.0 1.0
13.5 15.0
1.0 4.0
5.0 5.0
7.0 3.0
25.0 20.0
21.0 20.0
*/