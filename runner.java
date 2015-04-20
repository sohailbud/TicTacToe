import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

	/**
	 * Creates Tic-Tac-Toe board, creates objects for player and computer and calls play method on them
	 * Checks if either computer or player won by calling won method
	 * Checks to see if its a tie
	 * @param args
	 */
	public static void main(String[] args){
		
		// All possible outcomes to win
		List<Integer> outcomes = new ArrayList<Integer>();
		outcomes.add(123);
		outcomes.add(456);
		outcomes.add(789);
		outcomes.add(147);
		outcomes.add(258);
		outcomes.add(369);
		outcomes.add(159);
		outcomes.add(357);

		// Tic-Tac-Toe Board
		String[] TicTacToe = {" "," "," "," "," "," "," "," "," "};
		
		// Create Player and Computer objects
		Player player = new Player();
		Computer computer = new Computer();
		
		// PLAY
		for(int turnsLeft=5; turnsLeft>0; turnsLeft--) {
			if(Arrays.asList(TicTacToe).contains(" ")) {
				TicTacToe=player.play(TicTacToe);
			} else {
				System.out.println("ITS A TIE :(");
				break;
			}
			
			if (player.didWin(outcomes, TicTacToe)) {
				break;
			}
			
			if(Arrays.asList(TicTacToe).contains(" ")) {
				TicTacToe=computer.play(outcomes, TicTacToe);
			} else {
				System.out.println("ITS A TIE :(");
				break;
			}
			
			if (computer.didWin(outcomes, TicTacToe)) {
				break;
			}
		}
	}
	
}
