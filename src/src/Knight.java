
public class Knight extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2658";
	public static final String UNICODE_PIECE_BLACK = "\u265E";
	
	Knight(Color color) {
		super(color);
		
		String unicodePiece = Knight.UNICODE_PIECE_WHITE;
		if (color == Color.BLACK) {
			unicodePiece = Knight.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}
	
	@Override
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return true;
	}
	
	
}
