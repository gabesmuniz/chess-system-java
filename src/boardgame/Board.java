package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error: creating board: there must be at least 1 row and 1 column!");
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
		if (!positionExists(row, column)) {
			throw new BoardException("This position doens't exist on this board!");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("This position doens't exist on this board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	//Colocar Peça.
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Remover Peça.
	public Piece removePiece(Position position) {
		if (!positionExists(position)) { //Testa se a posição exsite.
			throw new BoardException("Position not on the board.");		
		}
		if (piece(position) == null) {
			return null;
		}
		Piece pAux = piece(position);
		pAux.position = null; //Peça auxiliar que não está no board.
		pieces[position.getRow()][position.getColumn()] = null;
		return pAux; //A matriz (tabuleiro) recebe valor nulo
					 //Na posição onde a peça será removida.
	}
	

	// Posição existe quando ela cabe no tabuleiro.
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	// Se campo da peça na matriz é diferente de nulo, há uma peça.
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("This position doens't exist on this board!");
		}
		return piece(position) != null;
	}

}
