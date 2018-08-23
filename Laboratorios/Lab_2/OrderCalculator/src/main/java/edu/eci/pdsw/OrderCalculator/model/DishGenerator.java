package edu.eci.pdsw.OrderCalculator.model;

import org.quicktheories.core.*;
import org.quicktheories.generators.*;

import org.quicktheories.generators.SourceDSL.*;

public class DishGenerator {
	
	public static Gen<Dish> Dishes(){
		return null;
	}
	
	public static Gen<DishType> type(){
		return Generate.enumValues(DishType.class);
	}
	
	private static Gen<String> names(){
		return null;
	}
	
	private static Gen<Integer> prices(){
		return 
	}

}
