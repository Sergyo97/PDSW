package edu.eci.pdsw.OrderCalculator.model;

public class Dish {
	private DishType type;
    private int price;
    private String name;
    private int calories;
    
    public Dish(DishType type, String name, int price, int calories) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public DishType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }	
    
    public int getCalories() {
    	return calories;
    }
}
