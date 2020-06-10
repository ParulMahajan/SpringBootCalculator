package com.central.calculator;

import java.util.HashMap;
import java.util.Map;

import com.central.calculator.operation.Addition;
import com.central.calculator.operation.Division;
import com.central.calculator.operation.Multiplication;
import com.central.calculator.operation.NoOperationFound;
import com.central.calculator.operation.Operation;
import com.central.calculator.operation.Subtraction;

public class Calculator {

    private Map<Character, Operation> operationMap = new HashMap<Character, Operation>();
    private static Calculator calculatorInstance = null;
    
    private Calculator() {
       System.out.println("Calc constructor called");

        operationMap.put('+', new Addition());
        operationMap.put('-', new Subtraction());
        operationMap.put('*', new Multiplication());
        operationMap.put('/', new Division());
    }
    
    public static Calculator getInstance() {
    	
    	if(calculatorInstance == null) {
    		calculatorInstance =new Calculator();
    	}
    	return calculatorInstance;
    }

    public double makeCalculation(double operand1, double operand2, char operation) {
    	
    	 Operation operationMapValue = operationMap.getOrDefault(operation,new NoOperationFound(operation));
         return operationMapValue.calculateResult(operand1, operand2);
    
    }
    
    public double makeCalculation(double operand1, double operand2, Operation operationMapValue) {
    	
        return operationMapValue.calculateResult(operand1, operand2);
   
   }
}
