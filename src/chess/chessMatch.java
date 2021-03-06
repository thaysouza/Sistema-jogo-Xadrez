package chess;

import boardgame.Position;
import boardgame.Board;
import boardgame.Piece;
import chess.pieces.King;
import chess.pieces.Rook;

public class chessMatch {
	
	private Board board;
	
	public chessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	
	//retorna uma matriz de pe?as de xadrez corresponde a partida chessMatch 
	public chessPiece[][] getPieces(){
		chessPiece[][] mat = new chessPiece[board.getRows()][board.getColumns()];
		
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (chessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	public chessPiece performChessMove(chessPosition sourcePosition, chessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (chessPiece)capturedPiece;
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	private void placeNewPiece(char column, int row, chessPiece piece) {
		board.placePiece(piece, new chessPosition(column, row).toPosition());
	}
	
	private void initialSetup(){
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}

}
