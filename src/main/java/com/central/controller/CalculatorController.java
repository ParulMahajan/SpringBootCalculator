package com.central.controller;

import java.util.InputMismatchException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.central.calculator.Calculator;
import com.central.calculator.operation.Addition;
import com.central.calculator.operation.Division;
import com.central.calculator.operation.Multiplication;
import com.central.calculator.operation.Subtraction;

@RestController
public class CalculatorController {


	/*1st basic approach just to support 4 operations
	 * No need to create separate API's
	 */
	@RequestMapping(value="/calculate/{param1}/{param2}/{operand}", method=RequestMethod.GET,produces="application/json")
	public String getAddition(@PathVariable String param1, @PathVariable String param2, @PathVariable String operand){


		System.out.println(param1);
		System.out.println(param2);
		System.out.println(operand);

		try {

			// For very large numbers, we can use BigDecimal and BigInteger.
			double paramd1 = Double.parseDouble(param1);
			double paramd2 = Double.parseDouble(param2);

			if(operand.length() == 1 ) {
				char operandc1 = operand.charAt(0);
				if(operandc1 == '+' || operandc1 == '-' || operandc1 == '*' || operandc1 == '%') {

					// using single instance of calculator class.
					double result =  Calculator.getInstance().makeCalculation(paramd1, paramd2, operandc1);
					return String.valueOf(result);
				}
			}
			throw new InputMismatchException("Invalid operator sign: " + operand);

		}catch (Exception e) {
			System.out.println(e);
			return "invalid input";
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------
	
	
	/*2 approach to support calculation features.
	 * Separate API's for each functionality.
	 */
	@RequestMapping(value="/addition/{param1}/{param2}/", method=RequestMethod.GET)
	public String getAddition(@PathVariable String param1, @PathVariable String param2){

		System.out.println(param1);
		System.out.println(param2);
		try {

			// For very large numbers, we can use BigDecimal and BigInteger.
			double paramd1 = Double.parseDouble(param1);
			double paramd2 = Double.parseDouble(param2);
			
			double result =  Calculator.getInstance().makeCalculation(paramd1, paramd2, new Addition());
			return String.valueOf(result);
		
		}catch (Exception e) {
			System.out.println(e);
			return "invalid input";
		}
	}

	@RequestMapping(value="/subtraction/{param1}/{param2}", method=RequestMethod.GET)
	public String getSubtraction(@PathVariable String param1, @PathVariable String param2){

		System.out.println(param1);
		System.out.println(param2);
		try {

			// For very large numbers, we can use BigDecimal and BigInteger.
			double paramd1 = Double.parseDouble(param1);
			double paramd2 = Double.parseDouble(param2);
			
			double result =  Calculator.getInstance().makeCalculation(paramd1, paramd2, new Subtraction());
			return String.valueOf(result);
		
		}catch (Exception e) {
			System.out.println(e);
			return "invalid input";
		}
	}

	@RequestMapping(value="/multlipication/{param1}/{param2}", method=RequestMethod.GET)
	public String getMultiplication(@PathVariable String param1, @PathVariable String param2){

		System.out.println(param1);
		System.out.println(param2);
		try {

			// For very large numbers, we can use BigDecimal and BigInteger.
			double paramd1 = Double.parseDouble(param1);
			double paramd2 = Double.parseDouble(param2);
			
			double result =  Calculator.getInstance().makeCalculation(paramd1, paramd2, new Multiplication());
			return String.valueOf(result);
		
		}catch (Exception e) {
			System.out.println(e);
			return "invalid input";
		}
	}

	@RequestMapping(value="/division/{param1}/{param2}", method=RequestMethod.GET)
	public String getDivision(@PathVariable String param1, @PathVariable String param2){

		System.out.println(param1);
		System.out.println(param2);
		try {

			// For very large numbers, we can use BigDecimal and BigInteger.
			double paramd1 = Double.parseDouble(param1);
			double paramd2 = Double.parseDouble(param2);
			
			double result =  Calculator.getInstance().makeCalculation(paramd1, paramd2, new Division());
			return String.valueOf(result);
		
		}catch (Exception e) {
			System.out.println(e);
			return "invalid input";
		}
	}
}
