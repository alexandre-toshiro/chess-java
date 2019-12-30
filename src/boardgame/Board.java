package boardgame;

// DP - defensive programming
public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		// A quantidade de linhas e colunas tem que de ser de pelo menos 1. DP
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		// Antes de acessar, verifica se a posi��o existe. DP
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board!");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		// Antes de acessar, verifica se a posi��o existe. DP
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		// Antes de colocar uma pe�a na posi��o, verifica se ali j� existe outra pe�a.
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		// Atribui uma pe�a na posi��o informada.
		piece.position = position;
		// � � mais uma posi��o nula, devendo ser atribuida uma posi��o.
	}

	private boolean positionExists(int row, int column) {
		// M�todo aux�liar, alguns momento ser� mais f�cil testar pela linha/coluna.
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		return piece(position) != null;
	}
}
