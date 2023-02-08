package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxP = new Position(0, 0);
		
		// ABOVE (Marcar como verdadeiras as
		// Possíveis posições ACIMA da peça
		auxP.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
			auxP.setRow(auxP.getRow() - 1);
		}
		
		if (getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// LEFT (Marcar como verdadeiras as
		// Possíveis posições a ESQUERDA da peça
		auxP.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
			auxP.setColumn(auxP.getColumn() - 1);
		}
		
		if (getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// RIGHT (Marcar como verdadeiras as
		// Possíveis posições a DIREITA da peça
		auxP.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
			auxP.setColumn(auxP.getColumn() + 1);
		}
		
		if (getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// BELOW (Marcar como verdadeiras as
		// Possíveis posições ABAIXO da peça
		auxP.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
			auxP.setRow(auxP.getRow() + 1);
		}
		
		if (getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		return mat;
	}
}
