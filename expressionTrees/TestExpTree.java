package expressionTrees;

import java.util.Scanner;

import postfixCalculator.*;

public class TestExpTree {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExpTree<String> tree = new ExpTree<String>();
		Converter converter;

		int result =0;																	// get the answer of entered expression
		boolean continueInput = true;										// handle postfixException
		String exp = "";																// get the postfix expression
		String infix = "";
		
		// get the user input for the infix expression
		do {		
			System.out.println("Enter an infix expression (press Enter to exit) > ");
			infix = input.nextLine();	
			// evaluate the postfix expression to make sure the expression is valid
			if (infix.equals(""))
				break;
			converter = new Converter(infix);						// to convert the postfix expression			
			try {
				exp = converter.toPostFix();							// get the postfix expression
				result = Calculator.evaluate(exp);	
				continueInput = false;
			} catch (PostFixException ex) {
				System.out.println(ex.getMessage());
			} 
		}while(continueInput);	
			
		while (!infix.equals("")) {	
			// build the expression tree using the correct postfix expression
			tree = tree.build(exp);																
			
			System.out.println("Postfix expression by converter: " + exp);
			System.out.println("Answer by calculator is: " + result);
			System.out.print("Postfix Expression by expression tree is: " );
			tree.postfix();
			System.out.print("Prefix Expression by expression tree is: ");
			tree.prefix();
			System.out.print("Infix Expression by expression tree is: ");
			tree.infix();
			System.out.print("Answer by expression tree evaluation is: " + tree.evaluate());		
			
			// get another user input for the infix expression
			do {		
				System.out.println("\n\nEnter an infix expression (press Enter to exit) > ");
				infix = input.nextLine();	
				// evaluate the postfix expression to make sure the expression is valid
				if (infix.equals(""))
					break;
				converter = new Converter(infix);						// to convert the postfix expression			
				try {
					exp = converter.toPostFix();							// get the postfix expression
					result = Calculator.evaluate(exp);	
					continueInput = false;
				} catch (PostFixException ex) {
					System.out.println(ex.getMessage());
				} 
			}while(continueInput);						
		}
		System.out.println("Program complete.");
	}
}
