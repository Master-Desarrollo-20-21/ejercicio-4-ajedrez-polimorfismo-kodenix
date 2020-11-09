
class Chess {
	
	final int NUMBERS_PIECE_ROOK = 2;
	final int NUMBERS_PIECE_QUEEN = 1;
	final int NUMBERS_PIECE_KING = 1;
	
	private Player[] players = new Player[2];
	private Board board;
	private int turn;
	
	Chess() {
		this.turn = 0;
		this.board = new Board();
		this.players = this.initializePlayers(board);
		Piece[] pieces = this.generatePieces(this.players);
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
				System.out.println("Player "+ currentPlayer.getColor() + " is Winner!!");
			} else {
				this.changeTurn();
			}
		} while (!this.players[this.turn].isWinner());
		
		
	}
	
	private void changeTurn() {
		if (this.turn == 0) {
			this.turn=1;
		} else this.turn=0;
		
	}

	private Piece[] generatePieces(Player[] players) {
		Piece[] allPieces = new Piece[24];
	
		allPieces[0] = new Rook(players[0]);
		allPieces[1] = new Rook(players[0]);
		allPieces[2] = new Queen(players[0]);
		allPieces[3] = new King(players[0]);
		
		allPieces[4] = new Pawn(players[0]);
		allPieces[5] = new Pawn(players[0]);
		allPieces[6] = new Pawn(players[0]);
		allPieces[7] = new Pawn(players[0]);
		allPieces[8] = new Pawn(players[0]);
		allPieces[9] = new Pawn(players[0]);
		allPieces[10] = new Pawn(players[0]);
		allPieces[11] = new Pawn(players[0]);
		
		allPieces[12] = new Rook(players[1]);
		allPieces[13] = new Rook(players[1]);
		allPieces[14] = new Queen(players[1]);
		allPieces[15] = new King(players[1]);
		
		allPieces[16] = new Pawn(players[1]);
		allPieces[17] = new Pawn(players[1]);
		allPieces[18] = new Pawn(players[1]);
		allPieces[19] = new Pawn(players[1]);
		allPieces[20] = new Pawn(players[1]);
		allPieces[21] = new Pawn(players[1]);
		allPieces[22] = new Pawn(players[1]);
		allPieces[23] = new Pawn(players[1]);
		
		
		
		return allPieces;
	}

	private Player[] initializePlayers(Board board) {
		Player[] players = new Player[2];
		players[0] = new Player(Color.WHITE);
		players[1] = new Player(Color.BLACK);
		return players;
	}
	

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.play();

	}
	
	

}
