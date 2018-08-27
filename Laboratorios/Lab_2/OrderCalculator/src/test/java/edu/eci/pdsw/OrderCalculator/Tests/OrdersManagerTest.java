package edu.eci.pdsw.OrderCalculator.Tests;

import org.junit.Test;
import edu.eci.pdsw.OrderCalculator.model.*;
import edu.eci.pdsw.OrderCalculator.services.OrdersManager;
import edu.eci.pdsw.OrderCalculator.PBTClassifier;
import edu.eci.pdsw.OrderCalculator.Generators.*;
import static org.quicktheories.QuickTheory.qt;

public class OrdersManagerTest {

	@Test
	public void notEmptyOrder() {
		PBTClassifier pbtclassifier = new PBTClassifier("notEmptyOrder");
		
		
		qt()
			.forAll(OrderGenerator.orders())
			.check(orden -> {
				if(orden.getDishes().size()>0) {
					pbtclassifier.collect("Order not Empty");
					return true;
				}
				pbtclassifier.collect("Order Empty");
				return false;				
			});
		pbtclassifier.results();
	}
	
	
	@Test
	public void findOrder() {
		PBTClassifier pbtclassifier = new PBTClassifier("findOrder");
		
		
		qt()
		.forAll(OrderGenerator.orders())
		.check(orden -> {
			OrdersManager manager= new OrdersManager();
			manager.placeOrder(orden);
			try {
				if(manager.findOrder(0)==orden ) {
					pbtclassifier.collect("Order found");
					return true;
				}				
			} catch (OrderCalculatorException e) {
				return e.getMessage() == "Order not found";
			}
			pbtclassifier.collect("Order not found");
			return false;	
		});
		pbtclassifier.results();
	}
	
	
	@Test
	public void calculateOrder() {
		PBTClassifier pbtclassifier = new PBTClassifier("findOrder");
		
		
		qt()
		.forAll(OrderGenerator.orders())
		.check(orden -> {
			OrdersManager manager= new OrdersManager();
			manager.placeOrder(orden);
			int result=0;
			for(Dish d:orden.getDishes()) {
				result += d.getPrice();
			}
			try {
				if(result == manager.calculateOrderTotal(0)) {
					pbtclassifier.collect("Correct calculate order");
					return true;
				}
			}catch (OrderCalculatorException e) {
				return e.getMessage() == "Order not found";
			}
			pbtclassifier.collect("Incorrect calculate order");
			return false;
		});
		pbtclassifier.results();
	}

}
	

