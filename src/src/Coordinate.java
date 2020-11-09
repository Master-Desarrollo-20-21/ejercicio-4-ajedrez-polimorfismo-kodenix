import java.util.HashMap;
import java.util.Map;

public class Coordinate {

	private int row;
	private int column;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Coordinate(char row, char column) {
		String rowStr = String.valueOf(row);
		String columnStr = String.valueOf(column);
		String coordinateSimbol = rowStr + columnStr;
		Coordinate coordinate = Coordinate.getCoordinateFromSimbol(coordinateSimbol);
		this.row = coordinate.getRow();
		this.column = coordinate.getColumn();
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
	
	public String getTextSimbol() {
		String row = Coordinate.rowsSimbol.get(this.getRow());
		String column = Coordinate.columnsSimbol.get(this.getColumn());
		return row+column;
	}

	
	private static int rowPositionForSearch;
	private static int columnPositionForSearch;
	public static Map<Integer, String> rowsSimbol = new HashMap<Integer, String>();
	public static Map<Integer, String> columnsSimbol = new HashMap<Integer, String>();
	
	public static Coordinate getCoordinateFromSimbol(String simbol) {
		String[] characters = simbol.split("");
		
		rowsSimbol.forEach((key, value) -> {
		    if (value.equals(characters[0])) {
		    	rowPositionForSearch = key;
		    }
		});
		
		columnsSimbol.forEach((key, value) -> {
		    if (value.equals(characters[1])) {
		    	columnPositionForSearch = key;
		    }
		});
		
		return new Coordinate(rowPositionForSearch, columnPositionForSearch);
		
    }
	
	static {
		rowsSimbol.put(7, "8");
		rowsSimbol.put(6, "7");
		rowsSimbol.put(5, "6");
		rowsSimbol.put(4, "5");
		rowsSimbol.put(3, "4");
		rowsSimbol.put(2, "3");
		rowsSimbol.put(1, "2");
		rowsSimbol.put(0, "1");
		
		columnsSimbol.put(0, "a");
		columnsSimbol.put(1, "b");
		columnsSimbol.put(2, "c");
		columnsSimbol.put(3, "d");
		columnsSimbol.put(4, "e");
		columnsSimbol.put(5, "f");
		columnsSimbol.put(6, "g");
		columnsSimbol.put(7, "h");
		
	}
	
	
}
