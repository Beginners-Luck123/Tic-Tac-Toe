import java.util.Scanner;
public class Game {
public static void main(String[] args)
{
	Scanner scan = new Scanner(System.in);
	GamePlay TicTacToe = new GamePlay();
	TicTacToe.initializeBoard();
	System.out.println();
	System.out.println("                                            TIC-TAC-TOE!");
	System.out.println();
	TicTacToe.instructions();
	String a = "";
	String b = "";
	System.out.println("Player X is: " + a);
	a = scan.nextLine();
	System.out.println("Player O is: " + b);
	b = scan.nextLine();
	System.out.println(a + " goes first!");
	do
	{
		System.out.println("Current Board:");
		TicTacToe.printBoard();
		int row = 0;
		int col = 0;
	    String sentence = "";
	    char col2;
		  
		do 
		{ 
			
			TicTacToe.comments();
	
			System.out.println("Player " + TicTacToe.getCurrentPlayerMark() + " Pick your position");
	    
			sentence = scan.nextLine();
			row = (int)sentence.charAt(0) - '1';
			col2 = sentence.charAt(1);
			
		
			if(col2 == 'A' || col2 == 'a')
			{
				col = 0;
			}
			else if(col2 == 'B' || col2 == 'b')
			{
				col = 1;
			}
			else if(col2 == 'C' || col2 == 'c')
			{
				col = 2;
			}
			
			
		}
		while(!TicTacToe.placeMark(row, col));
		TicTacToe.changePlayer();
		
		
	}
	
	while(!TicTacToe.Winner() && !TicTacToe.FullBoard());
	if(TicTacToe.FullBoard() && TicTacToe.Winner())
	{
		System.out.println("IT'S A TIE!");
		
	}
	else
		System.out.println("Current Board:");
	TicTacToe.printBoard();
	

	TicTacToe.changePlayer();
	if(TicTacToe.getCurrentPlayerMark() == 'X' && TicTacToe.FullBoard() && !TicTacToe.Winner())
	{
		System.out.println( a + " WINS!");
		System.out.println("Better luck next time " + b);
	}
	else if (TicTacToe.getCurrentPlayerMark() == 'O' && TicTacToe.FullBoard() && !TicTacToe.Winner())
		System.out.println( b + " WINS!");
	System.out.println("Better luck next time " + a + ".");
	scan.close();
}

}

