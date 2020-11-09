
public class Queen extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2655";
	public static final String UNICODE_PIECE_BLACK = "\u265B";
	
	Queen(Player player) {
		super(player);
		
		String unicodePiece = Queen.UNICODE_PIECE_WHITE;
		if (player.getColor() == Color.BLACK) {
			unicodePiece = Queen.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[1];
 		
		if (this.getPlayer().getColor() == Color.WHITE) {
			coordinates[0] = new Coordinate('1', 'd');
		} else {
			coordinates[0] = new Coordinate('8', 'd');
		}
		
		return coordinates;
		
	}
	
	
	
}
