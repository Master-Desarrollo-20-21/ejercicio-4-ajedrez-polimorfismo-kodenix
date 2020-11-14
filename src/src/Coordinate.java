
public class Coordinate {
	
	public static final int ASCII_a=97;
	public static final int ASCII_1=49;
	private int row;
	private int column;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Coordinate(String coordinate) {
		this.row = ((int) coordinate.charAt(1)) - ASCII_1;
		this.column = ((int) coordinate.charAt(0)) - ASCII_a;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public String getPriteableCoordinate() {
		String rowString = String.valueOf(this.getRow());
		String columString = String.valueOf(this.getColumn());
		
		return rowString + columString;
	}
	
	public boolean hasVerticalDirectionWith(Coordinate coordinate) {
		return this.column == coordinate.getColumn();
	}
	
	public boolean hasOneStepVerticalDirectionWith(Coordinate destination) {
		int diferencieSteps = Math.abs(this.row - destination.getRow()); 
		return this.hasVerticalDirectionWith(destination) &&  diferencieSteps == 1 ;
	}
	
	public boolean hasHorizontalDirectionWith(Coordinate coordinate) {
		return this.row == coordinate.getRow();
	}
	
	public boolean hasOneStepHorizontalDirectionWith(Coordinate destination) {
		return this.hasHorizontalDirectionWith(destination) &&  this.isOneSteep(this.row, destination.getRow());
	}

	public boolean hasDiagonalDirectionWith(Coordinate destination) {
		int destinationRow = destination.getRow();
		int destinationColumn = destination.getColumn();
		
		return this.row + this.column == destinationRow + destinationColumn || 
				this.row - this.column == destinationRow - destinationColumn;
		
	}
	
	public boolean hasOneStepDiagonalDirectionWith(Coordinate destination) { 
		return this.hasDiagonalDirectionWith(destination) &&  this.isOneSteep(this.row, destination.getRow());
		
	}
	
	private boolean isOneSteep(int origin, int destination) {
		return Math.abs(destination-origin)==1;
	}
	
	public boolean isSameDiferenceSteeps(int numberRowOrigin, int numberRowDestination, int awaitedSteeps) {
		return Math.abs(numberRowOrigin - numberRowDestination) == awaitedSteeps;
	}

	public static char getTextSimbolFrom(int number) {
		char asciiText = ((char) (number + ASCII_a));
		return asciiText;
	}
	
}
