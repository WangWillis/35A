/****************************************************
Program Name: Minesweaper
Programer: Willis Wang
Date: 05/01/15
Compiler: JDK 8
Discription: Create a simplified game of Mine Sweaper
****************************************************/

public class Homework2
{
	static final int MINVAL = 5, MAXVAL = 15;
	public static boolean [][] setFalse(boolean temp[][])
	{
		for(int i = 0; i < temp.length; i++)
		{
			for(int j = 0; j < temp[i].length; j++)
			{
				temp[i][j] = false;
			}
		}
		return temp;
	}
	public static boolean [][] createGrid(int rows, int cols)
	{
		return new boolean [rows][cols];
	}
	public static boolean [][] setGame(boolean temp[][], int mines)
	{
		temp = setFalse(temp);
		while(mines > 0)
		{
			int randRow = (int)(Math.random()*(temp.length)), randCol = (int)(Math.random()*(temp[0].length));
			if(temp[randRow][randCol] != true)
			{
				temp[randRow][randCol] = true;
				mines--;
			}
		}
		return temp;
	}
	public static boolean [][] userInput(boolean temp[][], int mines)
	{
		temp = setFalse(temp);
		System.out.println("Enter your guesses for " + mines + " mines\n");
		while(mines > 0)
		{
			int rowTemp, colTemp;
			System.out.println("Mine: " + mines);
			rowTemp = InputMethods.readInt("Please enter the ROW you want to guess: ", 1, temp.length);
			colTemp = InputMethods.readInt("Please enter the COLLUM you want to guess: ", 1, temp[0].length);
			if(temp[rowTemp-1][colTemp-1] != true)
			{
				temp[rowTemp-1][colTemp-1] = true;
				mines--;
			}
			else
			{
				System.out.println("Sorry you have already guessed this spot.");
				System.out.println("Please try again!\n");
			}
		}
		return temp;
	}
	public static boolean [][] formatOutput(boolean comp[][], boolean user[][], boolean temp[][])
	{
		temp = setFalse(temp);
		for(int i = 0; i < comp.length; i++)
		{
			for(int j = 0; j < comp[i].length; j++)
			{
				if(comp[i][j] == true && user[i][j] == true)
				{
					temp[i][j] = true;
				}
				else
				{
					temp[i][j] = false;
				}
			}
		}
		return temp;
	}
	public static void display(boolean comp[][], boolean user[][], boolean output[][])
	{
		System.out.println("Computer: \n");
		for(int i = 0; i < comp.length; i++)
		{
			for(int j = 0; j < comp[i].length; j++)
			{
				if(comp[i][j])
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.print("\n");
		}
		System.out.println("\nUser: \n");
		for(int i = 0; i < user.length; i++)
		{
			for(int j = 0; j < user[i].length; j++)
			{
				if(user[i][j])
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.print("\n");
		}
		System.out.println("\nResults: \n");
		for(int i = 0; i < output.length; i++)
		{
			for(int j = 0; j < output[i].length; j++)
			{
				if(output[i][j])
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.print("\n");
		}
	}
	public static void main(String args[])
	{
		boolean comp[][], user[][], output[][];
		int rows, cols, mines;
		rows = InputMethods.readInt("Enter the number of ROWS", MINVAL, MAXVAL);
		cols = InputMethods.readInt("Enter the number of COLLUMS", MINVAL, MAXVAL);
		comp = createGrid(rows, cols);
		user = createGrid(rows, cols);
		output = createGrid(rows, cols);
		mines = InputMethods.readInt("Enter the number mines", rows, (rows * cols)/2);
		do
		{
			comp = setGame(comp, mines);
			user = userInput(user, mines);
			output = formatOutput(comp, user, output);
			display(comp, user, output);
		}while(InputMethods.wantsToRepeat());
	}
}
/*
Test 1
Enter the number of ROWS
Input range, must be >= 5 and <= 15
5

Enter the number of COLLUMS
Input range, must be >= 5 and <= 15
15

Enter the number mines
Input range, must be >= 5 and <= 37
7

Enter your guesses for 7 mines

Mine: 7
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
1

Mine: 6
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
15

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
5

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
1

Mine: 4
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
5

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
15

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
2

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
3

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
5

Mine: 1
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
5

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
4

Computer:

- * - - - - - - - - - - - - -
- - - - - - - - - - - - - * -
- - - - - - - - - - - - * - -
* - * - - - - - - * - - - - -
- - - - - - - - * - - - - - -

User:

* - - - - - - - - - - - - - *
- - * - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - * - - - - - - - - - -
* - - * - - - - - - - - - - *

Results:

- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
Do you want to try again? (Y/N)
y
Enter your guesses for 7 mines

Mine: 7
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
1

Mine: 6
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
2

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
3

Mine: 4
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
4

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
5

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
6

Mine: 1
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 5
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 15
7

Computer:

- - - - - - - - - - * - - - -
* - - - - - - - - - - - - - -
- - - - - - * - - - - - - - -
- - - - - - - * - - - - - * -
- - - - - - - - - - - * - * -

User:

* * * * * * * - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -

Results:

- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
- - - - - - - - - - - - - - -
Do you want to try again? (Y/N)
n
*/

/*
Test 2
Enter the number of ROWS
Input range, must be >= 5 and <= 15
4

Invalid Input
Enter the number of ROWS
Input range, must be >= 5 and <= 15
16

Invalid Input
Enter the number of ROWS
Input range, must be >= 5 and <= 15
0

Invalid Input
Enter the number of ROWS
Input range, must be >= 5 and <= 15
6

Enter the number of COLLUMS
Input range, must be >= 5 and <= 15
16

Invalid Input
Enter the number of COLLUMS
Input range, must be >= 5 and <= 15
4

Invalid Input
Enter the number of COLLUMS
Input range, must be >= 5 and <= 15
7

Enter the number mines
Input range, must be >= 6 and <= 21
5

Invalid Input
Enter the number mines
Input range, must be >= 6 and <= 21
22

Invalid Input
Enter the number mines
Input range, must be >= 6 and <= 21
8

Enter your guesses for 8 mines

Mine: 8
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
8

Invalid Input
Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
-1

Invalid Input
Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
7

Mine: 7
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
7

Sorry you have already guessed this spot.
Please try again!

Mine: 7
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
8

Invalid Input
Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Mine: 6
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
7

Invalid Input
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
8

Invalid Input
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
7

Invalid Input
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
6

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
7

Sorry you have already guessed this spot.
Please try again!

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
7

Invalid Input
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
6

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Sorry you have already guessed this spot.
Please try again!

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
6

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
7

Mine: 4
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Mine: 1
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
4

Computer:

- - - - * - -
- - * - - - -
- - - - - - -
- - * * - * -
* - - * - - -
- - - * - - -

User:

* - - - - - *
- - - - - - -
- - - - - - -
* * * * - - -
- - - - - - -
* - - - - - *

Results:

- - - - - - -
- - - - - - -
- - - - - - -
- - * * - - -
- - - - - - -
- - - - - - -
Do you want to try again? (Y/N)
y
Enter your guesses for 8 mines

Mine: 8
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Mine: 7
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Mine: 6
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Sorry you have already guessed this spot.
Please try again!

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Sorry you have already guessed this spot.
Please try again!

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Sorry you have already guessed this spot.
Please try again!

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
5

Mine: 4
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
6

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
5

Sorry you have already guessed this spot.
Please try again!

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
6

Sorry you have already guessed this spot.
Please try again!

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
7

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
6

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Mine: 1
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
6

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Computer:

- - - * - - -
- * - - - - -
- - * * - - -
- * - - - - -
- - - - * * -
- - * - - - -

User:

- - - - - - -
- - - - - - -
- - - - - - -
* * * - * * *
- - - - - - -
* * - - - - -

Results:

- - - - - - -
- - - - - - -
- - - - - - -
- * - - - - -
- - - - - - -
- - - - - - -
Do you want to try again? (Y/N)
y
Enter your guesses for 8 mines

Mine: 8
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
6

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
1

Mine: 7
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
5

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Mine: 6
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
3

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
4

Mine: 4
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
5

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Sorry you have already guessed this spot.
Please try again!

Mine: 4
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
2

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
5

Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
6

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
3

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
4

Sorry you have already guessed this spot.
Please try again!

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Sorry you have already guessed this spot.
Please try again!

Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
5

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
6

Mine: 1
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
1

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Computer:

- - - - - - *
- - - - - - -
- - - - * * -
* - - - - * -
- - - * - - -
- - * - * - -

User:

- * - - - * -
- - - - * - -
- - - * - - -
- - * - - - -
- * - - - * -
* - - - - - -

Results:

- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
Do you want to try again? (Y/N)
n
*/

/*
Need to determine chance of space having a mine and run through all of the spaces
when numMine == col * row it will be 100% chance for less runtime
(numMines/(row*col)) ???
while(countTemp != 0)
{
	for(int i = 0; i < array.length && countTemp != 0; i++)
	{
		for(int j = 0; j < array.length && countTemp != 0; i++)
		{
			if(comp[i][j] != true && Math.random() <= ((double)numMines/(row*col)))
			{
				comp[i][j] = true;
				countTemp--;
			}
		}
	}
}
n ish time
also try to find a way to detemine if the above method is more effecient or if
assigning a mine to a space found by 2 randomly generated numbers
*/