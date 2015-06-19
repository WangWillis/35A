/****************************************************
Program Name: Minesweaper 2
Programer: Willis Wang
Date: 05/13/15
Compiler: JavaC JDK 8
Discription: Create a simplified game of Mine Sweaper
with its own class
****************************************************/
public class Homework3
{
	public static void  userInput(MineGrid temp, int mines)
	{
		int row, col;
		while(mines > 0)
		{
			System.out.println("Mine: " + mines);
			row = InputMethods.readInt("Please enter the ROW you want to guess: ", 1, temp.getRow());
			col = InputMethods.readInt("Please enter the COLLUM you want to guess: ", 1, temp.getCol());
			if(!temp.getOneSpot(row-1, col-1) && temp.setOneSpot(row-1, col-1))
			{
				mines--;
			}
			else
			{
				System.out.println("Spot has already been set or Invalid Input");
			}
		}
	}
	public static void main(String args[])
	{
		MineGrid comp, user, result;
		int rows, cols, mines;
		rows = InputMethods.readInt("Enter the number of ROWS", MineGrid.MIN, MineGrid.MAX);
		cols = InputMethods.readInt("Enter the number of COLLUMS", MineGrid.MIN, MineGrid.MAX);
		user = new MineGrid(rows, cols);
		comp = new MineGrid(rows, cols);
		mines = InputMethods.readInt("Enter the number mines", rows, (rows * cols)/2);
		do
		{
			comp.setRandSpots(mines);
			userInput(user, mines);
			result = comp.compareMineGrid(user);
			System.out.println("User: ");
			user.display('G');
			System.out.println("Computer: ");
			comp.display('*');
			System.out.println("Result: ");
			result.display('M');
			user.setFalse();
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

User:
G             G
  G

    G
G  G          G
Computer:
         **
   *
     * *

      *       *
Result:




              M
Do you want to try again? (Y/N)
y
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

User:
GGGGGGG




Computer:
     *

       * * *
           *
 *  *
Result:
     M




Do you want to try again? (Y/N)
n

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

Spot has already been set or Invalid Input
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

Spot has already been set or Invalid Input
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

Spot has already been set or Invalid Input
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

User:
G     G


GGGG

G     G
Computer:
   *
   * *
**
*
  *   *

Result:



M


Do you want to try again? (Y/N)
y
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

Spot has already been set or Invalid Input
Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
2

Spot has already been set or Invalid Input
Mine: 5
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Spot has already been set or Invalid Input
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

Spot has already been set or Invalid Input
Mine: 3
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
6

Spot has already been set or Invalid Input
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

User:



GGG GGG

GG
Computer:
*    *
*
      *
      *
      *
* *
Result:



      M

M
Do you want to try again? (Y/N)
y
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

Spot has already been set or Invalid Input
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

Spot has already been set or Invalid Input
Mine: 2
Please enter the ROW you want to guess:
Input range, must be >= 1 and <= 6
4

Please enter the COLLUM you want to guess:
Input range, must be >= 1 and <= 7
3

Spot has already been set or Invalid Input
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

User:
 G   G
    G
   G
  G
 G   G
G
Computer:


*     *
    * *
    * *
 * *
Result:






Do you want to try again? (Y/N)
n
*/