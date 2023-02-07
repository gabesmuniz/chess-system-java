package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	// Parecido com métodos padrões (mais à frente em Interfaces)
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	// Varre a matriz. (Implementação padrão
	// Que depende de um método abstrato).
	public boolean isThereAnyPossibleMove() {
		boolean[][] matPossible = possibleMoves();
		for (int i = 0; i < matPossible.length; i++) {
			for (int j = 0; j < matPossible.length; j++) {
				if (matPossible[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
