/* Name: Chen Zhu
 * UID: N12166205
 * Date: 12/03/2013
 * Assignment: #9
 * Summary: Illustrate game of life
 * Solution: use two 2-D array to store the state of world
 * Assumptions: 
 * 1. we imported a package of the book ch03.stack and use the stack
 * 2. we assume all operands are integers, that means during a "/" operation, we only get integer
 */

package postfixCalculator;

import java.util.Scanner;
import ch03.stacks.*;

public class Calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		String line = null;		// get the input infix expression
		String pExpression = null;	// get the postfix expression
		String more = null; 	// used to stop or continue processing
		
		int result; 			// result of the evaluation
		
		do {
			// get next expression to be evaluated
			System.out.println("Enter a infix expression to be evaluated: ");
			line = input.nextLine();
			try {
				Converter converter = new Converter(line);
				pExpression = converter.toPostFix();
				result = evaluate(pExpression);		// get the result
				System.out.println();
				System.out.println("Result = " + result);
			}
			catch (PostFixException ex) {
				System.out.println();
				System.out.println("Error in exception - " + ex.getMessage());
			}
			
			// determine if there is another expression to process
			System.out.println();
			System.out.println("Evaluate another expression? (Y = yes): ");
			more = input.nextLine();
			System.out.println();			
		} while (more.equalsIgnoreCase("y"));
		
		System.out.println("Program completed.");
	}
	
	@SuppressWarnings("unchecked")
	public static int evaluate (String expression) throws PostFixException {
		
		@SuppressWarnings("rawtypes")
		BoundedStackInterface stack = new ArrayStack(50);
		
		int value;		// get next operand
		String operator;		// get next operator
		
		int operand1;		// the 1st operand need to be evaluated
		int operand2;		// the 2nd operand need to be evaluated
		
		int result = 0;
		
		Scanner tokenizer = new Scanner(expression);	// scan the expression to tokenize it
		
		while (tokenizer.hasNext()) {		// the expression have not finished
			
			if (tokenizer.hasNextInt()) {		// the next token is int(Operand)
				value = tokenizer.nextInt();	// process operand
				if (stack.isFull())
					throw new PostFixException("Too many operands - Stack overflow");
				stack.push(value);
			}
			else {		// the next token is operator
				
				operator = tokenizer.next();	// process operator
				
				if (stack.isEmpty())		// we need to pop stack to get operands, check exception
					throw new PostFixException("Not enough operands - stack underflow");
				operand2 = (Integer)stack.top();		// get the 2nd operand from stack
				stack.pop();
				
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands - stack underflow");
				operand1 = (Integer)stack.top();	// get the 1st operand
				stack.pop();
				
				if (operator.equals("+")) 	// perform operation
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result = operand1 - operand2;
				else if (operator.equals("*"))
					result = operand1 * operand2;
				else if (operator.equals("/"))
					result = operand1 / operand2;
				else if (operator.equals("^"))
					result = (int) Math.pow(operand1, operand2);
//				else
//					throw new PostFixException("Illegal symbol: " + operator);
				
				stack.push(result);		// push result of the former operation onto stack
			}
		}	// finished scanning expression
		
		if (stack.isEmpty())		// obtain final result from the stack
			throw new PostFixException("Not enough operands - stack underflow");
		result = (Integer)stack.top();
		stack.pop();
		
		if (!stack.isEmpty())		// stack should now be empty
			throw new PostFixException("Too many operands - operands left over");
		
		return result;
	}
}
