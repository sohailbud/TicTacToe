# Tic-Tac-Toe

### Computer.java
* Computer finds out if the player can win in next turn and prevents player from winning
* If player cannot win in next turn, computer finds the best possible option and plays it 

### Player.java
* Takes a user input from player and plays at that position
* If player accidentally puts a position that has been already taken, it gives the player option to play again
	
### Runner.java
Contains the main method
* Creates Tic-Tac-Toe board, creates objects for player and computer and calls play() method on them
* Checks if either computer or player won by calling didWin() method
* Checks to see if its a tie
