/*
 * Name: Chen Zhu
 * UID: N12166205
 * Date: 09/25/2013
 * Assignment: #2
 * Summary: Design my own calculator that can do operator "+,-,*,/", "c"used for clear, and "x" 
 * 			is used to exit, and can test error in the "/" operation if divisor is zero.
 * Solution: use while loop, switch statement is nested in the loop, and sentinel value "x"
 * 			to exit.
 */

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double answer = 0, cache = -1;
		
		// Receive the first number
		System.out.print("first number: ");
		double number1 = input.nextDouble();
		answer = number1;
		
		// Receive the operator
		System.out.print("op: ");
		String operator = input.next();
		boolean exit = (operator.equals("x"));  // "x" is for exit
		char op = operator.charAt(0);
				
		// Receive the second number
		System.out.println("second number: ");
		double number2 = input.nextDouble();
		
		// Doing the operation
		while ( !exit ){
			
			// Continue calculate
			if (op!='c' && cache == answer){
				number1 = answer;
				System.out.print("more number:");
				number2 = input.nextInt();		
			}
			
			switch (op){
			
			case '+': 
				answer = number1 + number2;
				System.out.println("answer: " + answer);
				break;
				
			case '-':
				answer = number1 - number2;
				System.out.println("answer: " + answer);
				break;
				
			case '*':
				answer = number1 * number2;
				System.out.println("answer: " + answer);
				break;
				
			case '/':
				if(number2 == 0) {  // Check if the divisor is 0 in "/" operation	
					System.out.println("cannot divide by zero");
				}
				else {
					answer = number1 / number2;
					System.out.println("answer: " + answer);
				}
				break;
				
			case 'c':
				answer = 0;  // "c" is for clean the cache
				System.out.println("answer: " + answer);
				break;
				
			// Default return an error message
			default : 
				System.out.print(operator + " is an Unknown operator\n");
			}
			
			// Cache is a flag used for indicate if it is the first calculation
			cache = answer;
			
			// Get more operator
			System.out.print("op: ");	
			operator = input.next();
			op = operator.charAt(0);
			
			// Ensure while loop
			exit = (operator.equals("x"));
			
		}
		System.out.println("END");

	}
	
}
