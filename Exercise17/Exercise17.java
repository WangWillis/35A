import java.util.StringTokenizer;
public static boolean setName(String name)
{
	StringTokenizer split = new StringTokenizer(name);
	if(split.countTokens() < 2)
	{
		System.out.println("Wrong Format");
		return false;
	}
	lastName.setLength(0);
	firstName.setLength(0);
	lastName.append(split.nextElement());
	firstName.append(split.nextElement());
	return true;
}