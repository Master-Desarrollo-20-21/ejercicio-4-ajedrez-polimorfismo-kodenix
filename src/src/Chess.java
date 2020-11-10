import java.util.HashMap;
import java.util.Map;

class Chess {

	private static final int TOTAL_PLAYERS = 2;

	private Player[] players = new Player[TOTAL_PLAYERS];
	private Board board;
	private int turn;

	Chess() {
		this.turn = 0;
		this.board = new Board();
		this.players = this.initializePlayers(board);
		Map<Color, Piece[]> pieces = this.createPieces();
		board.placePieces(pieces);
	}

	public void play() {
		System.out.println("=====================================");
		System.out.println("---------------Chess!!!--------------");
		System.out.println("=====================================");
		System.out.println("[[ Example coordinate: 5c, 1a, not CamelCase ]]");
		do {
			Player currentPlayer = this.players[turn];
			System.out.println("Turn for Player: " + currentPlayer.getColor());
			board.show();
			currentPlayer.makeMove(board);

			if (currentPlayer.isWinner()) {
				System.out.println("Player " + currentPlayer.getColor() + " is Winner!!");
			} else {
				this.changeTurn();
			}
		} while (!this.players[this.turn].isWinner());

	}

	private void changeTurn() {
		this.turn = (this.turn + 1) % 2;
	}

	private Map<Color, Piece[]> createPieces() {

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

	private Player[] initializePlayers(Board board) {
		Player[] players = new Player[TOTAL_PLAYERS];
		players[0] = new Player(Color.WHITE);
		players[1] = new Player(Color.BLACK);
		return players;
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.play();
	}

}
