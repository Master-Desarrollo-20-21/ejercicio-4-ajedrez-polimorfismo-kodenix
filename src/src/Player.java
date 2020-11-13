import java.util.Scanner;

public class Player {
	
	private boolean winner;
	private Color color;

	public Player(Color color) {
		this.color = color;
	}
	
	private void setWinner() {
		this.winner = true;
	}

	public boolean isWinner() {
		return this.winner;
	}

	public void sayWinner() {
		System.out.println("I am Winner!!!!!!!!!!!");
	}

	public Color getColor() {
		return this.color;
	}

	public void makeMove(Board board) {
		
		MatchResult matchResult;
		Scanner in = new Scanner(System.in);
		do {
			
			System.out.println("Indique coordenada de origen:");
			String originText = in.next();			
			Coordinate origin = new Coordinate(originText);

			System.out.println("Indique coordenada de destino:");
			String destinationText = in.next();
			Coordinate destination = new Coordinate(destinationText);

			Coordinate[] coordinates = { origin, destination }; 

			Movement movement = new Movement(coordinates, board, this.getColor());
			matchResult = movement.getResult();
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

}
