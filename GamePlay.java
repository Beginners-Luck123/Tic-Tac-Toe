
public class GamePlay {
	private char[][] board;
	private char currentPlayerMark;

	public GamePlay() {
		
	board = new char[3][3];
	currentPlayerMark = 'X';
	initializeBoard();
	}
	
	//will set/reset the board to empty values
	public char getCurrentPlayerMark()
	{
		return currentPlayerMark;
	}
	
	public void initializeBoard()
	{
		//goes through rows
		for(int i = 0; i < 3; i++)
		{
			//then columns
			for(int k = 0; k < 3; k++)
			{
				board[i][k] = '-';
			}
		}
	}
	//outputs board
	public void printBoard()
	{
		System.out.println("  A B C ");
		for(int i = 0; i < 3; i++)
		{
			System.out.print(i + 1 + "|");
		for(int k = 0; k < 3; k++)
		{
			System.out.print( board[i][k] + "|");
			
		}
		System.out.println();
		System.out.println(" -------");
		}
	}
	
//Loops through all spaces, if one is empty '-'; return false
	
	public boolean FullBoard()
	{
		boolean isFull = true;
		
		for(int i = 0; i < 3; i++)
		{
			for(int k = 0; k < 3; k++)
			{ if(board[i][k] == '-') {
				isFull = false;
			}
		}
	}
		return isFull;
	}
	//true if there is a win
	public boolean Winner()
	{
		return(checkRows() || checkColumns() || checkDiagonal());
	}
	//goes through rows for X in a row
	private boolean checkRows()
	{
		//if(board[i][0] == board[i][1] && board[i][1] == board[i][2])
		for (int i = 0; i <3; i++)
		{
			if(checkRowCol(board[i][0], board[i][1], board[i][2]))
		     {
		     return true;
		     }
		}
		return false;
	}
	private boolean checkColumns()
	{
		
		for (int i = 0; i <3; i++)
		{
			if(checkRowCol(board[0][i], board[1][i], board[2][i]))
			{
		     
		     return true;
		     }
		}
		return false;
	}
	private boolean checkDiagonal()
	{
		return(checkRowCol(board[0][0], board[1][1], board[2][2])|| checkRowCol(board[0][2], board [1][1], board[2][0]));
	}
	private boolean checkRowCol(char c1, char c2, char c3)
	{
	    return(c1 != '-' && c1 == c2 && c2 == c3);
	
	}
	
	public void changePlayer() {
		if(currentPlayerMark == 'X')
		{
			currentPlayerMark = 'O';
			
		}
		else
		{
			currentPlayerMark = 'X';
		}
	}
	//Places a mark at the cell specified by rows and column with the mark of the current player
	public boolean placeMark(int row, int col)
	{
		//Make sure that row and column are in bounds of the board
		if((row >= 0) && (row < 3))
		{
			if((col >= 0) && (col < 3)){
				if(board[row][col] == '-') {
					board[row][col] = currentPlayerMark;
					return true;
				}
			}
		
	}
		return false;
	}
	public static void comments()
	{
		int z = (int) (Math.random()*10 + 1);
		if( z == 1)
			System.out.println( "Wow you're so close!");
		else if (z == 2)
			System.out.println ("Are you actually trying?");
		else if (z == 3)
			System.out.println ("I know you can do better than that.");
		else if (z == 4)
			System.out.println ("Show em who's boss!");
		else if (z == 5)
			System.out.println ("You're doing great!");
		else if(z== 6)
			System.out.println ("They don't know what's coming to them.");
		else if(z== 7)	
			System.out.println ("Are you just going to let them do that?");
		else if(z== 8)	
			System.out.println ("Unbelievable!");
		else if(z== 9)	
			System.out.println ("You can do this!");
		else if(z== 10)
			System.out.println ("Good one!");
	
	}
	public static void instructions()
	{
		System.out.println("\t\t\t\tWelcome to the game of Tic-Tac-Toe, \n\t\t\t\t\tPick a player X or O \n\t\t\t\t The goal is to be the first one \n\t\t    To fill up a whole row, column, or diagonal with their mark \n \t\t\t\t     May the best player win! \n\t\t");
	}
	
}
