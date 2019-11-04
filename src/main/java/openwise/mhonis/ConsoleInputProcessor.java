package openwise.mhonis;

import java.util.Scanner;

public class ConsoleInputProcessor extends AbstractInputProcessor {


	private static ConsoleInputProcessor instance = null;

	private ConsoleInputProcessor(){}

	@Override
	public void init() {
		flushStoredCurrencies();
		String input;
		//continuously listen for user input using scanner
		Scanner scanner = new Scanner(System.in);
		while (!(input = scanner.nextLine()).equalsIgnoreCase(Command.QUIT.name())) {
			parseInput(input);
		}
	}

	public static ConsoleInputProcessor getInstance() {
		if (instance == null)
			instance = new ConsoleInputProcessor();
		return instance;
	}
}
