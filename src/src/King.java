
public class King extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2654";
	public static final String UNICODE_PIECE_BLACK = "\u265A";
	
	King(Color color) {
		super(color);
		
		String unicodePiece = King.UNICODE_PIECE_WHITE;
		if (color == Color.BLACK) {
			unicodePiece = King.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[1];
 		
		if (this.getColor() == Color.WHITE) {
			coordinates[0] = new Coordinate('1', 'e');
		} else {
			coordinates[0] = new Coordinate('8', 'e');
		}
		
		return coordinates;
	}
	
	@Override
	public boolean isValidRuleMove(Coordinate origin, Coordinate destination) {
		return origin.isHorizontalDirectionOneStep(destination) || origin.isVerticalDirectionOneStep(destination)
				|| origin.isDiagonalDirectionOneStep(destination);
	}

	@Override
	protected boolean isKing() {
		return true;
	}
	
	
}
