package seats;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class AllocationTest {
	private Allocation classUnderTest;

	@Before
	public void setUp() {
		classUnderTest = new Allocation();
	}

	@Test
	public void checkSeats() throws FileNotFoundException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		classUnderTest.allocateSeats("testData1");
		String expectedOutput = "Wilson Sorry, we can't handle your party";
		assertTrue(outContent.toString().contains(expectedOutput));
	}
}
