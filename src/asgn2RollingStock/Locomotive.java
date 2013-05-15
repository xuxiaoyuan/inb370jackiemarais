/**
 * @author Marais Rossow
 * @studentid n8911495
 */
package asgn2RollingStock;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.RollingStock;

public class Locomotive extends RollingStock {
	
	private static String[][] engineType = {{"E", "Electric"},{"D", "Diesel"},{"S", "Steam"}};
	private String engineCode;
	private Integer power = 1;
	
	// Constructs a new locomotive object with a fixed gross weight and classification code.
	public Locomotive(Integer grossWeight, String classification) throws TrainException {
		super(grossWeight);
		// Error checking.
		if (classification == null) {
			throw new TrainException("Invalid parameters");
		} else {
			if (classification.length() == 2) {
				char engineCode 	= classification.charAt(1); // Get the last char
				char digit 			= classification.charAt(0);
				
				if (digit < '0' || digit > '9') {
					throw new TrainException("Not in range");
				}
						
				boolean testPassed = false;
				// Test to see if the engine type is in-fact a valid engine type.
				for(int i=0; i < Locomotive.engineType.length; i++) {
					if (Locomotive.engineType[i][0].charAt(0) == (engineCode)) {
						testPassed = true;
						break;
					}
				}
				if (testPassed == false) {
					throw new TrainException("Invalid engine code");
				}
				if (grossWeight < 0) { // gross not positive
					throw new TrainException("Gross weight not positive");
				}
			} else {
				throw new TrainException("Classification invlaid");
			}
		}
		
		// IF REACH HERE -  ALL TESTS PASSED
		this.engineCode = classification.substring(1);
		this.power = Integer.parseInt(classification.substring(0,1));
	}
	
	// Returns how much total weight the locomotive can pull (including itself), calculated as explained above.
	public Integer power() {
		return ((power * 100) + getGrossWeight());
	}
	
	// Returns a human-readable description of the locomotive.
	public String toString() {
		String returning = "";
		
		// Finds the description of the engine type
		for(int i=0; i < Locomotive.engineType.length; i++) {
			if (Locomotive.engineType[i][0].equals(engineCode)) {
				returning = Locomotive.engineType[i][0];
				break;
			}
		}
		
		return "Loco("  + power + returning + ")";
	}
}
