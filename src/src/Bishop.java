
public class Bishop extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2657";
	public static final String UNICODE_PIECE_BLACK = "\u265D";
	
	Bishop(Player player) {
		super(player);
		
		String unicodePiece = Bishop.UNICODE_PIECE_WHITE;
		if (player.getColor() == Color.BLACK) {
			unicodePiece = Bishop.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[2];
 		
		if (this.getColor() == Color.WHITE) {
			coordinates[0] = new Coordinate('1', 'c');
			coordinates[1] = new Coordinate('1', 'f');
		} else {
			coordinates[0] = new Coordinate('8', 'c');
			coordinates[1] = new Coordinate('8', 'f');
		}
		
		return coordinates;
	}
	
	@Override
	public boolean isValidRuleMove(Coordinate origin, Coordinate destination) {
		return origin.isDiagonalDirection(destination);
	}
	
	
}
