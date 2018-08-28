package edu.eci.pdsw.OrderCalculator.calculator.impl;

import com.google.inject.Inject;

import edu.eci.pdsw.OrderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.OrderCalculator.model.Dish;
import edu.eci.pdsw.OrderCalculator.model.Order;
import edu.eci.pdsw.OrderCalculator.validator.TaxValidator;

public class TaxBillCalculator implements BillCalculator{
	
	TaxValidator validator;
	
	@Inject
	TaxBillCalculator(TaxValidator validator) {
		this.validator = validator;
	}
	
	public int calculatePrice(Order o) {
        int total=0;
        for (Dish p : o.getDishes()){
            total += p.getPrice() * validator.getPercentage(p);          
            
        }
        return total;
    }

}
