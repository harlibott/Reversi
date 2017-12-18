package cs1302.p2;
import java.util.Scanner;

/**
 *<h1>Reversi</h1>
 *
 * The Reversi program implements a non-GUI text-based version of Reversi, otherwise 
 * known as "Othello". Including plays with human vs. human, human vs. computer,
 * and computer vs computer with AI implementation. 
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-2 
 */ 
public class Reversi{
    /**
     * A method that handles error checking and messages.
     *
     * @param e  takes in an integer of 1-3
     */
    void error(int e){
	if(e == 1){
	    System.out.println();
	    System.out.println("Sorry, the rows/col you have entered are not correct. Try again!");
	    System.out.println();
	}else if(e == 2){
	    System.out.println();
	    System.out.println("Q/Quit: Game is quitting.... Thanks for playing!!");
	    System.out.println();
	    System.exit(0);
	}else if(e == 3){
	    System.out.println();
	    System.out.println("Sorry, the rows/col you have enterd are not a valid move. Try again!");
	    System.out.println();
	}
	
    }// error messages

    /**
     * A static method that contains Main and 
     * handles the reversi game. 
     *
     * @param args  a String[]
     */    
    public static void main (String[]args){
	Reversi reversi = new Reversi();
	Board rBoard = new ReversiBoard();

	String user = "";
	Boolean game;
	Boolean checker1;
	Boolean checker2;
	int play = 0;
	int row;
	int col;
	
	//Error checking the user initial input before the game even starts
	switch(args.length){
	    
	case 2:
	    System.out.println();
	    if(args[0].equalsIgnoreCase("human") && args[1].equalsIgnoreCase("human")){
		play = 1;
	    }else if(args[0].equalsIgnoreCase("human") && args[1].equalsIgnoreCase("randomcomputerplayer") || args[0].equalsIgnoreCase("randomcomputerplayer") && args[1].equalsIgnoreCase("human")){
		play = 2;

	    }else if(args[0].equalsIgnoreCase("randomcomputerplayer") && args[1].equalsIgnoreCase("randomcomputerplayer")){
		play = 3;
	    }else{
		System.out.println("Sorry, the opponents you entered can't be played");
		System.out.println("You may choose human vs. human, human vs. RandomComputerPlayer, or RandomComputerPlayer vs. RandomComputerPlayer");
		System.out.println();
		System.exit(0); 
	    }
	    break;
	default:
	    System.out.println("Sorry, the opponents you entered can't be played");
	    System.out.println("You may choose human vs. human, human vs. RandomComputerPlayer, or RandomComputerPlayer vs. RandomComputerPlayer ");
	    System.out.println();
	    System.exit(0);

	}// switch 

	//Beginning of the game
	Scanner input = new Scanner(System.in);

	System.out.println("Welcome to Reversi! Moves should be entered in \"[row] [column]\" format!");
	System.out.println();
	// System.out.println(rBoard.getScores());
	rBoard.initBoard(); // sets up game board

	game = true;
	do{
	    if(play == 1){ // human vs. human
		Player hum1 = new HumanPlayer("X");
		Player hum2 = new HumanPlayer("O");

		checker1 = true;
		while(checker1){ // Player 1 valid check
		    rBoard.validSpaces(hum1);
		    if(((HumanPlayer)hum1).userInput()){ // if the user row/col is valid
			row = hum1.getRow(); // getting row
			col = hum1.getCol(); // getting col

			if(rBoard.validPlay(row,col)){ // checking to make sure you can move there
			    checker1 = false;
			    rBoard.updateBoard(hum1,row,col);
			    rBoard.revertBoard();
			}else{
			    reversi.error(3);
			}
		    }
		    if(rBoard.win()){
			System.out.println(rBoard.getScores());                        
			System.out.println("Thanks for playing Reversi!");
			System.out.println();                         
			System.exit(0);
		    }
		}// while checker 1

		checker2 = true;

		while(checker2){
		    rBoard.validSpaces(hum2);
		    if(((HumanPlayer)hum2).userInput()){ // if user row/col is valid
			row = hum2.getRow(); // getting row
			col = hum2.getCol(); // getting col

			if(rBoard.validPlay(row,col)){ //checking to make sure you can move there
			    checker2 = false; 
			    rBoard.updateBoard(hum2,row,col);
			    rBoard.revertBoard();

  			}else{
			    reversi.error(3);
			}
		    }
		    if(rBoard.win()){
			System.out.println(rBoard.getScores());                        
			System.out.println("Thanks for playing Reversi!");
			System.out.println();                         
			System.exit(0);
		    }
		}// while checker 2
	    }else if(play ==2){ // human vs. computer
		Player hum = new HumanPlayer("X");
		Player com = new RandomComputerPlayer("O");

		checker1 = true;

		while(checker1){
		    rBoard.validSpaces(hum);
		    if(((HumanPlayer)hum).userInput()){
			row = hum.getRow();
			col = hum.getCol();

			if(rBoard.validPlay(row,col)){
			    checker1 = false;
			    rBoard.updateBoard(hum, row, col);
			    rBoard.revertBoard();
			}else{
			    reversi.error(3);
			}
		    }
		    if(rBoard.win()){
			System.out.println(rBoard.getScores());                       
			System.out.println("Thanks for playing Reversi!");
			System.out.println(); 
                        System.exit(0);
		    }
		}//while checker 1

		rBoard.validSpaces(com);
		System.out.print("Enter your move, Computer Player (O): ");
		checker2 = true;
		while(checker2){
		    ((RandomComputerPlayer)com).run();
		    row = com.getRow();
		    col = com.getCol();

		    if(rBoard.validPlay(row,col)){
			checker2 = false;
			try{
			    Thread.sleep(1500);
			    System.out.print(row+1 + " ");

			    Thread.sleep(1500);
			    System.out.print(col+1);
			    System.out.println();

			    Thread.sleep(700);

			}catch(Exception e){
			}
			rBoard.updateBoard(com,row,col);
			rBoard.revertBoard();
		    }
		    if(rBoard.win()){
			System.out.println(rBoard.getScores());
			System.out.println("Thanks for playing Reversi!");
			System.out.println();
			System.exit(0);	
		    }
		}//while checker 2
	    }else if(play == 3){ // computer vs. computer
	    

		Player com1 = new RandomComputerPlayer("X");
		Player com2 = new RandomComputerPlayer("O");
	
		checker1 = true;		

		rBoard.validSpaces(com1);
		System.out.print("Enter your move, Computer 1(X): ");

		while(checker1){
		    ((RandomComputerPlayer)com1).run();	    
		    row = com1.getRow();
		    col= com1.getCol();

		    if(rBoard.validPlay(row,col)){
			checker1 = false;
			try{
			    Thread.sleep(1500);
			    System.out.print(row+1 + " ");
			    
			    Thread.sleep(1500);
			    System.out.print(col+1);
			    System.out.println();
			    
			    Thread.sleep(700);

			}catch(Exception a){
			}
			rBoard.updateBoard(com1,row,col);
			rBoard.revertBoard();
		    }
		    if(rBoard.win()){
			System.out.println(rBoard.getScores());
			System.out.println("Thanks for playing Reversi!");
			System.out.println();
			System.exit(0);
		    }
		}// while checker 1

		checker2 = true;

		rBoard.validSpaces(com2);
		System.out.print("Enter your move, Computer 2(O): ");
		while(checker2){
		    ((RandomComputerPlayer)com2).run();
		    row = com2.getRow();
		    col = com2.getCol();

		    if(rBoard.validPlay(row,col)){
			checker2 = false;

			try{
			    Thread.sleep(1500);
			    System.out.print(row+1 + " ");

			    Thread.sleep(1500);
			    System.out.print(col+1);
			    System.out.println();
	
			    Thread.sleep(700);

			}catch(Exception a){
			}
			rBoard.updateBoard(com2,row,col);
			rBoard.revertBoard();
		    }

		    if(rBoard.win()){
			System.out.println(rBoard.getScores());
			System.out.println("Thanks for playing Reversi!");
			System.out.println();
			System.exit(0);
		    }
		}// while checker 2
	    
		//		game = false; // erase this before turning in, stops the game until all methods are complete
	    }	
	}while(game);
    }// main	
}// reversi