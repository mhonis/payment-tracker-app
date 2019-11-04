package openwise.mhonis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {

	private static InputProcessor instance = null;

	private static LinkedHashMap<String, Long> currencyMap = new LinkedHashMap<>();;
	private static final Pattern currInputPattern = Pattern.compile("^([A-Z]{3})[ ](-?\\d+)");

	private InputProcessor() {
	}

	public static InputProcessor getInstance() {
		if (instance == null)
			instance = new InputProcessor();
		return instance;
	}

	public void init() {
		String input;
		//continuously listen for user input using scanner
		Scanner scanner = new Scanner(System.in);
		while (!(input = scanner.nextLine()).equalsIgnoreCase(Command.QUIT.name())) {
			parseInput(input);
		}
	}

	public void parseInput(String input) {
		//check whether input matches any predefined command
		Command cmd = Command.getCommand(input);
		if (cmd != null) {
			executeCommand(Command.getCommand(input));
		} else {
			//check if input matches the currency format
			Matcher matcher = currInputPattern.matcher(input);
			if (matcher.matches()) {
				//string matches the required format; parse it and store the data
				String currCode = matcher.group(1);
				Long currAmount = Long.valueOf(matcher.group(2));
				if (currencyMap.containsKey(currCode)) {
					Long tempVal = currencyMap.get(currCode);
					currencyMap.put(currCode, tempVal + currAmount);
				} else {
					currencyMap.put(currCode, currAmount);
				}
			} else {
				System.out.println("Input does not match the required input pattern!");
			}
		}
	}

	public LinkedHashMap<String, Long> getCurrencyMap() {
		return currencyMap;
	}

	public void listCurrencies() {
		for (Map.Entry<String, Long> entry : currencyMap.entrySet()) {
			if(entry.getValue() != 0) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}

	private void executeCommand(Command command) {
		switch (command) {
			case HELP: {
				System.out.println("Available commands:");
				for (Command cmd : Command.values()) {
					System.out.println(cmd.name() + " : " + cmd.getDescription());
				}
				break;
			}
			case LIST:
				listCurrencies();
				break;
			case QUIT:
				return;
		}
	}
}
