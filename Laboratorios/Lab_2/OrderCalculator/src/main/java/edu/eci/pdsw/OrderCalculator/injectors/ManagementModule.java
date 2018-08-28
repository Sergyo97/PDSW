package edu.eci.pdsw.OrderCalculator.injectors;

import com.google.inject.AbstractModule;

import edu.eci.pdsw.OrderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.OrderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.OrderCalculator.calculator.impl.TipBillCalculator;
import edu.eci.pdsw.OrderCalculator.validator.TaxValidator;
import edu.eci.pdsw.OrderCalculator.validator.impl.SpecialRegimeTaxValidator;
import edu.eci.pdsw.OrderCalculator.validator.impl.StandardTaxValidator;

public class ManagementModule extends AbstractModule {
	
	 @Override 
	 protected void configure() {

		 bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
		 
		 bind(BillCalculator.class).to(BasicBillCalculator.class);
		 
	 }

}
