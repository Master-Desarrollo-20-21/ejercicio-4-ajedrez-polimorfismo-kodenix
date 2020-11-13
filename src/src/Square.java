
public class Square {
	
	private Coordinate coordinate;
	private Piece piece;

	Square(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void putPiece(Piece piece) {
		this.piece = piece;
	}
	
	public boolean isEmpty() {
		return this.piece == null;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void clean() {
		putPiece(null);
	}

	public void moveCotainedPieceTo(Square squareDestination) {
		squareDestination.putPiece(this.piece);
		this.clean();
	}

	public boolean containKing() {
		return this.getPiece().isKing();
	}

	public boolean isValidMoveRuleForContainedPiece(Coordinate origin, Coordinate destination) {
		return this.getPiece().isValidMoveRule(origin, destination);
	}

}
