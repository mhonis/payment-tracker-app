package openwise.mhonis;

public enum Command {
	HELP("Lists all available commands"),
	LIST("Prints the currency list"),
	QUIT("Terminates the application");

	//LOAD("Loads file from a specified path; command must be followed by a file path)

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
