
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
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return origin.hasOneStepHorizontalDirectionWith(destination) || origin.hasOneStepVerticalDirectionWith(destination)
				|| origin.hasOneStepDiagonalDirectionWith(destination);
	}

	@Override
	protected boolean isKing() {
		return true;
	}
	
	
}
