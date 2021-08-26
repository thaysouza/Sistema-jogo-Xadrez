package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.chessMatch;
import chess.chessPiece;
import chess.chessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
     
		chessMatch ChessMatch = new chessMatch();
		
		
		
		try {
			UI.clearScreen();
			UI.printBoard(ChessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			chessPosition source = UI.readChessPosition(sc);

			System.out.println();
			System.out.print("Target: ");
			chessPosition target = UI.readChessPosition(sc);

			chessPiece capturedPiece = ChessMatch.performChessMove(source, target);
		}
		catch (ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
	
	}

}

















