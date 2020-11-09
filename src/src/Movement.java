
public class Movement {

	private Coordinate origin;
	private Coordinate destination;

	public Movement(Coordinate origin, Coordinate destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public MatchResult complete(Board board, Color colorPlayer) {
		Square squareOrigin = board.getSquare(origin);
		if (squareOrigin.isEmpty() || squareOrigin.getPiece().getColor() != colorPlayer) {
			return MatchResult.INVALID;
		}

		Square squareDestination = board.getSquare(destination);

		if (squareDestination.isEmpty()) {
			squareDestination.removePiece();
			squareDestination.setPiece(squareOrigin.getPiece());
			squareOrigin.removePiece();
			return MatchResult.EMPTY_SQUARE;
		}

		if (!squareDestination.isEmpty() 
		&& squareOrigin.getPiece().getColor() == squareDestination.getPiece().getColor()) {
			
			return MatchResult.INVALID;
			
		} 
		
		if (squareDestination.getPiece().isKing()) {
			return MatchResult.CHECKMATE;
		} 

		if (!squareOrigin.getPiece().isValidMove(origin, destination)) {
			return MatchResult.INVALID;
		} else {
			
			squareDestination.removePiece();
			squareDestination.setPiece(squareOrigin.getPiece());
			squareOrigin.removePiece();
			return MatchResult.CAPTURE;
		}
		
	}

}
