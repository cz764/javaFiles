/*
 * Name: Chen Zhu
 * UID: N12166205
 * Date: 09/18/2013
 * Assignment: #01
 * Summary: When receive the user input of two time values, compute the difference between them.
 * 			Display the time values as integers. 
 * Solution: Isolate the time values to different parts as hours, minutes and seconds. 
 * 			Convert the time amount into total seconds, then compute the difference in terms of seconds.
 * 			Compute the difference in term of seconds to time value  in terms of HHMMSS.
 */

import javax.swing.JOptionPane;

public class TimeDifferenceComputing {

	public static void main(String[] args) {
		
		String stringTimeValue1,stringTimeValue2;
		
		// Receive first input as time value
		stringTimeValue1 = JOptionPane.showInputDialog(null,
				"Enter first 6 digit integer as time value", "Input 1st Time Value", 
				JOptionPane.QUESTION_MESSAGE);
		int timeValue1 = Integer.parseInt(stringTimeValue1);
		
		// Isolate hours from each value
			int timeHour1 = timeValue1 / 10000;
				
		// Isolate minutes from each value
			int timeMinute1 = timeValue1 % 10000 / 100;
		
		// Isolate seconds from each value
			int timeSecond1 = timeValue1 % 10000 % 100;

		// Evaluate the first input
			while (timeHour1 > 99 || timeMinute1 > 59 || timeSecond1 > 59){
				stringTimeValue1 = JOptionPane.showInputDialog(null, "First time value is invalid,\n "
						+ "Please enter again: \n"
						+ "(*Hint: 6 digits at most, Minutes & Seconds cannot exceed 59.)", 
						"Input error fix", JOptionPane.WARNING_MESSAGE);
				timeValue1 = Integer.parseInt(stringTimeValue1);
				timeHour1 = timeValue1 / 10000;
				timeMinute1 = timeValue1 % 10000 / 100;
				timeSecond1 = timeValue1 % 10000 % 100;
				}
				
		// Receive second input as time value
		stringTimeValue2 = JOptionPane.showInputDialog(null,
				"Enter second 6 digit integer as time value", "Input 2nd Time Value", 
				JOptionPane.QUESTION_MESSAGE);
		int timeValue2 = Integer.parseInt(stringTimeValue2);
		
		// Isolate hours from each value
		int timeHour2 = timeValue2 / 10000;
						
		// Isolate minutes from each value
		int timeMinute2 = timeValue2 % 10000 / 100;
		
		// Isolate seconds from each value
		int timeSecond2 = timeValue2 % 10000 % 100;
			
		// Evaluate the second input
		while (timeHour2 > 99 || timeMinute2 > 59 || timeSecond2 > 59){
			stringTimeValue2 = JOptionPane.showInputDialog(null, "Second time velue is invalid, \n"
					+ "Please enter again: \n"
					+ "*Hint: 6 digits at most, Minutes & Seconds cannot exceed 59 ", 
					"Input error fix", JOptionPane.WARNING_MESSAGE);
			timeValue2 = Integer.parseInt(stringTimeValue2);
			timeHour2 = timeValue2 / 10000;
			timeMinute2 = timeValue2 % 10000 / 100;
			timeSecond2 = timeValue2 % 10000 % 100;
		}
		
		//Display the converted time
		System.out.println("First time entered: " + timeValue1 + " which is "+ timeHour1 + " : "
				+ timeMinute1 + " : " + timeSecond1 + "\n");
		
		System.out.println("Second time entered: " + timeValue2 + " which is "+ timeHour2 + " : "
				+ timeMinute2 + " : " + timeSecond2 + "\n");
					
		// Compute times in terms of seconds
		int totalSeconds1 = timeHour1 * 3600 + timeMinute1 * 60 + timeSecond1;
		int totalSeconds2 = timeHour2 * 3600 + timeMinute2 * 60 + timeSecond2;
		
		// Calculate the difference between the times in terms of seconds
		int timeDifference = totalSeconds1 - totalSeconds2;	
		
		// Isolate hours from the difference value
		int remainingDifference = timeDifference;
		int differenceHour = remainingDifference / 3600;
		remainingDifference %= 3600;
		
		// Isolate minutes from the difference value
		int differenceMinute = remainingDifference / 60;
		remainingDifference %= 60;
		
		// Isolate seconds from the difference value
		int differenceSecond = remainingDifference;
		
		// Output the difference as HHMMSS
		int formattedTimeDifference = differenceHour * 10000 + differenceMinute * 100 
				+ differenceSecond;
		System.out.println("Time difference: " + formattedTimeDifference + 
				" which is " + differenceHour + " : " + differenceMinute
				+ " : " + differenceSecond);
	}

}
