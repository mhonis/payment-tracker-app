package openwise.mhonis;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for PT.
 */
public class PaymentTrackerTest extends TestCase {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private static final String EOL = "\r\n";

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));
		ConsoleInputProcessor.getInstance().flushStoredCurrencies();
	}

	@After
	public void tearDown() {
		System.setOut(originalOut);
	}

	@Test
	public void testParsingOk() {
		String data = "ABC 123";
		ConsoleInputProcessor.getInstance().parseInput(data);
		ConsoleInputProcessor.getInstance().listCurrencies();
		String output = outContent.toString();
		assertEquals(data + EOL, output);
	}

	@Test
	public void testParsingNeg() {
		String data = "incorrect format";
		ConsoleInputProcessor.getInstance().parseInput(data);
		ConsoleInputProcessor.getInstance().listCurrencies();
		String output = outContent.toString();
		assertEquals("Input does not match the required input pattern!" + EOL, output);
	}

	@Test
	public void testOk() {
		List<String> inputList = new ArrayList<>();
		inputList.add("USD 1000");
		inputList.add("HDK 100");
		inputList.add("USD -100");
		inputList.add("RMB 2000");
		inputList.add("HDK 200");

		inputList.stream().forEach(input -> ConsoleInputProcessor.getInstance().parseInput(input));
		ConsoleInputProcessor.getInstance().listCurrencies();
		String output = outContent.toString();
		assertEquals(
				"USD 900" + EOL +
						"HDK 300" + EOL +
						"RMB 2000" + EOL,
				output);
	}

	@Test
	public void testZeroAmount() {
		String line1 = "USD 128";
		String line2 = "USD -128";
		ConsoleInputProcessor.getInstance().parseInput(line1);
		ConsoleInputProcessor.getInstance().parseInput(line2);
		ConsoleInputProcessor.getInstance().listCurrencies();
		String output = outContent.toString();
		assertEquals("", output);
	}

	@Test
	public void testFileLoading() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("curr.txt").getFile());
		FileInputProcessor fileIP = new FileInputProcessor();
		fileIP.readFile(file.getAbsolutePath());
		fileIP.listCurrencies();
		String output = outContent.toString();
		assertEquals(
				"ABC 123" + EOL +
						"DEF 456" + EOL +
						"GHI 789" + EOL,
				output);
	}
}
