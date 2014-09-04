/* Name: Chen Zhu
 * UID: N12166205
 * Date: 11/06/2013
 * Assignment: #6
 * Summary: Simulate 10 car that can turn on/off the ignition, and move.
 * Solution: use array of Car objects to illustrate 10 cars
 * Assumptions: 
 * 1. the user knows there are only 10 cars, cannot use >=11th cars, cause it will cause an exception
 * 2. assume the user's input corresponds with the data type we intended. so that nextInt() will not make program abort abruptly
 * 3. assume to print the car status before every operation of car
 * 4. once we meet a collision of input, we come back to the first question which asks to pick a car
 */

import java.util.Scanner;

public class TestCar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// instantiate 10 cars as object
		Car1[] car = new Car1[10];
		
		// initialize 10 cars using default constructor
		for(int i = 0; i < car.length; i++)
			car[i] = new Car1();
		
		int choice = 0;
		int num;
		
		System.out.println("What would you like to use next(1 - 10) cars?");
		num = input.nextInt();
		
		// ask actions about selected car
		System.out.print(" What would you like to do for car#" + num + "?\n1: turn the ignition on/off \n"
				+ "2: change the position of car\n3: quit this program\n");
		choice = input.nextInt(); 

		// start the program
		while ( choice != 3 ){
	
			// get the correct index
			int index = num - 1;  
		
			// start operating the car
			switch (choice) {
			
				// Turn on/off ignition
				case 1:
					car[index].changeIgnitionStatus(car[index].getIgnitionStatus());
					System.out.println("#" + num + " " + car[index]);
					break;
			
				// Get & verify direction and move car correspondingly
				case 2:
					System.out.println("\nIn which direction would you like to move the car?\n1: horizontal\n2: vertical");
					int direction = input.nextInt();
				
					// verify direction
					if (direction !=1 && direction !=2)
						System.out.println("Invalid direction!\n");
					else {
						// if direction is valid, get the distance
						System.out.println("\nHow far? (negative valut to move left)");
						int distance = input.nextInt();
					
						if(direction == 1) {
							car[index].moveCarHorizontally(car[index].getIgnitionStatus(), distance); 
							System.out.println("#" + num + " " + car[index]);
						}
						if (direction == 2) {
							car[index].moveCarVertically(car[index].getIgnitionStatus(), distance);
							System.out.println("#" + num + " " + car[index]);
						}			
					}						
					break;
	
				default:
					System.out.println("\nYou entered an invalid input!");
			}
			
			System.out.println("What would you like to use next(1 - 10) cars?");
			num = input.nextInt();
			
			// ask actions about selected car
			System.out.print(" What would you like to do for car#" + num + "?\n1: turn the ignition on/off \n"
					+ "2: change the position of car\n3: quit this program\n");
			choice = input.nextInt(); 

		}		
	}
}
