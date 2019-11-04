package openwise.mhonis;

public enum Command {
	HELP("Lists all available commands"),
	LIST("Prints the currency list"),
	LOAD("Loads currencies from a text file. Must be followed by a filename or full path."),
	QUIT("Terminates the application");


	private String description;

	Command(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static Command getCommand(String input) {
		for (Command command : Command.values()) {
			if (command.name().equalsIgnoreCase(input)) {
				return command;
			}
		}
		return null;
	}
}
