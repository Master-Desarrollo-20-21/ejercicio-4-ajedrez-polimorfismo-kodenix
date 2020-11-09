
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
		
		do {
			Player currentPlayer = this.players[turn];
			System.out.println("Turn for Player: " + currentPlayer.getColor());
			board.show();
			currentPlayer.makeMove();
			this.changeTurn();
		} while (!this.players[this.turn].isWinner());
		
		
	}
	
	private void changeTurn() {
		if (this.turn == 0) {
			this.turn=1;
		} else this.turn=0;
		
	}

	private Piece[] generatePieces(Player[] players) {
		Piece[] allPieces = new Piece[8];
	
		allPieces[0] = new Rook(players[0]);
		allPieces[1] = new Rook(players[0]);
		allPieces[2] = new Queen(players[0]);
		allPieces[3] = new King(players[0]);
		
		allPieces[4] = new Rook(players[1]);
		allPieces[5] = new Rook(players[1]);
		allPieces[6] = new Queen(players[1]);
		allPieces[7] = new King(players[1]);
		
		return allPieces;
	}

	private Player[] initializePlayers(Board board) {
		Player[] players = new Player[2];
		players[0] = new Player(Color.WHITE, board);
		players[1] = new Player(Color.BLACK, board);
		return players;
	}
	

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.play();

	}
	
	

}
