/**
 * @author Marais Rossow
 * @studentid n8911495
 */
package asgn2RollingStock;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.RollingStock;

public class FreightCar extends RollingStock {
	
	private static String[][] CarriedGoods = {{"G", "General goods"},{"R", "Refrigerated goods"},{"D", "Dangerous materials"}};
	private String CurrentGood;
	
	// Constructs a freight car object.
	public FreightCar(Integer grossWeight, String goodsType) throws TrainException {
		super(grossWeight);
		// Error checking.
		if (goodsType == null) {
			throw new TrainException("Invalid parameters");
		} else {
			boolean testPassed = false;
			// Test to see if the goodsType is in-fact a valid good type.
			for(int i=0; i < FreightCar.CarriedGoods.length; i++) {
				if (FreightCar.CarriedGoods[i][0].equals(goodsType)) {
					testPassed = true;
					break;
				}
			}
			if (testPassed == false) {
				throw new TrainException("Invalid good type");
			}
			if (grossWeight < 0) { // gross not positive
				throw new TrainException("Gross weight not positive");
			}
		}
		// IF REACH HERE -  ALL TESTS PASSED
		CurrentGood 		= goodsType;
	}
	
	//  Returns the type of goods this carriage was designed to carry.
	public String goodsType() {
		return CurrentGood;
	}
	
	//  Returns a human-readable description of the freight car.
	public String toString() {
		String returning = "";
		
		// Finds the description of the goods in the car
		for(int i=0; i < FreightCar.CarriedGoods.length; i++) {
			if (FreightCar.CarriedGoods[i][0].equals(goodsType())) {
				returning = FreightCar.CarriedGoods[i][0];
				break;
			}
		}
		
		return "Freight(" + returning + ")";
	}
}
