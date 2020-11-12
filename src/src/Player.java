import java.util.Scanner;

public class Player {
	
	private boolean winner;
	private Color color;

	public Player(Color color) {
		this.color = color;
	}
	
	public boolean isWinner() {
		return this.winner;
	}

	public Color getColor() {
		return this.color;
	}

	public void playTurn(Board board) {
		
		MatchResult matchResult;
		Scanner in = new Scanner(System.in);
		do {
			Coordinate origin = readCoordinateWithMessage("Indique coordenada de origen:");
			Coordinate destination = readCoordinateWithMessage("Indique coordenada de destino:");
			Movement movement = new Movement(origin, destination);
			matchResult = movement.performe(board, this.getColor());
		 	if (matchResult != MatchResult.INVALID) {
				System.out.println("Result Match:" + matchResult);
				if (matchResult == MatchResult.CHECKMATE) {
					this.setWinner();
				}
			} else {
				System.out.println("Movimiento no válido");
			} 
		} while (matchResult == MatchResult.INVALID);
		
	}

	private Coordinate readCoordinateWithMessage(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		String coordinateText =  sc.next();			
		Coordinate coordinate = Coordinate.getCoordinateFromSimbol(coordinateText);
		return coordinate;
	}

	private void setWinner() {
		this.winner = true;
	}

}
