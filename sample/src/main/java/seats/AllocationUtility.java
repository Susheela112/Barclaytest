package seats;

import java.io.FileNotFoundException;

public class AllocationUtility {

	public static void main(String[] args) throws FileNotFoundException {
		Allocation object = new Allocation();
		object.allocateSeats("testData1");
	}

}
