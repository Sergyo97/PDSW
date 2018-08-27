package edu.eci.pdsw.OrderCalculator.Generators;

import org.quicktheories.core.*;
import org.quicktheories.generators.*;

import edu.eci.pdsw.OrderCalculator.model.Dish;
import edu.eci.pdsw.OrderCalculator.model.DishType;

import static org.quicktheories.generators.SourceDSL.*;

public class DishGenerator {
	
	public static Gen<Dish> Dishes() {
		return types().zip(names(), prices(), (type, name, price)
				-> new Dish(type, name, price));
	}
	
	public static Gen<DishType> types() {
		return Generate.enumValues(DishType.class);
	}
	
	public static Gen<Integer> prices() {
		return integers().between(1000, 90000);
	}
	
	public static Gen<String> names() {
		return strings().betweenCodePoints(65, 122).ofLengthBetween(5, 30);
	}
}
