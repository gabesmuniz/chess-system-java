package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

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

	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
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
	
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> capWhite = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> capBlack = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		
		System.out.println("Captured Pieces:");
		
		System.out.print("WHITE: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(capWhite.toArray())); //Padrão para imprimir lista de valores.
		System.out.print(ANSI_RESET);
		
		System.out.print("BLACK: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(capBlack.toArray()));
		System.out.print(ANSI_RESET);
	}
}
