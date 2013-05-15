package test;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.RollingStock;
import asgn2Train.DepartingTrain;

public class main {
	public static void main(String[] args) throws TrainException {
		
		DepartingTrain dp = new DepartingTrain();
		dp.addCarriage(new Locomotive(10, "9D"));
		
		for (int i=0; i<2;i++) {
			dp.addCarriage(new PassengerCar(20, 10));
		}
		
		for (int i=0; i<3;i++) {
			dp.addCarriage(new FreightCar(20, "R"));
		}
		
		dp.board(12);
		System.out.println(dp.toString());	
	}
}
