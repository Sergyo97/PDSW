package edu.eci.pdsw.OrderCalculator.calculator.impl;

import edu.eci.pdsw.OrderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.OrderCalculator.model.Dish;
import edu.eci.pdsw.OrderCalculator.model.Order;

public class TipBillCalculator implements BillCalculator {

	public int calculatePrice(Order o) {
		int total=0;
        for (Dish p : o.getDishes()){
            total += p.getPrice();
        }
        if(total > 15000) {
        	total += total*0.1;
        }
        return total;
	}

}
