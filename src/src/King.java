
public class King extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2654";
	public static final String UNICODE_PIECE_BLACK = "\u265A";
	
	King(Player player) {
		super(player);
		
		String unicodePiece = King.UNICODE_PIECE_WHITE;
		if (player.getColor() == Color.BLACK) {
			unicodePiece = King.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[1];
 		
		if (this.getPlayer().getColor() == Color.WHITE) {
			coordinates[0] = new Coordinate('1', 'e');
		} else {
			coordinates[0] = new Coordinate('8', 'e');
		}
		
		return coordinates;
	}
	
	
}
