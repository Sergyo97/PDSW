package edu.eci.pdsw.OrderCalculator.Generators;

import edu.eci.pdsw.OrderCalculator.model.*;
import org.quicktheories.core.*;
import static org.quicktheories.generators.SourceDSL.*;
import java.util.*;

public class OrderGenerator {
	
	public static Gen<List<Dish>> generateListPlates(){
		return lists().of(DishGenerator.Dishes()).ofSizeBetween(0, 20);
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
