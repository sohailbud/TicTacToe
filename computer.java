import java.util.ArrayList;
import java.util.List;


public class Computer {
	
	/**
	 * Computer finds out if the player can win in next turn and prevents player from winning
	 * If player cannot win in next turn, computer finds the best possible option and plays it 
	 * @param outcomes
	 * @param TicTacToe
	 * @return
	 */
	public String[] play(List<Integer> outcomes, String[] TicTacToe) {
		Integer playPosition = null;
				
		if (playerAlmostWon(outcomes, TicTacToe)==null) {
			List<Integer> possibleChoices = new ArrayList<Integer>();
			for (int i=0; i<outcomes.size(); i++) {
				String str = String.valueOf(outcomes.get(i));
				char[] digits = str.toCharArray();

				List<Integer> temp = new ArrayList<Integer>();
				for(int j=0; j<digits.length; j++) {
					if(TicTacToe[Character.digit(digits[j],10)-1]==" ") {
						temp.add(Character.digit(digits[j],10));
					} else {
						temp.clear();
					}
				}
				possibleChoices.addAll(temp);	
			}
			playPosition=mode(possibleChoices);

		} else {
			playPosition=playerAlmostWon(outcomes, TicTacToe);
		}
	
		if (TicTacToe[playPosition-1]==" ") {
			TicTacToe[playPosition-1]="O";
		}
		
		System.out.println("Computer plays...");
		System.out.println(TicTacToe[0]+" | "+TicTacToe[1]+" | "+TicTacToe[2]+"\n"+"‾‾‾‾‾‾‾‾‾"+"\n"+
				TicTacToe[3]+" | "+TicTacToe[4]+" | "+TicTacToe[5]+"\n"+"‾‾‾‾‾‾‾‾‾"+"\n"+
				TicTacToe[6]+" | "+TicTacToe[7]+" | "+TicTacToe[8]);
		
		return TicTacToe;
		
	}
	
	/**
	 * Simple method to check if computer won
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
				if(TicTacToe[Character.digit(digits[j],10)-1]=="O") {
					filled++;
				}
			}
			
			if(filled==3) {
				won=true;
				System.out.println("COMPUTER WON, You really suck at this!");
			}	
		}
		
		
		return won;
	}
	
	/**
	 * Computer uses this method to check if player can win in next turn
	 * @param outcomes
	 * @param TicTacToe
	 * @return
	 */
	private Integer playerAlmostWon(List<Integer> outcomes, String[] TicTacToe) {
		
		Integer missing = null;

		for (int ii=0; ii<outcomes.size(); ii++) {			
			String str = String.valueOf(outcomes.get(ii));
			char[] digits = str.toCharArray();
			int filled = 0;

			missing=null;
			for(int j=0; j<digits.length; j++) {
				if(TicTacToe[Character.digit(digits[j],10)-1]=="X") {
					filled++;
				} else if(TicTacToe[Character.digit(digits[j],10)-1]==" ") {
					missing = Character.digit(digits[j],10);
				}
			}
			if(filled==2) {
				break;
			} else {
				missing = null;
			}
		}
		
		return missing;
	}

	/**
	 * Finds mode of list of int array
	 * @param a
	 * @return
	 */
	private int mode(List<Integer> a) {
	    int maxValue = 0;
	    int maxCount = 0;

	    for (int i = 0; i < a.size(); ++i) {
	        int count = 0;
	        for (int j = 0; j < a.size(); ++j) {
	            if (a.get(j) == a.get(i)) ++count;
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = a.get(i);
	        }
	    }

	    return maxValue;
	}

}
