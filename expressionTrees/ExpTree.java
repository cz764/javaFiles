/* Name: Chen Zhu
 * UID: N12166205
 * Date: 12/17/2013
 * Assignment: #10
 * Summary: Converting a postfix expression to build an expression tree, and perform preorder, in-order, and post-order traversal.
 * Solution: Use TNode<T> to indicate each node of the expression tree, use a stack to help to build an expression tree.
 * Assumptions: 
 * 1. we use a bounded arraystack for the expression converter implementation
 * 2. we use the stack imported from ch03.stacks
 * 3. we use a Converter class created by last homework
 */

package expressionTrees;

import postfixCalculator.*;
import ch03.stacks.*;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class ExpTree<T> {
	private TNode<T> root;					// the root of the expression tree
	
	public ExpTree() {	
		root = null;
	}
	
	public ExpTree(T element) {
		root = new TNode<T>(element);
	}
	
	public ExpTree<T> build(String exp) throws PostFixException {
		BoundedStackInterface<ExpTree<T>> stack = new ArrayStack<ExpTree<T>>();		// stack to hold the tokens
		Scanner tokenizer = new Scanner(exp);
		
		while(tokenizer.hasNext()) {															// loop through each token in the postfix expression
			if (tokenizer.hasNextInt()) {														// confronting an operand
				String number = String.valueOf(tokenizer.nextInt());
			stack.push(new ExpTree<T>((T)number));		// create a newnode and push it onto stack
			}
			else {																							// confronting an operator
				ExpTree<T> left;
				ExpTree<T> right;
				T operator = (T)tokenizer.next();
				ExpTree<T> operatorNode = new ExpTree<T>(operator);
				
				right = stack.top();																	// get the second operand for the operator
				stack.pop();
				left = stack.top();																		// get the first operand for the operator
				stack.pop();
				
				operatorNode.root.setLeft(left.root);										// append the operator1 as left child of the operator node
				operatorNode.root.setRight(right.root);								// append the operator2 as right child of the operator node
				
				stack.push(operatorNode);													// push the operator node onto the stack
			}// finished going over the postfix expression
		}
		return stack.top();
	}
	
	public void infix() {
		recInfix(root);
		System.out.println();
	}
	
	private void recInfix(TNode<T> node) {
		if (node.left != null) {
			System.out.print("( ");
			recInfix(node.left);
		}
		System.out.print(node + " ");
		if (node.right != null) {
			recInfix(node.right);
			System.out.print(" )");
		}
	}
	
	public  void prefix() {
		recPrefix(root);
		System.out.println();
	}
	
	private void recPrefix(TNode<T> node) {
		if (node != null) {
			System.out.print(node + " ");
			recPrefix(node.left);
			recPrefix(node.right);
		}
	}
	
	public void postfix() {
		recPostfix(root);
		System.out.println();
	}
	
	private void recPostfix(TNode<T> node) {
		if (node != null) {
			recPostfix(node.left);
			recPostfix(node.right);
			System.out.print(node + " ");
		}
	}
	
	public int evaluate() {
		return evaluate(root);
	}
	
	private int evaluate(TNode<T> node) {
		int result = 0;
		
		if (node.left == null) 	{								// confronting an operand
			return (Integer.parseInt((String) node.getInfo()));
		}
		else {															// confronting an operator
			int left = evaluate(node.left);
			int right = evaluate(node.right);
			switch (((String)node.getInfo()).charAt(0)) {
				case '+':
					return left + right;
				case '-':
					return left - right;
				case '*':
					return left * right;
				case '/':
					return left / right;
				case '^':
					return (int) Math.pow(left, right);
			}
		}
		return result;
	}
	
}
