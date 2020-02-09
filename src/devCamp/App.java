package devCamp;

import java.util.Scanner;

public class App implements Runnable {
	private NumReader numReader;
	private LetterBuilder letterBuilder;
	
	public App(Scanner scanner) {
		this.numReader = new NumReader(scanner);
		this.letterBuilder = new LetterBuilder();
	}
	
	public void run() {
		int n = numReader.readUserInput();
		
		StringBuilder stringBuilder = letterBuilder.build(n);
		
		System.out.println(stringBuilder.toString());
	}
} 
