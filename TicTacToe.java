import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
		char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};


		printBoard(board);

		int movecnt = 0;
		int currentplayer = 0;
		while (movecnt < 9) {
			System.out.print("Player " + (currentplayer + 1) + "enter row number:");
			int row = reader.nextInt();
			System.out.print("Player " + (currentplayer + 1) + "enter column number:");
			int col = reader.nextInt();
			while (((row < 1 || col < 1) || (row > 3 || col > 3)) || (board[row - 1][col - 1] != ' ')) {
				System.out.println("Invalid move! Please choose another place");
				System.out.print("Player " + (currentplayer + 1) + "enter row number:");
				row = reader.nextInt();
				System.out.print("Player " + (currentplayer + 1) + "enter column number:");
				col = reader.nextInt();
			}
			if (currentplayer == 0) {
				board[row - 1][col - 1] = 'X';
			} else {
				board[row - 1][col - 1] = '0';
			}
			printBoard(board);

			if(checkBoard(board)){
				System.out.println("Player "+(currentplayer+1) +"won the game");
				break;
			}

			currentplayer = (currentplayer + 1) % 2;
			movecnt++;

			if(movecnt==9){
				System.out.println("Its a draw!");

			}

		}
		reader.close();
	}


	public static void printBoard(char[][] board) {
		System.out.println("    1   2   3");
		System.out.println("   -----------");
		for (int row = 0; row < 3; ++row) {
			System.out.print(row + 1 + " ");
			for (int col = 0; col < 3; ++col) {
				System.out.print("|");
				System.out.print(" " + board[row][col] + " ");
				if (col == 2)
					System.out.print("|");

			}
			System.out.println();
			System.out.println("   -----------");

		}

	}

	public static boolean checkBoard(char[][] board) {
		// Check all the row
		for (int row = 0; row < 3; row++) {
			if ((board[row][0] == board[row][1]) && (board[row][1] == board[row][2]) && board[row][0] != ' ')
				return true;
		}
		// Check all the columns
		for (int col = 0; col < 3; col++) {
			if ((board[0][col] == board[1][col]) && (board[1][col] == board[2][col]) && board[0][col] != ' ')
				return true;
		}
		// Check all the top-left to bottom-right
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
			return true;
		// Check all the bottom-left to top-right
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ')
			return true;
		// No winner yet
		return false;

	}

}