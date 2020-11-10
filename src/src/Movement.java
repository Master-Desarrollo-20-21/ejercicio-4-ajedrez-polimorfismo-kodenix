
public class Movement {

	private Coordinate origin;
	private Coordinate destination;

	public Movement(Coordinate origin, Coordinate destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public MatchResult complete(Board board, Color colorPlayer) {
		Square squareOrigin = board.getSquare(origin);
		Color colorOriginPiece = squareOrigin.getColorPiece();
		
		if (squareOrigin.isEmpty() || colorOriginPiece != colorPlayer) {
			return MatchResult.INVALID;
		}

		Square squareDestination = board.getSquare(destination);

		if (!squareDestination.isEmpty()
				&& colorOriginPiece == squareDestination.getColorPiece()) {
			return MatchResult.INVALID;
		}

		if (!squareOrigin.getPiece().isValidRuleMove(origin, destination)) {
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
