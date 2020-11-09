
public class Square {
	
	private Coordinate coordinate;
	private Piece piece;

	Square(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	Square(Coordinate coordinate, Piece piece) {
		this.coordinate = coordinate;
		this.piece = piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public boolean isEmpty() {
		return this.piece == null;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void printCoordinate() {
		System.out.print(coordinate.getPriteableCoordinate());
		// System.out.print(coordinate.getColumn());
	}

	public void removePiece() {
		this.piece = null;
	}



}
