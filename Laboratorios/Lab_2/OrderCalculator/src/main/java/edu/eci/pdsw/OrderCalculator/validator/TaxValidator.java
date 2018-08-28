package edu.eci.pdsw.OrderCalculator.validator;

import edu.eci.pdsw.OrderCalculator.model.Dish;

public interface TaxValidator {

	public float getPercentage(Dish d);
	
}
