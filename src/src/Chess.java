import java.util.HashMap;
import java.util.Map;

class Chess {

	private Board board;
	private Turn turn;

	Chess() {
		this.turn = new Turn();
		this.board = new Board();
		
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


	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.play();
	}

}
