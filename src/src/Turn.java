
class Turn {

    private final int TOTAL_PLAYERS = 2;
    Player[] players;
    private Player currentPlayer;
    private int indexPlayer = 0;

    public Turn() {
        
        this.players = new Player[TOTAL_PLAYERS];
        int aux = 0;
        for (Color color : Color.values()) {
            this.players[aux] = new Player(color);
            aux++;
        }

        this.currentPlayer = players[indexPlayer];
        
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public void change() {
        this.indexPlayer = (this.indexPlayer + 1) % 2;
        this.currentPlayer = players[this.indexPlayer];
	}

}
