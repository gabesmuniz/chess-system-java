package application;

import chess.ChessPiece;

public class userInterface {

	public static void printBoard(ChessPiece pieces[][]) {
		// Percorrer linhas e colunas imprimindo-as.
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			// Quebra de linha para imprimir a próxima.
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}

	// Método auxiliar para imprimir cada peça.
	private static void printPiece(ChessPiece piece) {
		// Se não houver peça nessa posição, imprima "-" (traço).
		if (piece == null) {
			System.out.print("-");
		} else {// Se houver, imprima a devida peça.
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
