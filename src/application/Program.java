package application;

import boardgame.Board;
import chess.chessMatch;

public class Program {

	public static void main(String[] args) {
		
     
		chessMatch ChessMatch = new chessMatch();
		UI.printBoard(ChessMatch.getPieces());
	
	}

}
