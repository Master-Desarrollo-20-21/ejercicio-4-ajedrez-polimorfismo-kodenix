
public class Movement {


	private MatchResult matchResult;

	public Movement(Coordinate origin, Coordinate destination, Board board, Player player) {
		Square squareOrigin = board.getSquare(origin);
		if (squareOrigin.isEmpty() || squareOrigin.getPiece().getPlayer().getColor() != player.getColor()) {
			this.matchResult = MatchResult.INVALID;
			return;
		}

		Square squareDestination = board.getSquare(destination);

		if (squareDestination.isEmpty()) {
			squareDestination.removePiece();
			squareDestination.setPiece(squareOrigin.getPiece());
			squareOrigin.removePiece();
			this.matchResult = MatchResult.EMPTY_SQUARE;
			return;
		}

		if (!squareDestination.isEmpty() 
		&& squareOrigin.getPiece().getPlayer().getColor() == squareDestination.getPiece().getPlayer().getColor()) {
			
			this.matchResult = MatchResult.INVALID;
			return;
		} 

		if (!squareOrigin.getPiece().isValidDestination(destination)) {
			this.matchResult = MatchResult.INVALID;
			return;
		} else {

			squareDestination.removePiece();
			squareDestination.setPiece(squareOrigin.getPiece());
			squareOrigin.removePiece();
		}

		
	}

	public MatchResult getResult() {
		// TODO Auto-generated method stub
		return this.matchResult;
	}

}
