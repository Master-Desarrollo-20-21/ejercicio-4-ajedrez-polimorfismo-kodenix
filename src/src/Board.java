
public class Board {
	
	Square[][] squares = new Square[8][8];

	public Board() {
		this.generateSquares();
	}

	public void placePieces(Piece[] pieces) {
		this.placePiecesOnSquare(pieces);
	}

	private void generateSquares() {
		for (int i=0; i < squares.length; i++) {
			for (int j=0; j < squares[i].length; j++) {
				Coordinate coordinate = new Coordinate(i, j);
				squares[i][j] = new Square(coordinate);
			}
		}
		
	}
	
	private void placePiecesOnSquare(Piece[] pieces) {
		for (int i=0; i < pieces.length; i++) {
			Coordinate[] coordinates = pieces[i].getDefaultCoordinates();
			for (int j=0; j < coordinates.length; j++) {
				Square square = this.getSquare(coordinates[j]);
				if (!pieces[i].isPlacedOnboard() && square.isEmpty()) {
					square.setPiece(pieces[i]);
				}
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
					//System.out.print("  ");
					// square.printCoordinate();
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
