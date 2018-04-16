package barclay;

import org.junit.Before;
import org.junit.Test;

public class SeatArrangerTest {
	private SeatArranger classUnderTest;

	@Before
	public void setUp() {
		classUnderTest = new SeatArranger();
	}
	
	@Test
	public void checkSeats(){
		classUnderTest.main(null);
	}
}
