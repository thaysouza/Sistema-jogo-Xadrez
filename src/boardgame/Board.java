package boardgame;

public class Board {
	
	private int  rows;
	private int columns;
	private Piece[][] pieces;
	
	
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1){
			throw new BoardException("Erro criando o tabuleiro: É necessário que tenha pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}



	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	//retorna a peça que tem na matriz na posição passada
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
     //se já exisitr uma peça na posição recebida não colocar outra peça no lugar
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on pistion " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//verificando se uma  posicao existe 
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//verificando se existe peça na posição que foi passada e retornando o resultado
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	
	

}
