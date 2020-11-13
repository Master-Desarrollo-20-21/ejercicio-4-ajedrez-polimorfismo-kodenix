
public class Rook extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2656";
	public static final String UNICODE_PIECE_BLACK = "\u265C";
	
	Rook(Color color) {
		super(color);
		
		String unicodePiece = Rook.UNICODE_PIECE_WHITE;
		if (color == Color.BLACK) {
			unicodePiece = Rook.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}
	
	@Override
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return origin.hasHorizontalDirectionWith(destination) || origin.hasVerticalDirectionWith(destination);
	}
	
	
}
