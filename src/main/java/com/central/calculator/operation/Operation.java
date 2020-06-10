package com.central.calculator.operation;

@FunctionalInterface
public interface Operation {
	
	 double calculateResult(double left, double right);
}
