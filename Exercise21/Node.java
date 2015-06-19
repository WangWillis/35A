class Node
{
	private Object data;
	private Node next;
	public Node(Object o, Node n)
	{
		data = o;
		next = n;
	}
	public Object getData()
	{
		return data;
	}
	public void changeData(Object temp)
	{
		data = temp;
	}
	public Node getNext()
	{
		return next;
	}
	public void changeNext(Node temp)
	{
		next = temp;
	}
}