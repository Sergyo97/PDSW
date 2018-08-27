package edu.eci.pdsw.OrderCalculator.Generators;

import edu.eci.pdsw.OrderCalculator.model.*;
import org.quicktheories.core.*;
import static org.quicktheories.generators.SourceDSL.*;
import java.util.*;

public class OrderGenerator {
	private static Gen<List<Dish>> generateListPlates(){
		return lists().of(DishGenerator.Dishes()).ofSizeBetween(1, 20);
	}

	public static Gen<Order> orders(){
		return generateListPlates().map(list ->  {
			Order order=new Order();
			
			for(Dish d:list) {
				order.addDish(d);
			}
			return order;
		});
		
	}
	
	
}
