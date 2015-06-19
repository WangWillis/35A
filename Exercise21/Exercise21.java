import java.util.Scanner;
public class Exercise21
{
	static Scanner in = new Scanner(System.in);
	public static Node makeNode()
	{
		System.out.println("Please enter an Interger: ");
		return new Node(in.nextInt(), null);
	}
	public static void main(String args[])
	{
		Node head;
		head = makeNode();
		Node temp;
		temp = new Node(2*((int)head.getData()), null);
		head.changeNext(temp);
		while(head != null)
		{
			System.out.println((int)head.getData());
			head = head.getNext();
		}
	}
}
/*
Please enter an Interger:
6
6
12
*/