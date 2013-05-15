/**
 * @author Marais Rossow
 * @studentid n8911495
 */
package asgn2Exceptions;

@SuppressWarnings("serial")
public class TrainException extends Exception {
	
	public TrainException(String msg) {
		super("Train Exception: " + msg);
	}
}
