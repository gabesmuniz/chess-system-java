package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				userInterface.clearScreen();
				userInterface.printMatch(chessMatch);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = userInterface.readChessPosition(scan);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				userInterface.clearScreen();
				userInterface.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = userInterface.readChessPosition(scan);
			
				ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);
			}
			catch (ChessException except) {
				System.out.println(except.getMessage());
				System.out.println("Pres KEY to continue...");
				scan.nextLine();
			}
			catch (InputMismatchException except) {
				System.out.println(except.getMessage());
				System.out.println("Pres KEY to continue...");
				scan.nextLine();
			}
					
		}
	}
}

