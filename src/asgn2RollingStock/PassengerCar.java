/**
 * @author Marais Rossow
 * @studentid n8911495
 */
package asgn2RollingStock;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.RollingStock;

public class PassengerCar extends RollingStock {
	
	private Integer numberOfSeats = 0;
	private Integer passengers = 0;
	
	// Constructs a passenger car with a known weight and a fixed number of seats.
	public PassengerCar(Integer grossWeight, Integer numberOfSeats) throws TrainException {
		super(grossWeight);
		if (numberOfSeats == null) {
			throw new TrainException("Invalid paramaters");
		} else {
			if (grossWeight < 0) { // gross not positive
				throw new TrainException("Gross weight not positive");
			}
			if (numberOfSeats < 0) { // number of seats not positive
				throw new TrainException("Number of seats not positive");
			}
		}
		
		// IF REACH HERE -  ALL TESTS PASSED
		this.numberOfSeats = numberOfSeats;
	}
	
	//  Removes the given number of passengers from this carriage.
	public void alight(Integer departingPassengers) throws TrainException {
		if (numberOfSeats() <= 0 || numberOnBoard() <= 0) {
			throw new TrainException("Not enough seats, or no passangers");
		} else {
			if (departingPassengers > numberOnBoard() || departingPassengers <= 0) {
				throw new TrainException("Not enough passengers to depart");
			}
		}
		passengers -= departingPassengers;
	}
	
	// Adds the given number of new passengers to the number on board the carriage.
	public Integer board(Integer newPassengers) throws TrainException {
		Integer returning = 0;
		Integer numberToBoard = 0;
		
		if (numberOfSeats() <= 0 || newPassengers <= 0) {
			throw new TrainException("Not enough seats, or no passengers");	
		} else {
			Integer avaliableSeats = numberOfSeats - numberOnBoard();
			if (newPassengers > avaliableSeats) {
				numberToBoard = avaliableSeats;
				returning = newPassengers - avaliableSeats;
			} else {
				numberToBoard = newPassengers;
			}
		}
		passengers += numberToBoard;
		return returning;
	}
	
	// Returns the number of seats installed on this carriage.
	public Integer numberOfSeats() {
		return numberOfSeats;
	}
	
	//  Returns the number of passengers currently on board this carriage.
	public Integer numberOnBoard() {
		return passengers;
	}
	
	// Returns a human-readable description of the passenger car.
	public String toString() {
		String returning = "";
		
		returning += numberOnBoard() + "/";
		returning += numberOfSeats();
		
		return "Passenger(" + returning + ")";
	}
}
