
public class Pawn extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2659";
	public static final String UNICODE_PIECE_BLACK = "\u265F";
	
	Pawn(Color color) {
		super(color);
		
		String unicodePiece = Pawn.UNICODE_PIECE_WHITE;
		if (color == Color.BLACK) {
			unicodePiece = Pawn.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}
	
	@Override
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return origin.hasOneStepVerticalDirectionWith(destination);
	}
	
	
}
