
public abstract class Piece {
	
	private String unicodePiece;
	private Player player;
	private boolean placedOnBoard = false;
	
	Piece(Player player) {
		this.player = player;
	}
	
	public abstract Coordinate[] getDefaultCoordinates();
	public abstract boolean isValidMove(Coordinate origin, Coordinate destination);
	
	protected void setUnicodePiece(String unicodePiece) {
		this.unicodePiece = unicodePiece;
	}
	
	protected boolean isKing() {
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
		return this.player.getColor();
	}


}
