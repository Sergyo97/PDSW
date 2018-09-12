package edu.eci.pdsw.PrimeFaces;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@ApplicationScoped

public class BackingBean {
	
	private int number, attemps, award;
	private Integer temp;
	private ArrayList<Integer> listOfNumbers;
	private String message;
	private boolean win;

	public BackingBean() {
		restart();
	}

	public int getNumber() {		
		return number;		
	}

	public void setNumber(int number) {		
		if(!win)
			this.number = number;
	}

	public int getAttemps() {
		return attemps;
	}

	public void setAttemps(int attemps) {
		if (!win)
			this.attemps = attemps;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		if(!win)
			this.award = award;
	}
	
	public Integer getTemp() {
		return temp;		
	}

	public void setTemp(Integer temp) {
		if(!win)
			this.temp = temp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		if(!win)
			this.message = message;
	}
	
	public ArrayList<Integer> getListOfNumbers() {
		return listOfNumbers;
	}

	public void setListOfNumbers(ArrayList<Integer> listOfNumbers) {
		if (!win)
			this.listOfNumbers = listOfNumbers;
	}
	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	public void guess() {
		if(!win) {
			attemps += 1;
			listOfNumbers.add(temp);
		}		
		if(this.number == this.temp) {
			message = "You win! " + "The number was: " + temp;
			win = true;
		}else if (award > 0) {
			award -= 10000;
		}
	}
	
	public void restart() {
		number = (int) (Math.random()*100)+1;
		attemps = 0;
		award = 100000;
		temp = null;
		message = "Playing...";
		listOfNumbers = new ArrayList<Integer>();
		win = false;
	}
	
}
