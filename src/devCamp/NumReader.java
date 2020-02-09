package devCamp;

import java.util.Scanner;

public class NumReader {
	private Scanner scanner;
	
	public NumReader(Scanner scanner) {
		this.scanner = scanner;
	}
	
	protected int readUserInput() {
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
		return n;
	}
}
