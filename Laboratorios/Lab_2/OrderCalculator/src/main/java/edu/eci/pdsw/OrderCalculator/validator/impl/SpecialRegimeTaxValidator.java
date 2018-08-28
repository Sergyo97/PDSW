package edu.eci.pdsw.OrderCalculator.validator.impl;

import edu.eci.pdsw.OrderCalculator.model.Dish;
import edu.eci.pdsw.OrderCalculator.model.DishType;
import edu.eci.pdsw.OrderCalculator.validator.TaxValidator;

public class SpecialRegimeTaxValidator implements TaxValidator {

	@Override
	public float getPercentage(Dish d) {
		if(d.getCalories() > 1000 && d.getType().equals(DishType.DRINK)) {
			return 1.29f;
		}else {
			return 1.19f;
		}
	}

}
