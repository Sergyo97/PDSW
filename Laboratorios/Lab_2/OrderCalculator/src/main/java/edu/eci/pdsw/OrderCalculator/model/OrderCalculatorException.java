package edu.eci.pdsw.OrderCalculator.model;

public class OrderCalculatorException extends Exception {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderCalculatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderCalculatorException(String message) {
       super(message);
	}
}
