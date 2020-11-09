
public class RuleMove {

	public static boolean isHorizontal(Coordinate origin, Coordinate destination) {
		return origin.getRow() == destination.getRow();
	}
	
	public static boolean isHorizontalOneStep(Coordinate origin, Coordinate destination) {
		int diferencieSteps = Math.abs(origin.getColumn() - destination.getColumn()); 
		return RuleMove.isHorizontal(origin, destination) &&  diferencieSteps == 1 ;
	}

	public static boolean isVertical(Coordinate origin, Coordinate destination) {
		return origin.getColumn() == destination.getColumn();
	}
	
	public static boolean isVerticalOneStep(Coordinate origin, Coordinate destination) {
		int diferencieSteps = Math.abs(origin.getRow() - destination.getRow()); 
		return RuleMove.isVertical(origin, destination) &&  diferencieSteps == 1 ;
	}
	
	private static boolean isPositiveDiagonal(Coordinate origin, Coordinate destination) {
		return origin.getRow() + origin.getColumn() == destination.getRow() + destination.getColumn();
	}
	
	private static boolean isInverseDiagonal(Coordinate origin, Coordinate destination) {
		return origin.getRow() - origin.getColumn() == destination.getRow() - destination.getColumn();
	}
	
	public static boolean isDiagonal(Coordinate origin, Coordinate destination) {
		return RuleMove.isPositiveDiagonal(origin, destination) || RuleMove.isInverseDiagonal(origin, destination);
	}
	
	public static boolean isDiagonalOneStep(Coordinate origin, Coordinate destination) {
		int diferencieSteps = Math.abs(origin.getRow() - destination.getRow()); 
		return RuleMove.isDiagonal(origin, destination) &&  diferencieSteps == 1 ;
	}

	
	
	
	
}
