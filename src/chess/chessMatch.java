package chess;

import boardgame.Board;

public class chessMatch {
	
	private Board board;
	
	public chessMatch() {
		board = new Board(8,8);
	}
	
	
	//retorna uma matriz de pe�as de xadrez corresponde a partida chessMatch 
	public chessPiece[][] getPieces(){
		chessPiece[][] mat = new chessPiece[board.getRows()][board.getColumns()];
		
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (chessPiece) board.piece(i,j);
			}
		}
		return mat;
	}

}
