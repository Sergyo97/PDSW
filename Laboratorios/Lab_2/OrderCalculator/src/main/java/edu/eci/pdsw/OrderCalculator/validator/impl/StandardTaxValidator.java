package edu.eci.pdsw.OrderCalculator.validator.impl;

import edu.eci.pdsw.OrderCalculator.model.Dish;
import edu.eci.pdsw.OrderCalculator.validator.TaxValidator;

public class StandardTaxValidator implements TaxValidator {

	@Override
	public float getPercentage(Dish d) {
		return 1.19f;
	}

}
