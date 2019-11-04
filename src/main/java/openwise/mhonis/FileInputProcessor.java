package openwise.mhonis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileInputProcessor extends AbstractInputProcessor {

	@Override
	public void init() {
	}

	/**
	 * Loads text file with currency codes and values, parses it and stores in memory.
	 * Overwrites any existing codes and values in the memory.
	 *
	 * @param fileName name in current dir or full path
	 */
	public void readFile(String fileName) {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			flushStoredCurrencies();
			stream.forEach(super::parseInput);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file specified.");
		} catch (IOException e) {
			System.out.println("Could not read the specified file.");
		}
	}
}
