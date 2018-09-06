package edu.eci.pdsw.PrimeFaces;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@ApplicationScoped

public class BackingBean {
	
	private int number, attemps, award;
	private Integer temp;
	private boolean win;
	
	public BackingBean() {
		restart();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAttemps() {
		return attemps;
	}

	public void setAttemps(int attemps) {
		this.attemps = attemps;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}
	
	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	public void guess() {
		attemps += 1;
		if(this.number == this.temp) {
			win = true;			
		}else {
			award -= 10000;
		}
	}
	
	public void restart() {
		number = (int) (Math.random()*100)+1;
		attemps = 0;
		award = 100000;
		temp = null;
		win = false;
	}
	
}
