/**
 * @author Marais Rossow
 * @studentid n8911495
 */
package asgn2Train;
import java.util.ArrayList;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.RollingStock;

public class DepartingTrain {
	
	private ArrayList<RollingStock> carriages;
	public Integer MustPull = 0;
	
	// Constructs a (potential) train object containing no carriages (yet).
	public DepartingTrain() {
		carriages = new ArrayList<RollingStock>();
	}
	
	// Adds a new carriage to the end of the train.
	public void addCarriage(RollingStock newCarriage) throws TrainException {
		if (carriages.size() > 0 && !(carriages.get(0) instanceof Locomotive)) {
			throw new TrainException("The first carriage must be a Locomotive");
		} else if (numberOnBoard() > 0) {
			throw new TrainException("There are passangers on the train");
		}
		
		for (int i = 1; i < carriages.size(); i++) {
			if (newCarriage instanceof Locomotive) { // if the code reaches here, we are guaranteed that first car is a locomotive
				throw new TrainException("There can only be one Locomotive");
			}
			if (newCarriage instanceof PassengerCar) {
				if (((PassengerCar)newCarriage).numberOnBoard() > 0) { // if there are passengers on board
					throw new TrainException("Cannot add carriage, there are people on board.");
				} else if((carriages.get(i)) instanceof FreightCar) {
					throw new TrainException("Freight carriage cannot be before passenger carriage");
				}
			}
		}
		
		// IF REACH HERE -  ALL TESTS PASSED
		MustPull += newCarriage.getGrossWeight();
		carriages.add(newCarriage);
	}
	
	// Adds the given number of people to passenger carriages on the train.
	public Integer board(Integer newPassengers) throws TrainException {
		Integer leftOverPassengers = newPassengers;
		boolean testing = false;
		if (carriages.size() == 0) {
			return leftOverPassengers;
		}
		for (int i = 1; i < carriages.size(); i++) {
			if (carriages.get(i) instanceof PassengerCar) {
				leftOverPassengers = ((PassengerCar) carriages.get(i)).board(leftOverPassengers);
				testing = true;
			}
		}
		if (testing == false) {
			throw new TrainException("There isnt a passanger carriage.");
		}
		return leftOverPassengers;
	}
	
	// Returns the first carriage on the train (which must be a locomotive).
	public RollingStock firstCarriage() {
		
		return null;
	}
	
	// Returns the next carriage in the train after the one returned by the immediately preceding call to either this method or method firstCarriage.
	public RollingStock nextCarriage() {
		
		return null;
	}
	
	// Returns the total number of seats on the train (whether occupied or not), counting all passenger cars.
	public Integer numberOfSeats() {
		Integer returning = 0;
		if (carriages.size() == 0) {
			return returning;
		}
		for (int i = 1; i < carriages.size(); i++) {
			if (carriages.get(i) instanceof PassengerCar) {
				returning += ((PassengerCar) carriages.get(i)).numberOfSeats();
			}
		}
		return returning;
	}
	
	// Returns the total number of passengers currently on the train, counting all passenger cars.
	public Integer numberOnBoard() {
		Integer returning = 0;
		if (carriages.size() == 0) {
			return returning;
		}
		for (int i = 1; i < carriages.size(); i++) {
			if (carriages.get(i) instanceof PassengerCar) {
				returning += ((PassengerCar) carriages.get(i)).numberOnBoard();
			}
		}
		return returning;
	}
	
	// Removes the last carriage from the train.
	public void removeCarriage() throws TrainException {
		if (numberOnBoard() > 0) {
			throw new TrainException("There are passangers on the train");
		} else if(carriages.size() == 0) {
			throw new TrainException("There arn't any carriages to remove");
		}
		carriages.remove(carriages.size()-1);
	}
	
	// Returns a human-readable description of the entire train.
	public String toString() {
		String returning = "";
		if (carriages.size() == 0) {
			return returning;
		}
		for (int i = 0; i < carriages.size()-1; i++) {
			returning += carriages.get(i).toString() + "-";
		}
		returning += carriages.get(carriages.size()-1).toString();
		return returning;
	}
	
	// Returns whether or not the train is capable of moving.
	public boolean trainCanMove() {
		if (((Locomotive) carriages.get(0)).power() >= MustPull || (carriages.size() == 1 && !(carriages.get(0) instanceof Locomotive))) {
			return true;
		}
		return false;
	}
}
