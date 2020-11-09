
public abstract class Piece {
	
	private String unicodePiece;
	private Player player;
	private boolean placedOnBoard = false;
	
	Piece(Player player) {
		this.player = player;
	}
	
	protected void setUnicodePiece(String unicodePiece) {
		this.unicodePiece = unicodePiece;
	}
	
	public String getFigure() {
		return this.unicodePiece;
	}
	
	public abstract Coordinate[] getDefaultCoordinates();

	protected Player getPlayer() {
		return player;
	}
	
	public boolean isPlacedOnboard() {
		return this.placedOnBoard;
	}
	
	public void setOnBoard() {
		this.placedOnBoard = true;
	}

	public boolean isValidDestination(Coordinate destination) {
		return true;
	}

}
