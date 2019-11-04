package openwise.mhonis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractInputProcessor {

	private static LinkedHashMap<String, Long> currencyMap = new LinkedHashMap<>();

	private static final Pattern currInputPattern = Pattern.compile("^([A-Z]{3})[ ](-?\\d+)");

	public abstract void init();

	public void flushStoredCurrencies() {
		currencyMap.clear();
	}

	public void parseInput(String input) {
		if (input.isEmpty()) {
			return;
		}
		//check whether input matches any predefined command
		Command cmd = Command.getCommand(input);
		if (cmd != null) {
			executeCommand(cmd);
		} else {
			//check if input matches the currency format
			Matcher matcher = currInputPattern.matcher(input);
			if (matcher.matches()) {
				//string matches the required format; parse it and store the data
				String currCode = matcher.group(1);
				try {
					Long currAmount = Long.valueOf(matcher.group(2));
					if (currencyMap.containsKey(currCode)) {
						Long tempVal = currencyMap.get(currCode);
						currencyMap.put(currCode, tempVal + currAmount);
					} else {
						currencyMap.put(currCode, currAmount);
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid number. Amount must be between " + Long.MIN_VALUE + " and " + Long.MAX_VALUE);
				}
			} else {
				System.out.println("Input does not match the required input pattern!");
			}
		}
	}

	public void listCurrencies() {
		for (Map.Entry<String, Long> entry : currencyMap.entrySet()) {
			if (entry.getValue() != 0) {
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
			case LOAD:
				System.out.println("Please input a fileName or path to the file. (Current working directory: " + System.getProperty("user.dir"));
				Scanner scanner = new Scanner(System.in);
				String file = scanner.nextLine();
				FileInputProcessor reader = new FileInputProcessor();
				reader.readFile(file);
				break;
			case QUIT:
				return;
		}
	}
}
