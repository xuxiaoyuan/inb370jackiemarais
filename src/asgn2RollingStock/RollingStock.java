/**
 * @author Marais Rossow
 * @studentid n8911495
 */
package asgn2RollingStock;
import asgn2Exceptions.TrainException;

public  class RollingStock {
	
	private Integer CGrossWeight;
	
	// Constructs a railway carriage with a specific gross weight (i.e., the carriage's weight when fully laden).
	public RollingStock(Integer grossWeight) throws TrainException {
		if (grossWeight == null || !(grossWeight > 0)) {
			throw new TrainException("Gross weight is invalid");
		}
		CGrossWeight = grossWeight;
	}
	
	// Returns the railway carriage's gross weight.
	public Integer getGrossWeight() {
		return CGrossWeight;
	}
	
	// Returns a human-readable description of this railway carriage.
	public String toString() {
		return "Rolling stock";
	}
}
