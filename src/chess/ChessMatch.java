package chess;

import boardgame.Board;

// É aqui que teremos as regras do jogo.

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] matPieces = new ChessPiece[board.getRows()][board.getColumns()];
		// Percorrer a matriz de peças no tabuleiro (board).
		// Para cada peça, fazer um downcast para ChessPiece.
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				matPieces[i][j] = (ChessPiece) board.piece(i, j);
				// Downcasting para interpretar como
				// Peça de Xadrez e não como peça comum.
			}
		}

		return matPieces;
	}
}
