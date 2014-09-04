/**
 * Name: Chen Zhu (cz764)
 * Date: 10/22/2013
 * Assignment: #05
 * Summary: Test SmallInt class that have a variable of value that within the range of 0 and MAXVALUE, 
 * 			and can get decimal,binary and hexadecimal values of it
 * Assumptions: Explain any choices you made in the case where the assignment was not explicit.  This might be a list of things.
 * 
 */

import java.util.Scanner;

public class TestSmallInt {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		boolean validInput = false;
		
		while( !validInput ) {
			System.out.println("Please enter your small Integer " + "( Hint: " + 0 + " to " + SmallInt.MAXVALUE + " ) : ");
			String str = input.nextLine();
			try {
				n = Integer.parseInt(str);
				validInput = true;
			} catch (Exception e) {
				validInput = false;
			}
			
		}
		
		
		SmallInt smallInt = new SmallInt(n);
		
		System.out.println("Integer: " + smallInt.getDec());
		System.out.println("Integer in Binary: " + smallInt.getBin());
		System.out.println("Integer in Hexadecimal: " + smallInt.getHex());

	}

}
