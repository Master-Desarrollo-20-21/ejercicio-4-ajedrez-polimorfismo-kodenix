
public class Movement {

	private Coordinate origin;
	private Coordinate destination;

	public Movement(Coordinate origin, Coordinate destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public MatchResult performe(Board board, Color colorPlayer) {
				
		Square squareOrigin = board.getSquare(origin);
		Square squareDestination = board.getSquare(destination);		
		
		if (squareOrigin.isEmpty()) {
			return MatchResult.INVALID;
		}

		if (!squareOrigin.isEmpty() && squareOrigin.getPiece().getColor() != colorPlayer) {
			return MatchResult.INVALID;
		}

		if (!squareDestination.isEmpty() && squareOrigin.getPiece().getColor() == squareDestination.getPiece().getColor()) {
			return MatchResult.INVALID;
		}

		if (!squareOrigin.isValidMoveRuleForContainedPiece(origin, destination)) {
			return MatchResult.INVALID;
		} else {

			squareOrigin.moveCotainedPieceTo(squareDestination);
			
			if (squareDestination.isEmpty()) {
				return MatchResult.EMPTY_SQUARE;
			} else {
				if (squareDestination.containKing()) {
					return MatchResult.CHECKMATE;
				} else {
					return MatchResult.CAPTURE;
				}

			}

		}
	}

}
