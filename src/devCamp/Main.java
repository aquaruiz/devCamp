package devCamp;

import java.util.Scanner;


public class Main {

	/*
	 * Small console app for 2 M-letters drawing
	 * Letter size depends on user input N
	 * 2 < N < 10 000, N is always odd integer
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		App myApp = new App(scanner);

		myApp.run();
	}
}