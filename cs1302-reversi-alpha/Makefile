
com: 
	javac -d . Reversi.java
comb: 
	javac -d . Board.java
	javac -d . ReversiBoard.java

comp: 

	javac -d . Player.java
	javac -d . HumanPlayer.java

comc:
	javac -d . ComputerPlayer.java
	javac -d . RandomComputerPlayer.java

comall:
	javac -d . RandomComputerPlayer.java
	javac -d . ComputerPlayer.java
	javac -d . HumanPlayer.java
	javac -d . Player.java
	javac -d . ReversiBoard.java
	javac -d . Board.java
	javac -d . Reversi.java

target: com

runh: target
	java -cp . cs1302.p2.Reversi human human

run: target
	java -cp . cs1302.p2.Reversi human RandomComputerPlayer

runc: target
	java -cp . cs1302.p2.Reversi RandomComputerPlayer RandomComputerPlayer