package devCamp;

import java.util.Scanner;


public class Main {

	private static final String EMPTY_SYMBOL = "-";
	private static final String DRAW_SYMBOL = "*";
	/*
	 * Small console app for 2 M-letters drawing
	 * Letter size depends on user input N
	 * 2 < N < 10 000, N is always odd integer
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// read user input and check if is integer in range 2 - 10 000
		int n = 0;
		do {
			System.out.println("Please enter N between 3 and 9 999:");
			try {
				n = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.print("Non integers are not allowed. ");
				continue;
			}
		}
		while (n < 3 || n > 9999);
		
		scanner.close();

		// number of rows
		int rows = n + 1;

		// middle counter
		int midCounter = 2*n;
		
		// print upper part
		for (int row = 0; row < rows / 2; row++) {
			buildMUpperPart(n, row);
			buildMUpperPart(n, row);
			
			printStringNTimes(System.lineSeparator(), 1);
		}

		// print lower part
		for (int row = rows / 2; row < rows; row++) {
			buildMLowerPart(n, row);
			buildMLowerPart(n, row);


			printStringNTimes(System.lineSeparator(), 1);
		}
		
	}
	
	private static void buildMUpperPart(int n, int row) {
		printStringNTimes(EMPTY_SYMBOL, n - row);

		buildPeakPart(n, row);

		printStringNTimes(EMPTY_SYMBOL, n - 2*row);

		buildPeakPart(n, row);
		
		printStringNTimes(EMPTY_SYMBOL, n - row);
	}
	
	private static void buildMLowerPart(int n, int row) {
		printStringNTimes(EMPTY_SYMBOL, n - row);
		printStringNTimes(DRAW_SYMBOL, n);
		printStringNTimes(EMPTY_SYMBOL, n - (n - row) * 2);

		
		buildShallowPart(n, row);

		printStringNTimes(EMPTY_SYMBOL, n - (n - row)*2);
		printStringNTimes(DRAW_SYMBOL, n);
		printStringNTimes(EMPTY_SYMBOL, n - row);
	}

	private static void buildPeakPart(int n, int row) {
		int currentDrawCount = n + 2 * row;
		
		if (currentDrawCount > 2 * n) {
			printStringNTimes(DRAW_SYMBOL, n);
		} else {
			printStringNTimes(DRAW_SYMBOL, currentDrawCount);
		}
	}

	private static void buildShallowPart(int n, int row) {
		int currentDrawCount = n + 2 * (n - row);
		
		if (currentDrawCount > 2 * n) {
			printStringNTimes(DRAW_SYMBOL, n);
		} else {
			printStringNTimes(DRAW_SYMBOL, currentDrawCount);
		}
	}


	private static void printStringNTimes(String str, int n) {
		String output = "";
		
		if (n < 0) {
			output = "";
		} else {
			output = str.repeat(n);
		}
		
		System.out.print(output);
	}
}
