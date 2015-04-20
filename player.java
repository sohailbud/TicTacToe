import java.util.List;
import java.util.Scanner;


public class Player {
	
	/**
	 * Takes a user input from player and plays at that position
	 * If player accidentally puts a position that has been already taken, it gives the player option to play again
	 * @param TicTacToe
	 * @return
	 */
	public String[] play(String[] TicTacToe) {
		Scanner in = new Scanner(System.in);

		System.out.println("Your turn!"+"\n"+"Chose a position between 1 and 9");
		String userInput = in.nextLine();
		
		if (TicTacToe[Integer.parseInt(userInput)-1]==" ") {
			TicTacToe[Integer.parseInt(userInput)-1]="X";
		} else if(TicTacToe[Integer.parseInt(userInput)-1]=="X" || TicTacToe[Integer.parseInt(userInput)-1]=="O") {
			System.out.println("Position taken, please chose another spot");
			play(TicTacToe);
		}
		
		System.out.println(TicTacToe[0]+" | "+TicTacToe[1]+" | "+TicTacToe[2]+"\n"+"‾‾‾‾‾‾‾‾‾"+"\n"+
				TicTacToe[3]+" | "+TicTacToe[4]+" | "+TicTacToe[5]+"\n"+"‾‾‾‾‾‾‾‾‾"+"\n"+
				TicTacToe[6]+" | "+TicTacToe[7]+" | "+TicTacToe[8]);
		
		return TicTacToe;
	}

	/**
	 * Simple method to check if player won
	 * @param outcomes
	 * @param TicTacToe
	 * @return
	 */
	public boolean didWin(List<Integer> outcomes, String[] TicTacToe) {
		
		boolean won = false;
		
		for (int i=0; i<outcomes.size(); i++) {
			String str = String.valueOf(outcomes.get(i));
			char[] digits = str.toCharArray();
			int filled = 0;

			for(int j=0; j<digits.length; j++) {
				if(TicTacToe[Character.digit(digits[j],10)-1]=="X") {
					filled++;
				}
			}
			
			if(filled==3) {
				won=true;
				System.out.println("YOU WON!!!");
			}	
		}
		
		
		return won;
	}
	
}
