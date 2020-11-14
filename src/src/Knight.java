
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
		return origin.isSameDiferenceSteeps(origin.getRow(), destination.getRow(), 1) && origin.isSameDiferenceSteeps(origin.getColumn(), destination.getColumn(), 2)
				|| origin.isSameDiferenceSteeps(origin.getRow(), destination.getRow(), 2) && origin.isSameDiferenceSteeps(origin.getColumn(), destination.getColumn(), 1);
	}
	
	@Override
	protected boolean isKnight() {
		return true;
	}
	
}
