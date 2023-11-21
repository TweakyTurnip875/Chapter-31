package com.noah.main;

public class Calculate {
	private double investmentAmount;
	private int numberOfYears;
	private double annualInterestRate;
	
	private double futureValue;
	private double monthlyInterestRate;
	
	public Calculate(double investmentAmount, int numberOfYears, double annualInterestRate) {
		this.investmentAmount = investmentAmount;
		this.numberOfYears = numberOfYears;
		this.annualInterestRate = annualInterestRate;
		
		calculateMonthlyInterestRate();
	}
	
	public double getFutureValue() {
		futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate), (numberOfYears * 12));
		return futureValue;
	}
	
	public int getNumberOfYears() {
		return numberOfYears;
	}
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
		calculateMonthlyInterestRate();
	}
	private void calculateMonthlyInterestRate() {
		monthlyInterestRate = annualInterestRate / 1200;
	}
}
