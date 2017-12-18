package cs1302.p2;

import java.util.Random;


/** 
 * <h1>RandomComputerPlayer</h1>
 * A child class of ComputerPlayer that represents
 * a random computer player. 
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-2
 */
public class RandomComputerPlayer extends ComputerPlayer{
    Random r = new Random();

    int row;
    int col;
 
     public RandomComputerPlayer(String name){
	super(name);

    }// RCP Constructor

    @Override
    int getRow(){
	return this.row;
    }// getRow

    @Override
    int getCol(){
	return this.col;
    }

    @Override
    void run(){
	randomPlay();

    }// run

    @Override
    void randomPlay(){
	this.row = r.nextInt(8);
	this.col = r.nextInt(8);

    }// generates random number for row/col
}