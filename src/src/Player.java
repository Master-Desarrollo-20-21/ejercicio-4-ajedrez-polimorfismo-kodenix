import java.util.Scanner;

public class Player {
	private int count = 0;
	private boolean winner;
	private Color color;
	private Board board;

	public Player(Color color, Board board) {
		this.color = color;
		this.board = board;
	}

	public boolean isWinner() {
		// TODO Auto-generated method stub
		return this.winner;
	}

	public void sayMyColor() {
		System.out.println(this.color);
		count++;
		if (count == 5) {
			this.winner = true;
		}
		
	}

	public void sayWinner() {
		System.out.println("I am Winner!!!!!!!!!!!");
		
	}

	public Color getColor() {
		return this.color;
	}

	public void makeMove() {
		
		// Console console = System.console();
		
		
		MatchResult matchResult;
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("Indique coordenada de origen:");
			// String originText = console.readLine("%s", "Indique coordenada de origen:");
			String originText = in.next();
			
			Coordinate origin = Coordinate.getCoordinateFromSimbol(originText);

			// String destinationText = console.readLine("%s", "Indique coordenada de destino:");
			System.out.println("Indique coordenada de destino:");
			String destinationText = in.next();
			Coordinate destination = Coordinate.getCoordinateFromSimbol(destinationText);

			Movement movement = new Movement(origin, destination, this.board, this);
			matchResult = movement.getResult();
		 	if (matchResult != MatchResult.INVALID) {
				System.out.println("Result Match:" + matchResult);
			} else {
				System.out.println("Movimiento no válido");
			} 
		} while (matchResult == MatchResult.INVALID);
		
		
		
		
		
		// boolean validMovement = false;
		
		/*
		do {
			Coordinate origin = new Coordinate(row, column)
			Movement movement = new Movement("8a", "2a");
			MatchResult matchResult = movement.getResult();
			validMovement = matchResult.isValid();

			if (validMovement) {
				System.out.println(matchResult.getType());
			}
					
					
		} while (validMovement == false);
		*/
		
	}

}
