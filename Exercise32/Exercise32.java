import java.util.*;
class MyQueue<E extends Comparable<E>> implements Queue<E>, Comparable<MyQueue<E>>
{
	protected Arraylist<E> mList = new Arraylist<E>();
	int compareTo(MyQueue<E> mq)
	{
		for(int i = 0; i < mList.size() && i < mq.getArrayList().size(); i++)
		{
			if(mList.get(i) != mq.getArrayList().get(i))
			{
				return mList.get(i).compareTo(mq.getArrayList().get(i));
			}
		}
		if(mList.size() > mq.getArrayList().size())
		{
			return 1;
		}
		else if(mList.size() < mq.getArrayList().size())
		{
			return -1;	
		}
		else
		{
			return 0;
		}
	}
	public Arraylist getArrayList()
	{
		return mList;
	}
}