
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
	
	protected boolean isPawn() {
		return true;
	}
	
	@Override
	public boolean isValidMoveRule(Coordinate origin, Coordinate destination) {
		return origin.hasOneStepVerticalDirectionWith(destination) 
				&& !moveBack(origin, destination);
	}
	
	private boolean moveBack(Coordinate origin, Coordinate destination) {
		if(this.getColor().equals(Color.WHITE)) {
			return destination.getRow()-origin.getRow()<0;
		} else {
			return destination.getRow()-origin.getRow()>0;
		}
	}
}
