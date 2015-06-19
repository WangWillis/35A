import java.util.*;
public class Exercise30
{
	public static void main(String args[])
	{
		LinkedHashMap<Integer, String> map = new LinkedHashMap();
		map.put(0XFF0000, "RED");
		map.put(0X008000, "GREEN");
		map.put(0X0000FF, "BLUE");
		map.put(0X000000, "BLACK");
		map.put(0XFFFFFF, "WHITE");
		map.put(0X800080, "PURPLE");
		Iterator<Integer> move = map.keySet().iterator();
		while(move.hasNext())
		{
			Integer in = move.next();
			System.out.println(in + ", " + map.get(in));
		}
	}
}