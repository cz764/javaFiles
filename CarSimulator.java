/*
 * Name: Chen Zhu
 * UID: N12166205
 * Date: 09/25/2013
 * Assignment: #3
 * Summary: Simulate a car that can turn on/off the ignition, and move.
 * Solution: 6 methods: getRandomPosition is used to generate an initial random position of a car;
 * 			colorAssignment is used to assign random color to the car;
 * 			changeIgnitionState is used to turn on/off car ignition;
 * 			moveCarHorizontally/ moveCarVertically are used to move car horizontally and vertically;
 * 			printCarState is used to print car state per user's command;
 */

import java.util.Scanner;

public class CarSimulator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Set initial ignition to false
		boolean ignitionState = false;
		
		// Set random position
		int x = getRandomPosition(), y = getRandomPosition();
		
		// Set a random color
		char carColor = colorAssignment();
		
		printCarState(ignitionState, carColor, x, y);
		
		// Set initial choice not equals 'q'
		char choice = 'a';
		
		while ( choice != 'Q'){
			
			// Prompt to the user next steps and verify
			System.out.println("What would you like to do?");
			System.out.print(" 1: turn the ignition on/off \n 2: change the position of car\n q: quit this program");
			choice = input.next().toUpperCase().charAt(0); // get the user choice
		
			// Get user's choice and continue each step
			switch (choice) {
			
			// Turn on/off ignition
			case '1':
				ignitionState = changeIgnitionState(ignitionState);
				printCarState(ignitionState, carColor, x, y);
				break;
			
			// Get & verify direction and enter each method
			case '2':
				System.out.println("\nIn which direction would you like to move the car?\nH: horizontal\nV: vertical");
				char direction = input.next().toUpperCase().charAt(0);
				
				if (direction == 'H'){
					x = moveCarHorizontally(ignitionState, x);
					printCarState(ignitionState, carColor, x, y);
				}
				
				else if (direction == 'V'){
					y = moveCarVertically(ignitionState, y);
					printCarState(ignitionState, carColor, x, y);
				}
				else System.out.println("Invalid direction!\n");
					
				break;
				
			case 'Q':
				break;
			
			default:
				System.out.println("\nYou entered an invalid input!");
			}

		}
		
	}
	
	// getRandomPosition is used to get a random number as car position
	public static int getRandomPosition(){
		return (int)(Math.random() * 20 + 1);		
	}
	
	// colorAssignment is used to set random color of the car
	public static char colorAssignment(){
		
		char [] color = {'R', 'G', 'B', 'W', 'S'};
		int index = (int)(Math.random() * 5);
		return color[index];
		
	}
	
	// changeIgnitionState is used to change ignition state
	public static boolean changeIgnitionState(boolean state){
		if (state == true) return false;
		else return true;
	}
	
	// moveCarHorizontally is used to move car to a horizontal position
	public static int moveCarHorizontally(boolean ignitionState, int x){
		
		Scanner input = new Scanner(System.in);
		int posHorizontal = x;
		
		// Verify the ignition is on
		if (ignitionState) {
			
			System.out.println("\nHow far? (negative value to move left)");
			int step = input.nextInt();
			
			// Verify the position entered within border
			if ( x + step < 1 || x + step > 20)
				System.out.println("Out of border!");
			else posHorizontal = x + step;
		}
		else
			System.out.println("\nIgnition is not turned on yet! Cant move!");
		
		return posHorizontal;
	}
	
	// moveCarVertically is used to move car to a vertical position
	public static int moveCarVertically(boolean ignitionState, int y){
		
		Scanner input = new Scanner(System.in);
		int posVertical = y;
		
		// Verify the ignition is on
		if (ignitionState) {
			
			System.out.println("\nHow far? (negative value to move left)");
			int step = input.nextInt();
			
			// Verify the position entered within border
			if ( y + step < 1 || y + step > 20)
				System.out.println("\nOut of border!");
			else posVertical = y + step;
		}
		else
			System.out.println("\nIgnition is not turned on yet! Cant move!");
		
		return posVertical;
		
	}
	
	// printCarState method is used to print car state
	public static void printCarState(boolean ignitionState, char carColor, int posHorizontal, int posVertical){
		
		// get the ignition state
		String igState = "";
		if (ignitionState) igState += "On";
		else igState = "Off";
		
		// get color name
		String color = "";
		switch (carColor){
		
		case 'B':
			color += "Blue";
			break;
		case 'R':
			color += "Red";
			break;
		case 'G':
			color += "Green";
			break;
		case 'W':
			color += "White";
			break;
		case 'S':
			color += "Silver";
			break;
			
		}
		
		System.out.println("\nCar Information");
		System.out.print("Color: " + color + "\n" + "Ignition: " + igState + "\n" + "Location: " + "( " + posHorizontal +
				" , " + posVertical + " )\n");
		
		for (int i = 1; i <= 20; i++){		
			for(int j = 1; j <=20; j++){
				if (j == posHorizontal && i == posVertical) System.out.print(" " + carColor + " ");
				else System.out.print(" " + "-" + " ");
			}
			System.out.println();
		}
		
	}

}
