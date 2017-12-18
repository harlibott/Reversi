package cs1302.p2;

/**
 * An abstract child class of Player that represents a computer player. 
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-2
 */
public abstract class ComputerPlayer extends Player{

    /**
     * A constructor that sets the player name
     * and calls on the parent class constructor. 
     *
     * @param name  a string that represents a name
     */
    public ComputerPlayer(String name){
	super(name);

    }// computer constructor

    /** 
     * A method that creates a random play.
     */
    abstract void randomPlay();
   
    /**
     * A method that handles a computer player turn.
     */
    abstract void run();
}