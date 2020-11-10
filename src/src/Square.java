
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
	

	public void clean() {
		setPiece(null);
	}

	public void moveCotainedPieceTo(Square squareDestination) {
		squareDestination.setPiece(this.piece);
		this.clean();
	}

	public boolean containKing() {
		return getPiece().isKing();
	}

	public Color getColorPiece() {
		return getPiece().getColor();
	}



}
