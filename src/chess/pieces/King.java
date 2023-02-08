package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece auxPiece = (ChessPiece)getBoard().piece(position);
		return auxPiece == null || auxPiece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxP = new Position(0,0);
		
		// ABOVE
		auxP.setValues(position.getRow() -1, position.getColumn());
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// ABOVE RIGHT (NE)
		auxP.setValues(position.getRow() -1, position.getColumn() +1);
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// ABOVE LEFT (NW)
		auxP.setValues(position.getRow() -1, position.getColumn() -1);
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// BELOW
		auxP.setValues(position.getRow() +1, position.getColumn());
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// BELOW RIGHT (SE)
		auxP.setValues(position.getRow() +1, position.getColumn() +1);
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// BELOW LEFT (SW)
		auxP.setValues(position.getRow() +1, position.getColumn() -1);
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// RIGHT
		auxP.setValues(position.getRow(), position.getColumn() +1);
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		// LEFT
		auxP.setValues(position.getRow(), position.getColumn() -1);
		if (getBoard().positionExists(auxP) && canMove(auxP)) {
			mat[auxP.getRow()][auxP.getColumn()] = true;
		}
		
		return mat;
	}
}
