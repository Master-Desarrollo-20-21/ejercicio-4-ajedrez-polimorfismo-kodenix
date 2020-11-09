
public class Knight extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2658";
	public static final String UNICODE_PIECE_BLACK = "\u265E";
	
	Knight(Player player) {
		super(player);
		
		String unicodePiece = Knight.UNICODE_PIECE_WHITE;
		if (player.getColor() == Color.BLACK) {
			unicodePiece = Knight.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[2];
 		
		if (this.getColor() == Color.WHITE) {
			coordinates[0] = new Coordinate('1', 'b');
			coordinates[1] = new Coordinate('1', 'g');
		} else {
			coordinates[0] = new Coordinate('8', 'b');
			coordinates[1] = new Coordinate('8', 'g');
		}
		
		return coordinates;
	}
	
	@Override
	public boolean isValidRuleMove(Coordinate origin, Coordinate destination) {
		return true;
	}
	
	
}
