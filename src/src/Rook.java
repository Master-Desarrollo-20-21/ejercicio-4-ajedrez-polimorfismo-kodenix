
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
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[2];
 		
		if (this.getColor() == Color.WHITE) {
			
			coordinates[0] = new Coordinate('1', 'a');
			coordinates[1] = new Coordinate('1', 'h');
		
		} else {
			
			coordinates[0] = new Coordinate('8', 'a');
			coordinates[1] = new Coordinate('8', 'h');
			
		}
		
		return coordinates;
	}
	
	@Override
	public boolean isValidRuleMove(Coordinate origin, Coordinate destination) {
		return origin.isHorizontalDirection(destination) || origin.isVerticalDirection(destination);
	}
	
	
}
