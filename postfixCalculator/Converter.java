/* Name: Chen Zhu
 * UID: N12166205
 * Date: 12/03/2013
 * Assignment: #9
 * Summary: Construct a postfixCalculator
 * Solution: Use ArrayStack to help converting infix expression to postfix expression
 * Assumptions: 
 * 1. we use a bounded arraystack for the expression converter implementation
 */

package postfixCalculator;

import java.util.Scanner;

import ch03.stacks.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Converter {
	String expression;
	
	public Converter (String expression) {
		this.expression = expression;
	}
	
	public String toPostFix () throws PostFixException {

		ArrayStack<String> stack = new ArrayStack<String>(20);	
		
		String pExpression = "";		// store the postfix expression
		String prevOperator; 	// compare with the operator tokening
		
		List<String> infix;		// get the parced infix expression
		
		try {
			infix = parce(expression.toCharArray());		// tokenize expression to a list	
		}
		catch (PostFixException ex) {
			throw new PostFixException(ex.getMessage());
		}
		
		for (String element: infix) {		// go through the tokenized infix expression
			if (isOperand(element))		// element is operands
				pExpression += element + " ";
			else if (element.equals("("))			// element is open parenthesis
				stack.push(element);
			else if (element.equals(")")) {		// element is close parenthesis
				if (stack.isEmpty())		// there should be elements in the stack
					throw new PostFixException("Mismatch parenthesis - stack underflow");
				else {
					/* pop out all the operators on the stack and append them to postFixExpression until 
					  we find an open parenthesis OR the stack is empty*/
					while (!stack.isEmpty()) {
						prevOperator = stack.top();		// get the operators on the stack
						if (!prevOperator.equals("(")) {		// if not met "(",we keep popping
							pExpression += prevOperator + " ";
							stack.pop();
						}
						else break;		// if met "(", we stop popping
					}
					if (stack.isEmpty())		// there should be at least an open parenthesis in the stack
						throw new PostFixException("Mismatch parenthesis - stack underflow");
					else
						stack.pop();	// pop the open parenthesis out
				}	
			}
			else {		// element is operators
				if (stack.isEmpty())	// the stack does not have any operator yet
					stack.push(element);
				else {
					/* if the top of stack does not have a lower precedence operator OR does not an "("
					OR the stack is not empty, we keep poping the stack*/
					while (!stack.isEmpty()) {
						prevOperator = stack.top();
						if (!isLowerPrecedence(prevOperator, element) && 
								!prevOperator.equals("(")) {
							pExpression += prevOperator + " ";
							stack.pop();	
						}
						else break;	
					}
					stack.push(element);		// add operator onto the stack
				}	
			}
		}	
		while (!stack.isEmpty() ) {		// after reading the tokenized infix exp, pop all operaters out stack
			if(!stack.top().equals("(")) {
				pExpression += stack.top() + " ";
				stack.pop();
			}
			else
				throw new PostFixException("Mismatch parenthesis - do not have close parenthesis");
		}
//		System.out.println("PostFix expression is: " + pExpression);
		return pExpression;
	}
	
	private List<String> parce(char[] expression) throws PostFixException {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < expression.length; i++) {
			char c = expression[i];		// get each element in the char array
			if (Character.isDigit(c)) {		// if we confront a digit
				String number = c + "";		// there might be an int more than 1 digit
				for (int j = i + 1; j < expression.length; j++) {
					if (Character.isDigit(expression[j])) {
						number += expression[j];		// get the digit of the number
						i = j;
					}
					else
						break;
				}
				result.add(number);			// add the number to the list
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' ||
					c == '(' || c == ')')	// confront operators
				result.add(c + "");
			else if (c == ' ');		// confront space, do nothing
			else
				throw new PostFixException("Illegal symbol: " + c);
		}
		return result;
	}
	
	private boolean isLowerPrecedence(String prevOperator, String operator) {
		if (operator.equals("^"))
			return (prevOperator.equals("+") || prevOperator.equals("-") || 
					prevOperator.equals("*") ||	prevOperator.equals("/") ||
					prevOperator.equals("("));
		else if (operator.equals("*") || operator.equals("/"))
			return (prevOperator.equals("+") || prevOperator.equals("-") ||
					prevOperator.equals("("));
		else if (operator.equals("+") || operator.equals("-"))
			return prevOperator.equals("(");
		else
			return false;
	}
	
	private boolean isOperand(String element) {
		try { 
	        Integer.parseInt(element); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

}
