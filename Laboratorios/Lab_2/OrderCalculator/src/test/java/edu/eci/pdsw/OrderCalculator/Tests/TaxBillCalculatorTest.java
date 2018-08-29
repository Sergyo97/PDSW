package edu.eci.pdsw.OrderCalculator.Tests;

import static org.quicktheories.QuickTheory.qt;

import org.junit.Test;
import edu.eci.pdsw.OrderCalculator.model.*;
import edu.eci.pdsw.OrderCalculator.validator.impl.SpecialRegimeTaxValidator;
import edu.eci.pdsw.OrderCalculator.validator.impl.StandardTaxValidator;
import edu.eci.pdsw.OrderCalculator.PBTClassifier;
import edu.eci.pdsw.OrderCalculator.Generators.*;
import edu.eci.pdsw.OrderCalculator.calculator.impl.TaxBillCalculator;

public class TaxBillCalculatorTest {
	
	@Test
	public void correctSumPricesStandardTaxValidator() {
		PBTClassifier pbtclassifier = new PBTClassifier("correctSumPricesStandardTaxValidator");
		
		
		qt()
		.forAll(OrderGenerator.orders())
		.check(order -> {
			TaxBillCalculator taxBillCalculator = new TaxBillCalculator(new StandardTaxValidator());
			int result = 0;
			for(Dish d:order.getDishes()) {
				result += d.getPrice() * 1.19f;
			}
			if(result == taxBillCalculator.calculatePrice(order)) {
				pbtclassifier.collect("Correct Sum of Prices");
				return true;
			}else {
				pbtclassifier.collect("Incorrect Sum of prices");
				return false;
			}
		});
		pbtclassifier.results();
	}
	
	@Test
	public void correctSumPricesSpecialRegimeTaxValidator() {
		PBTClassifier pbtclassifier = new PBTClassifier("correctSumPricesSpecialRegimeTaxValidator");
		
		
		qt()
		.forAll(OrderGenerator.orders())
		.check(order -> {
			TaxBillCalculator taxBillCalculator = new TaxBillCalculator(new SpecialRegimeTaxValidator());
			int result = 0;
			for(Dish d:order.getDishes()) {
				if(d.getCalories() > 1000 && d.getType().equals(DishType.DRINK)) {
					result += d.getPrice() * 1.29f;
				}else {
					result += d.getPrice() * 1.19f;
				}
			}
			if(result == taxBillCalculator.calculatePrice(order)) {
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
