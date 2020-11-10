
public class Movement {

	private Coordinate origin;
	private Coordinate destination;
	private Board board;
	private Color colorPlayer;

	public Movement(Coordinate[] coordinates, Board board, Color colorPlayer) {
		this.origin = coordinates[0];
		this.destination = coordinates[1];
		this.board = board;
		this.colorPlayer = colorPlayer;
	}

	public MatchResult getResult() {
		Square squareOrigin = board.getSquare(origin);
		
		if (squareOrigin.isEmpty() || squareOrigin.getColorPiece() != colorPlayer) {
			return MatchResult.INVALID;
		}
		
		if (squareOrigin.isEmpty() || squareOrigin.getColorPiece() != colorPlayer) {
			return MatchResult.INVALID;
		}

		Square squareDestination = board.getSquare(destination);

		if (!squareDestination.isEmpty()
				&& squareOrigin.getColorPiece() == squareDestination.getColorPiece()) {
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
