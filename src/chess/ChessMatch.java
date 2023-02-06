package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

// É aqui que teremos as regras do jogo.

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] matPieces = new ChessPiece[board.getRows()][board.getColumns()];
		// Percorrer a matriz de peças no tabular (board).
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position (2,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));

	}
}
