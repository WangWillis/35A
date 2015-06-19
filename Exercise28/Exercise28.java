import java.util.*;
public class Exercise28
{
	public static void main(String args[])
	{
		Stack<Integer> stk = new Stack();
		PriorityQueue<Integer> que = new PriorityQueue();
		for(int i = 2; i <= 10; i += 2)
		{
			stk.push(i);
			que.add(i);
		}
		System.out.println("Stack");
		while(!stk.empty())
		{
			System.out.println(stk.pop());
		}
		System.out.println("PriorityQueue");
		while(que.size() != 0)
		{
			int temp = que.poll();
			System.out.println(temp);
		}
	}
}