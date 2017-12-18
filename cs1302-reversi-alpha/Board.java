package cs1302.p2;

/**
 * <h1>Board</h1>
 * The class is an abstract class that will represent a general board. 
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-2
 */ 
public abstract class Board{

    /**
     * A method that prints the board when called. 
     */
    abstract void printBoard();
   
    /**
     * A  method that initializes the board when called. 
     */
    abstract void initBoard();
   
    /**
     * A method that validates the user input
     * and checks for the correct bounds. 
     *
     * @param  r     an integer known as row
     * @param  c     an integer known as column
     * @return true  if user input is valid and in bounds
     * @return false if user input is not valid or in bounds
     */
    abstract boolean validPlay(int r, int c);
  
    /**
     * A method that checks the valid movable spaces
     * and prints out a new version of the board. 
     *
     * @param p  a player object
     */
    abstract void validSpaces(Player p);
   
    /**
     * A method that updates the board after
     * a player's move, which handles the flipping of 
     * the player's opponents character.
     *
     * @param p  a player object
     * @param r  an integer known as row
     * @param c  an integer known as column
     */
    abstract void updateBoard(Player p, int r, int c);
   
    /**
     * An abstract method that determines if the board
     * is full or if there are no moves left. 
     *
     * @return  a boolean that returns based on the conditions
     */
    abstract boolean win();

    /**
     * A method that calculates the score
     * of the game. 
     *
     * @return string  the total scores
     */
    abstract String getScores();
   
    /**
     * A method that reverts the board after "_"
     * have been placed back to "."
     */
    abstract void revertBoard();
}