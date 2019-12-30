package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		// O tamanho desta matriz será a quantidade de linhas e colunas do Board
		// Por isso usamos os gets.
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
				// Downcast para chesspiece / precisa ser interpretado como uma peça de xadrez
				// E não uma peça genérica.
			}
		}
		return mat;
	}
}
