package edu.eci.pdsw.OrderCalculator.calculator;

import edu.eci.pdsw.OrderCalculator.model.Order;

public interface BillCalculator {
	
	public int calculatePrice(Order o);
	
}
