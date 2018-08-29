package edu.eci.pdsw.OrderCalculator.Tests;

import static org.quicktheories.QuickTheory.qt;

import org.junit.Test;
import edu.eci.pdsw.OrderCalculator.model.*;
import edu.eci.pdsw.OrderCalculator.PBTClassifier;
import edu.eci.pdsw.OrderCalculator.Generators.*;
import edu.eci.pdsw.OrderCalculator.calculator.impl.TipBillCalculator;

public class TipBillCalculatorTest {
	
	@Test
	public void correctSumPrices() {
		PBTClassifier pbtclassifier = new PBTClassifier("correctSumPrices");
		
		
		qt()
		.forAll(OrderGenerator.orders())
		.check(order -> {
			TipBillCalculator tipBillCalculator = new TipBillCalculator();
			int result = 0;
			for(Dish d:order.getDishes()) {
				result += d.getPrice();
			}
			if(result > 15000) {
	        	result += result * 0.1;
	        }
			if(result == tipBillCalculator.calculatePrice(order)) {
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
