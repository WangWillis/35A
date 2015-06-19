/****************************************************
Program Name: RomanNumerals 2
Programer: Willis Wang
Date: 06/15/15
Compiler: JavaC JDK 8
Discription: Recreate Homework 4 using updated
knowledge
****************************************************/
import java.io.*;
import java.util.*;
public class Homework6
{
	public static ArrayList<RomanNumeral> getList()
	{
		ArrayList<RomanNumeral> temp = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("What is the name of your RomanNumeral file!");
		try
		{
			Scanner read = new Scanner(new File(in.nextLine()));
			System.out.println();
			while(read.hasNextLine())
			{
				String str = read.nextLine();
				try
				{
					temp.add(new RomanNumeral(str));
				}
				catch(RomNumExp exp)
				{
					System.out.println(str + " is not a valid Roman Numeral!!! Not adding to list!");
				}
			}
			System.out.println();
			read.close();
		}
		catch(FileNotFoundException exp)
		{
			System.err.println(exp);
			return temp;
		}
		return temp;
	}
	public static void write(ArrayList<RomanNumeral> write)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What is the name of the file you want to write to?");
		Iterator<RomanNumeral> iterate = write.iterator();
		try
		{
			FileOutputStream out = new FileOutputStream(in.nextLine());
			PrintWriter writer = new PrintWriter(out, true);
			while(iterate.hasNext())
			{
				RomanNumeral temp = iterate.next();
				writer.println(temp);
			}
			System.out.println("Write Finished!");
			writer.close();
		}
		catch(FileNotFoundException exp)
		{
			System.err.println(exp);
		}
	}
	public static RomanNumeral getMid(ArrayList<RomanNumeral> temp)
	{
		return temp.get(temp.size()/2);
	}
	public static void main(String args[])
	{
		
		ArrayList<RomanNumeral> romNumList = getList();
		if(romNumList.isEmpty())
		{
			System.out.println("Invalid List!!! Exiting!!!!");
		}
		else
		{
			Collections.sort(romNumList);
			write(romNumList);
			System.out.println("\nMeidian Roman Numeral is: " + getMid(romNumList));
		}
	}
}
/*
Test 1

What is the name of your RomanNumeral file!
HW6-TestInput1.txt


What is the name of the file you want to write to?
test1.txt
Write Finished!

Meidian Roman Numeral is: RomanNumeral: IX 9
*/

/*
Test 2

What is the name of your RomanNumeral file!
HW6-TestInput2.txt

MILK is not a valid Roman Numeral!!! Not adding to list!
XXWIII is not a valid Roman Numeral!!! Not adding to list!
bcd is not a valid Roman Numeral!!! Not adding to list!
 is not a valid Roman Numeral!!! Not adding to list!

What is the name of the file you want to write to?
test2.txt
Write Finished!

Meidian Roman Numeral is: RomanNumeral: CCXXII 222
*/

/*
Test 3

What is the name of your RomanNumeral file!
HW6-TestInput3.txt

NotValid is not a valid Roman Numeral!!! Not adding to list!

What is the name of the file you want to write to?
test3.txt
Write Finished!

Meidian Roman Numeral is: RomanNumeral: DCXLIV 644
*/