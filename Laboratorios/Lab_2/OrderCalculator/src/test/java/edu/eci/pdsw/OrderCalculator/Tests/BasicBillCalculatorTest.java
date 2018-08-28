package edu.eci.pdsw.OrderCalculator.Tests;

import org.junit.Test;
import edu.eci.pdsw.OrderCalculator.model.*;
import edu.eci.pdsw.OrderCalculator.PBTClassifier;
import edu.eci.pdsw.OrderCalculator.Generators.*;
import edu.eci.pdsw.OrderCalculator.calculator.impl.BasicBillCalculator;

import static org.quicktheories.QuickTheory.qt;


public class BasicBillCalculatorTest {
	
	@Test
	public void correctSumPrices() {
		PBTClassifier pbtclassifier = new PBTClassifier("correctSumPrices");
		
		
		qt()
		.forAll(OrderGenerator.orders())
		.check(order -> {
			BasicBillCalculator basicBillCalculator = new BasicBillCalculator();
			int result = 0;
			for(Dish d:order.getDishes()) {
				result += d.getPrice();
			}
			if(result == basicBillCalculator.calculatePrice(order)) {
				pbtclassifier.collect("Correct Sum of Prices");
				return true;
			}else {
				pbtclassifier.collect("Incorrect Sum of prices");
				return false;
			}
		});
		pbtclassifier.results();
	}
	
}
