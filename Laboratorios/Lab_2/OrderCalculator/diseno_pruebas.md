#	Diseño de pruebas 

##	BasicBillCalculator

``` java
	public class ManagementModule extends AbstractModule {
	
	 @Override 
	 protected void configure() {

		 bind(BillCalculator.class).to(BasicBillCalculator.class);
		 bind(TaxValidator.class).to(StandardTaxValidator.class);
		 
	 	}
	 
	}
```
###	Resultado
### 21400
### 27500


###	TipBillCalculator
```java
		public class ManagementModule extends AbstractModule {
	
	 @Override 
	 protected void configure() {

		 bind(BillCalculator.class).to(BasicBillCalculator.class);
		 bind(TaxValidator.class).to(StandardTaxValidator.class);
		 
	 	}
		 
	}
```
### Resultado
### 23540
### 30250


## TaxBillCalculator with StandardTaxValidator
```java
	public class ManagementModule extends AbstractModule {
	
	 @Override 
	 protected void configure() {

		 bind(BillCalculator.class).to(TaxBillCalculator.class);
		 bind(TaxValidator.class).to(StandardTaxValidator.class);
		 
	 	}
	 
	}
```
### Resultado
### 25466
### 32725

## TaxBillCalculator with SpecialRegimeTaxValidator
```java
	public class ManagementModule extends AbstractModule {
	
	 @Override 
	 protected void configure() {

		 bind(BillCalculator.class).to(TaxBillCalculator.class);
		 bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
		 
	 	}
	 
	}
	
```
### Resultado
### 25466
### 32725