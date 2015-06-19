public class Exercise19
{
	public static void main(String args[])
	{
		Employee [] empArray = new Employee[] 
		{
			new Hour("Donald Duck", "123-45-6789", 20., 30.),
			new Salaried("Mickey Mouse", "987-65-4321", 100000.),
			new Salaried("Bugs Bunny", "121-21-2121", 90000.),
			new Hour("Elmer Fudd", "343-43-4343", 10., 15.)
		};
		for(int i = 0; i < empArray.length; i++)
		{
			System.out.println(empArray[i].toString() + " Pay = " + empArray[i].computePay());
		}
	}
}