/* Name: Chen Zhu
 * UID: N12166205
 * Date: 11/06/2013
 * Assignment: #6
 * Summary: Simulate 10 car that can turn on/off the ignition, and move.
 * Solution: Car class defined with a list of attributes described in homework
 * Assumptions: 
 * 1. Car class only have one default constructor, to instantiate supposed properties
 * 2. I have a final variable called RANGE_OF_GRID to indicate the grid
 */

public class Car1 {

	private String color;
	private boolean ignition;
	private int x;
	private int y;
	public static final int RANGE_OF_GRID = 20;
	
	public Car1() {
		color = colorAssignment();
		ignition = false;
		x = getRandomPosition();
		y = getRandomPosition();
	}
	
	// getRandomPosition is used to get a random number as car position
	public int getRandomPosition(){
		return (int)(Math.random() * 20 + 1);		
	}
	
	// colorAssignment is used to set random color of the car
	public String colorAssignment(){		
		String [] color = {"Red", "Green", "Blue", "White", "Silver"};
		int index = (int)(Math.random() * 5);
		return color[index];		
	}
	
	// changeIgnitionState is used to change ignition state
	public void changeIgnitionStatus(boolean state){
		ignition = !state;
	}
	
	// moveCarHorizontally is used to move car to a horizontal position
	public void moveCarHorizontally(boolean ignitionState, int distance){		
		// Verify the ignition is on
		if (ignition) {

			// Verify the position is within border
			if ( x + distance < 1 || x + distance > 20)
				System.out.println("Out of border!Can't move the car\n");
			else 
				x += distance;
		}
		else
			System.out.println("\nIgnition is not turned on yet! Cant move the car\n");
	}
	
	// moveCarVertically is used to move car to a vertical position
	public void moveCarVertically(boolean ignitionState, int distance){			
		// Verify the ignition is on
		if (ignition) {
			
			// Verify the position entered within border
			if ( y + distance < 1 || y + distance > 20)
				System.out.println("\nOut of border! Cant move the car!");
			else 
				y += distance;
		}
		else
			System.out.println("\nIgnition is not turned on yet! Cant move the car\n");
	}
	
	// printCarState method is used to print car state
	public String toString(){		
		// get the ignition state
		String igState = "";
		if (ignition) igState += "On";
		else igState = "Off";	
		
		String carStatus = "Car" + " Status:" + "\nColor: " + this.getColor() + "\nIgnition: " + igState + "\nLocation: " + x +
				" , " + y + " \n" ;	
		
		for (int i = 1; i <= RANGE_OF_GRID; i++){		
			for(int j = 1; j <= RANGE_OF_GRID; j++){
				if (j == x && i == y) 
					carStatus += " " + this.getColor().charAt(0) + " ";
				else 
					carStatus += " " + "-" + " ";
			}
			carStatus += "\n";
		}
		
		return carStatus;	
	}
	
	public String getColor() {
		return color;
	}
	
	public boolean getIgnitionStatus() {
		return ignition;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
