
public class Movement {

	private Coordinate origin;
	private Coordinate destination;

	public Movement(Coordinate origin, Coordinate destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public MatchResult performe(Board board, Color colorPlayer) {
		if (thereIsPiece(board)) {
			return MatchResult.INVALID;
		}		
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
		} 

		if (squareDestination.isEmpty()) {
			squareOrigin.moveCotainedPieceTo(squareDestination);
			return MatchResult.EMPTY_SQUARE;
		} else {
			if (squareDestination.containKing()) {
				squareOrigin.moveCotainedPieceTo(squareDestination);
				return MatchResult.CHECKMATE;
			} else {
				squareOrigin.moveCotainedPieceTo(squareDestination);
				return MatchResult.CAPTURE;
			}
		}

	}
	
	public boolean thereIsPiece(Board board) {
		if (board.getSquare(origin).getPiece().isKnight()) {
			return false;
		}
		
		if (destination.getColumn() - origin.getColumn()<=1 && destination.getRow()-origin.getRow()<=1) {
			return false;
		} 
		
		int columnIncrement, rowIncrement;
		if (destination.getColumn() == origin.getColumn()) {
			columnIncrement=0;
		} else {
			columnIncrement=Math.abs(destination.getColumn()-origin.getColumn())/(destination.getColumn()-origin.getColumn());
		}
		
		if (destination.getRow()==origin.getRow()) {
			rowIncrement=0;
		} else {
			rowIncrement=Math.abs(destination.getRow()-origin.getRow())/(destination.getRow()-origin.getRow());
		}
		
		int row=origin.getRow()+rowIncrement;
		int column=origin.getColumn()+columnIncrement;
		while (row!=destination.getRow() || column!=destination.getColumn()) {
			Square square=board.getSquare(new Coordinate(row, column));
			if (!square.isEmpty()) {
				return true;
			}
			row+=rowIncrement;
			column+=columnIncrement;
		}
		return false;
	}

}
