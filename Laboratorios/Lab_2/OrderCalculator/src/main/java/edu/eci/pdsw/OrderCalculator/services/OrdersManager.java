package edu.eci.pdsw.OrderCalculator.services;

import java.util.*;

import edu.eci.pdsw.OrderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.OrderCalculator.model.*;

public class OrdersManager {

	BasicBillCalculator cal = new BasicBillCalculator();
    List<Order> orders;

    public OrdersManager() {
        orders = new LinkedList<>();
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
