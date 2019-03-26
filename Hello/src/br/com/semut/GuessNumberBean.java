package br.com.semut;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class GuessNumberBean implements Serializable {
	private static final long serialVersionUID = 4199646154772344321L;
	
	Integer randomInt = null;
	Integer userNumber = null;
	String response = null;
	private int max = 10;
	private int min = 0;
	
	public GuessNumberBean() {
		Random randomGR = new Random();
		randomInt = new Integer(randomGR.nextInt(max + 1));
		System.out.println("Duke's number: " + randomInt);
	}

	public Integer getUserNumber() {
		return userNumber;
	}
	
	public String getResponse() {
		if ((userNumber == null) || (userNumber.compareTo(randomInt) != 0)) {
			return "Sorry, " + userNumber + " is incorrect";
		} else {
			return "Yay! You got it!";
		}
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	
	
}
