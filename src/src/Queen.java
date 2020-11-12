
public class Queen extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2655";
	public static final String UNICODE_PIECE_BLACK = "\u265B";
	
	Queen(Color color) {
		super(color);
		
		String unicodePiece = Queen.UNICODE_PIECE_WHITE;
		if (color == Color.BLACK) {
			unicodePiece = Queen.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}
	
	@Override
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return origin.hasHorizontalDirectionWith(destination) || origin.hasVerticalDirectionWith(destination) ||
				origin.hasDiagonalDirectionWith(destination);
	}
	
	
	
}
