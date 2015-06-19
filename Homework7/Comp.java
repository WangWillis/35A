import java.util.*;
class Comp implements Comparator<String>
{
	public int compare(String left, String right)
	{
		return left.compareTo(right);
	}
}