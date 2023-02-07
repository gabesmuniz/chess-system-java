package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			userInterface.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = userInterface.readChessPosition(scan);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = userInterface.readChessPosition(scan);
		
			ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);		}
	}
}
