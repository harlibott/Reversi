package cs1302.p2;

/**
 * <h1>ReversiBoard</h1>
 * A child class of Board that represents a
 * board specific to the game Reversi.
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-2
 */ 

public class ReversiBoard extends Board{

    String [][] openSpaces;
    String [][] board = new String [8][8];
    String playerName;
    int row;
    int col;
    int totalMoves;
    int xScore = 0;
    int oScore = 0;
  
    @Override
    boolean validPlay(int row, int col){
	if(board[row][col].equals("_ ")){		
	    this.row = row;
	    this.col = col;
	    return true;
	}else{
	    return false;
	}
    }//valid play check
    
    @Override
    void printBoard(){
	System.out.print(" ");
	for(int i = 1; i <= 8; i++){
	    System.out.print(" " + i);
	}
	System.out.println();
	for(int i = 0; i < 8; i++){
	    System.out.print(i+1 + " ");
	    for(int j = 0; j < 8; j ++){
		System.out.print(board[i][j]);
	    }
	    System.out.println();
	}
	System.out.println();
    }//print board from parent class
    
    @Override
    void initBoard(){
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		    this.board[i][j] = ". ";
     	    }// for
	}// for
	
	// sets the initial board at X and O
	this.board[3][3] = "X ";
	this.board[3][4] = "O ";
	this.board[4][3] = "O ";
	this.board[4][4] = "X ";
	this.board[2][4] = "_ ";
	this.board[3][5] = "_ ";
      	this.board[5][3] = "_ ";
       	this.board[4][2] = "_ ";
		
    }// initialzes board

    @Override
    void validSpaces(Player p){
	// System.out.println("Valid Player");
	totalMoves = 0;
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j< 8; j++){
		if(this.board[i][j].equals(p.getPlayerName())){
		    // System.out.println("if 1/3");
		    for(int r = i-1; r < i+2; r++){
			for(int c = j-1; c < j+2; c++){
			    if(p.validate(r,c) && this.board[r][c].equals(p.getOpponent())){
				// System.out.println("if 2/3");
				int addRow = r-i;
				int addCol = c-j;
				int changeRow = r;
				int changeCol = c;

				while(p.validate(changeRow, changeCol) && this.board[changeRow][changeCol].equals(p.getOpponent())){
				    changeRow += addRow;
				    changeCol += addCol;
				}// while

				if(p.validate(changeRow, changeCol)){
				    //  System.out.println("if 3/3");
				    if(this.board[changeRow][changeCol].equals(p.getPlayerName()) || this.board[changeRow][changeCol].equals(p.getOpponent())){
					//do nothing
				    }else{
					this.board[changeRow][changeCol] = "_ ";
					// System.out.println("last if");
					totalMoves ++;
				    }//if/else
				}//if
			    }// if
			}//for c
		    }//for r
		}//if
	    }//for j
	}//for i
	System.out.println();
	printBoard();
    }// updates the spaces availible to move
    
    @Override
    void updateBoard(Player p, int r, int c){

	int count;
	int rowS = r-1;
	int colS = c-1;
	int rowC = 0;
	int colC = 0;
	int row = 0;
	int col = 0;

	//	if(board[r][c].equals("_ ")){
	    board[r][c] = p.getPlayerName();
	    for(int i = 0; i < 3; i++){ // loops through 3 times to accoutn for row, col, diagonal
		colS = c-1;
		for(int j = 0; j < 3; j++){ 
		    rowC = rowS;
		    colC = colS;
		    
		    //System.out.println(rowC);
		    //System.out.println(colC);

		   
		    if((rowC >= 0 && rowC < 8) && (colC >= 0 && colC < 8) && board[rowC][colC].equals(p.getOpponent())){
			int addR = rowC -r;
			int addC = colC - c;
			row = rowC; // stores changed row
			col = colC; // stores changed column

			
			while((rowC >= 0 && rowC < 8) && (colC >= 0 && colC < 8) && !(board[rowC][colC].equals(". ")) && !(board[rowC][colC].equals("_ "))){
			    if(board[rowC][colC].equals(p.getPlayerName())){
				count = 1;
				rowC -= addR; // subtracts the changed row from the added row
				colC -= addC; // subtracts the changed col from the added col
				while(board[rowC][colC].equals(p.getOpponent())){
				    this.board[rowC][colC] = p.getPlayerName();
				    count ++; // increments count
				    rowC -= addR; // contiues subtracting the changed row from row
				    colC -= addC; // continues subtracting the changed col from col
				}//while
				rowC += addR * count;
				colC += addC * count;
				break;
			    }//if
			    rowC += addR;
			    colC += addC;			   
			}// while
		    }// if
		    colS ++; // increments starting col
		}//for j+= 
		rowS ++; // increments starting row
	    }// for i	   
    }//updateBoard
    
    @Override
    boolean win(){
	boolean win = false;
		if(totalMoves == 0){
		    win = true;
    		}else{
		    win = false;
		}
	return win;
    }// win

    @Override
    void revertBoard(){
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		if(this.board[i][j].equals("_ ")){
		    this.board[i][j] = ". ";
		}// if
	    }//for j
	}//for i
    }//revert

    @Override
    String getScores(){
	for(int i = 0; i < 8; i ++){
	    for(int j = 0; j < 8; j++){
		if(this.board[i][j].equals("X ")){
		    this.xScore ++;
		}else if(this.board[i][j].equals("O ")){
		    this.oScore ++;
		}
	    }
	}
	String s = "";
	s += "\n";
	s += "Player X Score: " + xScore + "\n";
	s += "Player O Score: " + oScore + "\n";
	s += "\n";

	if(xScore > oScore){
	    s+= "Player X Wins!!!";
	}else if(oScore > xScore){
	    s+= "Player O Wins!!!";
	}else if(oScore == xScore){
	    s+= "The game is a tie at " + xScore + "!!!\n";
	}
	return s;
    }//get scores

}// Board