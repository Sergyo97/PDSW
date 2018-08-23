package edu.eci.pdsw.OrderCalculator.calculator.impl;

import edu.eci.pdsw.OrderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.OrderCalculator.model.*;

public class BasicBillCalculator implements BillCalculator {
	
	public int calculatePrice(Order o) {
        int total=0;
        for (Dish p : o.getDishes()){
            total += p.getPrice();
        }
        return total;
    }

}
