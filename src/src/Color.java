
public enum Color {
	WHITE, BLACK;

	public int getAuxiliarRowIncrement() {
		if (this == WHITE) {
			return 1;
		} else return -1;
	}

	public int getInitialRowNumber() {
		if (this == WHITE) {
			return 0;
		} else return 7;
	}
}
