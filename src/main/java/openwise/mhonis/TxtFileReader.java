package openwise.mhonis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReader {

	public static void readFile(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null; ) {
				InputProcessor.getInstance().parseInput(line);
			}
			// line is not visible here.
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file specified.");
		} catch (IOException e) {
			System.out.println("Could not read the specified file.");
		}
	}
}
