package edu.eci.pdsw.OrderCalculator.main;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.OrderCalculator.injectors.ManagementModule;
import edu.eci.pdsw.OrderCalculator.model.Dish;
import edu.eci.pdsw.OrderCalculator.model.DishType;
import edu.eci.pdsw.OrderCalculator.model.Order;
import edu.eci.pdsw.OrderCalculator.model.OrderCalculatorException;
import edu.eci.pdsw.OrderCalculator.services.OrdersManager;

public class Pos {
	
    public static void main(String a[]) throws OrderCalculatorException {
    	
    	Injector injector = Guice.createInjector(new ManagementModule());
    	OrdersManager manager = injector.getInstance(OrdersManager.class);
        
        loadOrders(manager);

        System.out.println(manager.calculateOrderTotal(0));
        System.out.println(manager.calculateOrderTotal(1));
    }

    private static void loadOrders(OrdersManager manager) {

        Order o = new Order();
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.DRINK, "pepsi 300ml", 3900, 150));
        o.addDish(new Dish(DishType.PLATE, "hamburguesa", 8000, 730));
        o.addDish(new Dish(DishType.DRINK, "sprite 300ml", 2000, 140));

        manager.placeOrder(o);

        o = new Order();

        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.DRINK, "pepsi litro", 5000, 430));

        manager.placeOrder(o);
    }
}
