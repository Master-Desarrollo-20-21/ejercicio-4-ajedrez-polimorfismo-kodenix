
public class Rook extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2656";
	public static final String UNICODE_PIECE_BLACK = "\u265C";
	
	Rook(Player player) {
		super(player);
		
		String unicodePiece = Rook.UNICODE_PIECE_WHITE;
		if (player.getColor() == Color.BLACK) {
			unicodePiece = Rook.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[2];
 		
		if (this.getPlayer().getColor() == Color.WHITE) {
			
			coordinates[0] = new Coordinate('1', 'a');
			coordinates[1] = new Coordinate('1', 'h');
		
		} else {
			
			coordinates[0] = new Coordinate('8', 'a');
			coordinates[1] = new Coordinate('8', 'h');
			
		}
		
		return coordinates;
	}
	
	
}
