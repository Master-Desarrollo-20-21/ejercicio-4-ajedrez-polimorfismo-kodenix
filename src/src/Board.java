import java.util.Map;

public class Board {

	final int NUM_PLAYER_ROWS_FOR_PIECE = 2;
	final int NUM_PLAYER_COLUMNS_FOR_PIECE = 8;
	
	Square[][] squares = new Square[8][8];

	public Board() {
		this.generateSquares();
	}

	public void placePieces(Map<Color, Piece[]> colorPieces) {
			
		for (Color color: colorPieces.keySet()) {
			
			Piece[] pieceColection = colorPieces.get(color);		
			int pieceIndex = 0;
			final int auxiliarRowIncrement = color.getAuxiliarRowIncrement();

			for (int i=0, rowNumber = color.getInitialRowNumber(); i < NUM_PLAYER_ROWS_FOR_PIECE; i++, rowNumber+=auxiliarRowIncrement) {

				for (int j=0; j < NUM_PLAYER_COLUMNS_FOR_PIECE; j++, pieceIndex++) {
					Square square = this.getSquare(new Coordinate(rowNumber, j));
					square.putPiece(pieceColection[pieceIndex]);	
				}
			}
		}
	
	}

	private void generateSquares() {
		for (int i=0; i < squares.length; i++) {
			for (int j=0; j < squares[i].length; j++) {
				squares[i][j] = new Square(new Coordinate(i, j));
			}
		}
		
	}		
	
	public Square getSquare(Coordinate coordinate) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()];
	}

	public void show() {
		printColumHeadBoard();
		
		for (int i=squares.length-1; i >= 0 ; i--) {
			System.out.print(i+1);
			System.out.print(" | ");
			for (int j=0; j < squares[i].length; j++) {
				
				Square square = squares[i][j];
				if (square.isEmpty()) {
					System.out.print("  ");
				} else {
					System.out.print(square.getPiece().getFigure());
					System.out.print(" ");
				}
				System.out.print(" | ");
			}
			
			System.out.print(i+1);
			System.out.println("");
			System.out.println("----------------------------------------------");
		}
		
		printColumnFooterBoard();
	}

	private void printColumnFooterBoard() {
		this.printColumHeadBoard();
		
	}

	private void printColumHeadBoard() {
		System.out.print("  | ");
		for (int i=0; i < 8; i++) {
			System.out.print(Coordinate.columnsSimbol.get(i));
			System.out.print("  | ");
			
		}
		System.out.println("");
		System.out.println("----------------------------------------------");
		
	}

}
