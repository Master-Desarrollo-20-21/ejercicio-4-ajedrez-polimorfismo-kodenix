
public class Pawn extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2659";
	public static final String UNICODE_PIECE_BLACK = "\u265F";
	
	Pawn(Player player) {
		super(player);
		
		String unicodePiece = Pawn.UNICODE_PIECE_WHITE;
		if (player.getColor() == Color.BLACK) {
			unicodePiece = Pawn.UNICODE_PIECE_BLACK;
		}
		this.setUnicodePiece(unicodePiece);
	}

	@Override
	public Coordinate[] getDefaultCoordinates() {
		
		Coordinate[] coordinates = new Coordinate[8];
 		
		if (this.getColor() == Color.WHITE) {
			
			coordinates[0] = new Coordinate('2', 'a');
			coordinates[1] = new Coordinate('2', 'b');
			coordinates[2] = new Coordinate('2', 'c');
			coordinates[3] = new Coordinate('2', 'd');
			coordinates[4] = new Coordinate('2', 'e');
			coordinates[5] = new Coordinate('2', 'f');
			coordinates[6] = new Coordinate('2', 'g');
			coordinates[7] = new Coordinate('2', 'h');
		
		} else {
			
			coordinates[0] = new Coordinate('7', 'a');
			coordinates[1] = new Coordinate('7', 'b');
			coordinates[2] = new Coordinate('7', 'c');
			coordinates[3] = new Coordinate('7', 'd');
			coordinates[4] = new Coordinate('7', 'e');
			coordinates[5] = new Coordinate('7', 'f');
			coordinates[6] = new Coordinate('7', 'g');
			coordinates[7] = new Coordinate('7', 'h');
			
		}
		
		return coordinates;
	}
	
	@Override
	public boolean isValidRuleMove(Coordinate origin, Coordinate destination) {
		return RuleMove.isHorizontalOneStep(origin, destination) || RuleMove.isVerticalOneStep(origin, destination);
	}
	
	
}
