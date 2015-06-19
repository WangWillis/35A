class MineGrid
{
	public static final int MIN = 5, MAX = 15;
	private boolean grid[][];
	public void setFalse()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				grid[i][j] = false;
			}
		}
	}
	private boolean checkGrid(boolean temp[][])
	{
		if(temp.length < MIN || temp.length > MAX)
		{
			return false;
		}
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].length > MAX || temp[i].length < MIN || temp[0].length != temp[i].length)
			{
				return false;
			}
		}
		return true;
	}
	private boolean checkMineGrid(MineGrid check)
	{
		if(grid.length != check.grid.length)
		{
			return false;
		}
		for(int i = 0; i < grid.length; i++)
		{
			if(grid[i].length != check.grid[i].length)
			{
				return false;
			}
		}
		return true;
	}
	public MineGrid(int rows, int cols)
	{
		if(rows < MIN)
		{
			rows = MIN;
		}
		else if(rows > MAX)
		{
			rows = MAX;
		}
		if(cols < MIN)
		{
			cols = MIN;
		}
		else if(cols > MAX)
		{
			cols = MAX;
		}
		grid = new boolean [rows][cols];
	}
	public MineGrid(boolean temp[][])
	{
		if(temp != null && checkGrid(temp))
		{
			grid = temp;
		}
		else
		{
			grid = new boolean [MIN][MIN];
		}
	}
	public int getRow()
	{
		return grid.length;
	}
	public int getCol()
	{
		return grid[0].length;
	}
	public void setRandSpots(int mines)
	{
		setFalse();
		while(mines > 0)
		{
			int randRow = (int)(Math.random()*(grid.length)), randCol = (int)(Math.random()*(grid[0].length));
			if(grid[randRow][randCol] != true)
			{
				grid[randRow][randCol] = true;
				mines--;
			}
		}
	}
	public boolean setOneSpot(int row, int col)
	{
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
		{
			return false;
		}
		else
		{
			grid[row][col] = true;
			return true;
		}
	}
	public boolean getOneSpot(int row, int col)
	{
		//this is not needed if it has to be used with setOneSpot...
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
		{
			return false;
		}
		//
		else
		{
			return grid[row][col];
		}
	}
	public MineGrid compareMineGrid(MineGrid comp)
	{
		MineGrid temp;
		if(!checkMineGrid(comp))
		{
			temp = new MineGrid(MIN, MIN);
		}
		else
		{
			temp = new MineGrid(grid.length, grid[0].length);
			for(int i = 0; i < grid.length; i++)
			{
				for(int j = 0; j < grid[i].length; j++)
				{
					if(grid[i][j] && comp.grid[i][j])
					{
						temp.grid[i][j] = true;
					}
					else
					{
						temp.grid[i][j] = false;
					}
				}
			}
		}
		return temp;
	}
	public void display(char tru)
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				if(grid[i][j])
				{
					System.out.print(tru);
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
}