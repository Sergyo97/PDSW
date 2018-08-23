package edu.eci.pdsw.OrderCalculator.model;

import java.util.*;

public class Order {
	List<Dish> orders;

    public Order() {
        orders = new LinkedList<>();
    }

    public void addDish(Dish d) {
        orders.add(d);
    }

    public List<Dish> getDishes() {
        return orders;
    }

    @Override
    public String toString(){
        return orders.toString();
    }
}
