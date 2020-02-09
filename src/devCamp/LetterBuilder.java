package devCamp;

public class LetterBuilder {

	private static final String EMPTY_SYMBOL = "-";
	private static final String DRAW_SYMBOL = "*";
	
	private StringBuilder stringBuilder;
	
	public LetterBuilder() {
		this.stringBuilder = new StringBuilder();
	}

	public StringBuilder build(int n) {
		// total number of rows
		int rows = n + 1;

		// build upper part
		for (int row = 0; row < rows / 2; row++) {
			stringBuilder.append(buildMUpperPart(n, row))
						.append(buildMUpperPart(n, row));
			
			stringBuilder.append(appendStringNTimes(System.lineSeparator(), 1));
		}

		// build lower part
		for (int row = rows / 2; row < rows; row++) {
			stringBuilder.append(buildMLowerPart(n, row))
						.append(buildMLowerPart(n, row));

			stringBuilder.append(appendStringNTimes(System.lineSeparator(), 1));
		}
		
		return this.stringBuilder;
	}

	private StringBuilder buildMUpperPart(int n, int row) {
		StringBuilder currentSbBuilder = new StringBuilder();
		
		currentSbBuilder.append(buildEmptyPart(n - row))
						.append(buildPeakPart(n, row))
						.append(buildEmptyPart(n - 2*row))
						.append(buildPeakPart(n, row))
						.append(buildEmptyPart(n - row));
		
		return currentSbBuilder;
	}

	private String buildPeakPart(int n, int row) {
		int currentDrawCount = n + 2 * row;
		
		if (currentDrawCount > 2 * n) {
			return appendStringNTimes(DRAW_SYMBOL, n);
		} 
		
		return appendStringNTimes(DRAW_SYMBOL, currentDrawCount);
	}
	
	private String buildEmptyPart(int times) {
		return appendStringNTimes(EMPTY_SYMBOL, times);
	}

	private StringBuilder buildMLowerPart(int n, int row) {
		StringBuilder currentSbBuilder = new StringBuilder();

		// ????
		currentSbBuilder.append(buildEmptyPart(n - row))
//						.append(buildShallowPart(n, row))
						.append(appendStringNTimes(DRAW_SYMBOL, n))
						.append(buildEmptyPart(n - (n - row) * 2))
						
						.append(buildShallowPart(n, row))
						
						.append(buildEmptyPart(n - (n - row)*2))
						.append(appendStringNTimes(DRAW_SYMBOL, n))
//						.append(buildShallowPart(n, row))
						.append(buildEmptyPart(n - row));
						
		return currentSbBuilder;
	}

	private String buildShallowPart(int n, int row) {
		int currentDrawCount = n + 2 * (n - row);
		
		if (currentDrawCount > 2 * n) {
			return appendStringNTimes(DRAW_SYMBOL, n);
		} 
		
		return appendStringNTimes(DRAW_SYMBOL, currentDrawCount);
	}
	
	private String appendStringNTimes(String str, int times) {
		if (times < 0) {
			return "";
		}
		
		return str.repeat(times);
	}

}