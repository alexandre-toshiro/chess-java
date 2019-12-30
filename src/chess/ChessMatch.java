package chess;

import boardgame.Board;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		// Recebe as coordenadas do xadrez e converte para as de matriz
	}

	private void initialSetup() {
		// Com as posições do xadrez.
		placeNewPiece('b', 6, new Torre(board, Color.WHITE));
		placeNewPiece('e', 8, new Rei(board, Color.BLACK));
	}
}
