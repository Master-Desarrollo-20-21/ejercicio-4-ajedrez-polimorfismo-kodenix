import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {
	
	Square[][] squares = new Square[8][8];

	public Board() {
		this.generateSquares();
		Map<Color, ArrayList<Piece>> pieces = this.createPieces();
		this.placePieces(pieces);
	}

	private void placePieces(Map<Color, ArrayList<Piece>> pieces) {
		
		for (Color color: pieces.keySet()) {
			
			ArrayList<Piece> pieceColection = pieces.get(color);
			
			for (Piece piece:pieceColection) {
				Coordinate[] coordinates = piece.getDefaultCoordinates();
				
				for (int j=0; j < coordinates.length; j++) {
					Square square = this.getSquare(coordinates[j]);
					if (!piece.isPlacedOnboard() && square.isEmpty()) {
						square.setPiece(piece);
					}
				}
			}
			
		}
		
		
	}
	
	private Map<Color, ArrayList<Piece>> createPieces() {
		Map<Color, ArrayList<Piece>> colorWithPieces = new HashMap<Color, ArrayList<Piece>>();

		for (Color color : Color.values()) {
			ArrayList<Piece> pieces=new ArrayList<Piece>();
			for (int i=0;i<8;i++) {
				pieces.add(new Pawn(color));
			}
			for (int i=0;i<2;i++) {
				pieces.add(new Rook(color));
				pieces.add(new Knight(color));
				pieces.add(new Bishop(color));
			}
			pieces.add(new Queen(color));
			pieces.add(new King(color));
			colorWithPieces.put(color, pieces);
		}

		return colorWithPieces;
	}
	

	private void generateSquares() {
		for (int i=0; i < squares.length; i++) {
			for (int j=0; j < squares[i].length; j++) {
				Coordinate coordinate = new Coordinate(i, j);
				squares[i][j] = new Square(coordinate);
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
			System.out.print((char) (i+Coordinate.ASCII_a));
			System.out.print("  | ");
			
		}
		System.out.println("");
		System.out.println("----------------------------------------------");
		
	}

}
