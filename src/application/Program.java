package application;

import java.util.Scanner;

import boardgame.Board;
import chess.chessMatch;
import chess.chessPiece;
import chess.chessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
     
		chessMatch ChessMatch = new chessMatch();
		
		while (true) {
		UI.printBoard(ChessMatch.getPieces());
		
		System.out.println();
		System.out.println("Source: ");
		chessPosition source = UI.readChessPosition(sc);
		
		System.out.println();
		System.out.println("Target: ");
		chessPosition target = UI.readChessPosition(sc);
		
		chessPiece capturedPiece = ChessMatch.performChessMove(source,target);
		}
	
	}

}
