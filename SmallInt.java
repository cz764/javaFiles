/**
 * Name: Chen Zhu (cz764)
 * Date: 10/22/2013
 * Assignment: #05
 * Summary: Write a SmallInt class that have a variable of value that within the range of 0 and MAXVALUE, 
 * 			and can get decimal,binary and hexadecimal values of it
 * Assumptions: Explain any choices you made in the case where the assignment was not explicit.  This might be a list of things.
 * 
 */

public class SmallInt {
	private int value;
	public static final int MAXVALUE = 1000;
	
	// Constructor to check and assign new values to SmallInt value
	SmallInt(int newValue){
		if (newValue >= 0 && newValue <= MAXVALUE)
			value = newValue;
		else {
			System.out.println("Unfortunately...Your number is out of range!");
			value = 0;
		}
	}
	
	// get Decimal value
	String getDec() {
		String result = "" + value;
		return (result);
	}
	
	// get Binary value
	String getBin() {
		int number = value;
		
		// store the remainders divided by 2 in String result
		String result = "";  
		
		// store reversed digits in result to get the right Binary value
		String bResult = ""; 
		
		while (number > 0) {
			
			int d = number % 2;
			result += d;
			number /= 2;
			
		}
		
		if (result.equals("")) return "0";
		
		else {
			for (int i = result.length() - 1; i >= 0; i--){
				bResult += result.charAt(i);
			}
			return bResult;
		}
	}
	
	// get Hexadecimal value
	String getHex() {
		int number = value;
		
		// store the remainders divided by 16
		String result = ""; 
		
		// store reversed result to get the right Hexadecimal value
		String hResult = ""; 
		
		while(number > 0){
			
			int d = number % 16;
			
			if ( d >= 10 ) {
				
				// assign the digits larger than 10 inclusive
				switch (d){  
				case 10: 
					result += 'a';
					break;
				case 11:
					result += 'b';
					break;
				case 12:
					result += 'c';
					break;
				case 13:
					result += 'd';
					break;
				case 14:
					result += 'e';
					break;
				case 15:
					result += 'f';
					break;					
				}
			}
			
			else {
				result += d;
			}
			number /= 16;
		}
		
		if (result.equals("")) return "0";
		
		else {
			for ( int i = result.length() - 1; i >= 0; i--) {
				hResult += result.charAt(i);
			}
			return hResult;
		}
	}
	
}
