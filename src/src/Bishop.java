
public class Bishop extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2657";
	public static final String UNICODE_PIECE_BLACK = "\u265D";
	
	Bishop(Color color) {
		super(color);
		
		String unicodePiece = Bishop.UNICODE_PIECE_WHITE;
		if (color == Color.BLACK) {
			unicodePiece = Bishop.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}
	
	@Override
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return origin.hasDiagonalDirectionWith(destination);
	}
	
	
}
