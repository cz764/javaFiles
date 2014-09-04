/* Name: Chen Zhu
 * UID: N12166205
 * Date: 12/13/2013
 * Assignment: #10
 * Summary: implement expression tree
 * Solution: 
 * Assumptions: 
 * 1. 
 */

package expressionTrees;

public class TNode<T> {
	protected T info;						// the info in the expression tree node
	protected TNode<T> left;			// a link to the left child node
	protected TNode<T> right;		// a link to the right child node
	
	public TNode (T info) {				// constructor to create a new TNode
		this.info = info;
		left = null;
		right = null;
	}
	
	public T getInfo() {						// get the info of this node
		return info;
	}
	
	public void setInfo(T info) {		// set the info of this node
		this.info = info;
	}
	
	public void setLeft(TNode<T> link) {	// set left link of  the node
		this.left = link;
	}
	
	public void setRight(TNode<T> link) {	// set right link of the node
		this.right = link;
	}
	
	public TNode<T> getLeft() {			// get the left link of the node
		return left;
	}
	
	public TNode<T> getRight() {		// get the right link of the node
		return right;
	}
	
	public String toString() {
		return "" + info;
	}
}
