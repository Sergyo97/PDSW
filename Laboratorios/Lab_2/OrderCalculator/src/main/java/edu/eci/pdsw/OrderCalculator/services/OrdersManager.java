package edu.eci.pdsw.OrderCalculator.services;

import java.util.*;

import com.google.inject.Inject;

import edu.eci.pdsw.OrderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.OrderCalculator.model.*;

public class OrdersManager {

	BillCalculator cal;
    List<Order> orders = new LinkedList<>();

    @Inject
    OrdersManager(BillCalculator cal) {
    	this.cal = cal;
    }
    
    public void placeOrder(Order o) {
        orders.add(o);
    }

    public Order findOrder(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return orders.get(n);
    }

    public int calculateOrderTotal(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return cal.calculatePrice(orders.get(n));
    }
	
}
