import java.util.HashMap;
import java.util.Map;

class Chess {

	private Board board;
	private Turn turn;

	Chess() {
		this.turn = new Turn();
		this.board = new Board();
		board.placePieces(this.initializePieces());
	}

	public void play() {
		System.out.println("=====================================");
		System.out.println("---------------Chess!!!--------------");
		System.out.println("=====================================");
		System.out.println("[[ Example coordinate: 5c, 1a, not CamelCase ]]");
		do {
			Player currentPlayer = this.turn.getCurrentPlayer();
			Color currentPLayerColor = currentPlayer.getColor();
			System.out.println("Turn for Player: " + currentPLayerColor);
			board.show();

			currentPlayer.playTurn(board);

			if (currentPlayer.isWinner()) {
				System.out.println("Player " + currentPLayerColor + " is Winner!!");
			} else {
				this.turn.change();
			}
		} while (!this.turn.getCurrentPlayer().isWinner());

	}

	private Map<Color, Piece[]> initializePieces() {

		Map<Color, Piece[]> colorWithPieces = new HashMap<Color, Piece[]>();

		for (Color color : Color.values()) {

			Piece[] pieces = { new Rook(color), new Knight(color), new Bishop(color), new Queen(color), new King(color),
					new Bishop(color), new Knight(color), new Rook(color), new Pawn(color), new Pawn(color),
					new Pawn(color), new Pawn(color), new Pawn(color), new Pawn(color), new Pawn(color),
					new Pawn(color), };
			colorWithPieces.put(color, pieces);

		}

		return colorWithPieces;

	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.play();
	}

}
