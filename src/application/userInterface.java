package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class userInterface {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	// Mudar cores em terminal colorido, como o Gitbash.
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	//Limpar tela.
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ChessPosition readChessPosition(Scanner scan) {
		try {
			String s = scan.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		} catch (RuntimeException except) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8!");
		}
	}

	public static void printBoard(ChessPiece pieces[][]) {
		// Percorrer linhas e colunas imprimindo-as.
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false); // Não destaca.
			}
			// Quebra de linha para imprimir a próxima.
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}
	
	public static void printBoard(ChessPiece pieces[][], boolean[][] possibleMoves) {
		// Percorrer linhas e colunas imprimindo-as.
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]); // Destaca BG pois matrix tem os valores V e F
			}
			// Quebra de linha para imprimir a próxima.
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}

	// Método auxiliar para imprimir cada peça.
	private static void printPiece(ChessPiece piece, boolean background) {
		//Destaca o background caso seja verdadeira.
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		// Se não houver peça nessa posição, imprima "-" (traço).
		if (piece == null) {
			System.out.print("-" + ANSI_RESET);
		} else {// Se houver, imprima a devida peça.
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
}
