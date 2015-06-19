import java.util.*;
public class Exercise27
{
	public static void main(String args[])
	{
		ArrayList<Integer> num = new ArrayList<>();
		LinkedList nums = new LinkedList();
		for(int i = 2; i <= 10; i += 2)
		{
			num.add(i);
			nums.add(i);
		}
		for(int ele : num)
		{
			System.out.println(ele);
		}
		System.out.println(nums);
	}
}