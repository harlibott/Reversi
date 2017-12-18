package cs1302.p2;

/**
 * <h1>Player</h1>
 * This abstract class represents a player in a reversi game. 
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-2
 */  
public abstract class Player{
    Reversi r = new Reversi();

    String playerName;
    int row, col;

    /**
     * A constructor that sets the player name. 
     *
     * @param name  a string that represents the name
     */
    public Player(String name){
	this.playerName = name + " "; 

    }//player  constructor

    /**
     * A method that returns the row
     *
     * @return int  represents Row
     */
    abstract int getRow();
   
    /**
     * A method that returns the columns
     *
     * @return int  represents Column
     */ 
    abstract int getCol();

    /**
     * A method that returns the player name. 
     *
     * @return String  the player name
     */
    String getPlayerName(){
	return this.playerName;
    }// player name

    /**
     * A method to check if row and column are in bounds.
     *
     * @param  r     an int representing row
     * @param  c     an int representing column
     * @return true  if in bounds
     * @return false if not in bounds
     */
    boolean validate(int r, int c){
	if((r >= 0 && r < 8) && c >= 0 && c < 8){
	    return true;
	}else{
	    return false;
	}

    }//validate

    /**
     * A method that returns the name of the opponent.
     * 
     * @return String  represents opponent name
     */
    String getOpponent(){
	if(this.playerName.equals("X ")){
	    return "O ";
	}else{
	    return "X ";
	}
    }// get opponent
}
