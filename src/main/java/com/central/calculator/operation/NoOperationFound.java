package com.central.calculator.operation;

import java.util.InputMismatchException;

public class NoOperationFound implements Operation {

	private char sign;

	public NoOperationFound(char sign){
		this.sign = sign;
	}
	public double calculateResult(double left, double right) {
		throw new InputMismatchException("Invalid operator sign: " + sign);
	}


}
