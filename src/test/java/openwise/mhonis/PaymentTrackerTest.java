package openwise.mhonis;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for PT.
 */
public class PaymentTrackerTest extends TestCase {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testParsing() {
		String data = "ABC 123";
		InputProcessor.getInstance().parseInput(data);
		InputProcessor.getInstance().listCurrencies();
		assertEquals(data, outContent.toString());
	}
}
