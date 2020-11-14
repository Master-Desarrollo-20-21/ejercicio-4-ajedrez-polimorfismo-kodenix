
public abstract class Piece {
	
	private String unicodePiece;
	private boolean placedOnBoard = false;
	private Color color;
	
	Piece(Color color) {
		this.color = color;
	}
	
	public abstract boolean isValidMoveRule(Coordinate origin, Coordinate destination);
	
	protected void setUnicodePiece(String unicodePiece) {
		this.unicodePiece = unicodePiece;
	}
	
	protected boolean isKing() {
		return false;
	}
	
	protected boolean isKnight() {
		return false;
	}
	
	public String getFigure() {
		return this.unicodePiece;
	}
	
	public boolean isPlacedOnboard() {
		return this.placedOnBoard;
	}
	
	public void setOnBoard() {
		this.placedOnBoard = true;
	}
	
	public Color getColor() {
		return this.color;
	}


}
