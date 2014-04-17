package gameOfLife;

/*
 * Date: 11/23/2013
 * Assignment: #8
 * Summary: Illustrate game of life
 * Solution: use two 2-D array to store the state of world
 * Assumptions: 
 * 1. Assume we have only two choices for the user, one is yes, namely to see the next generation of the world; the other is no, namely terminate the app.
 * 	  If the user entered an input other than y/n, we keep asking for the input until it is valid.
 */

import java.util.Scanner;
import java.io.*;

public class GameOfLife {	
	
	public static void main (String [] args) {
		final int M = 25;
		final int N = 75;
		
		// two 2d array to store the world's status, actual world is M*N
		char[][] world1 = new char[M + 2][N + 2];
		char[][] world2 = new char[M + 2][N + 2];

		Scanner input = new Scanner(System.in);
		Scanner fileReader = null;

		boolean inputContinue = true;
		
		// catch the file pathname and handle exception
		do{
			System.out.print ("\nWhich file do you want to open?");
			String filename = input.next();
			File file = new File(filename);			
			try {
				fileReader = new Scanner(file);	
				inputContinue = false;		// find
			} 
			catch (FileNotFoundException e) {		// not find
				System.out.print("file " + file + " dopes not exisit");
			}
		} while(inputContinue);
		
		// initialize the border of the worlds
		for(int j = 0; j <= N + 1; j++){
			world1[0][j] = '.';
			world1[M + 1][j] = '.';
			world2[0][j] = '.';
			world2[M + 1][j] = '.';
		}	
		for(int i = 1; i <= M + 1; i++){
			world1[i][0] = '.';
			world1[i][N + 1] = '.';
			world2[i][0] = '.';
			world2[i][N + 1] = '.';
		}
		
		// read the file into the 2d array
		for (int i = 1; i <= M; i++) {
			char[] line = fileReader.nextLine().toCharArray();
			for(int j = 1; j <= N; j++)		
				world1[i][j] = line[j - 1];
		}
		
		System.out.println("The original(0) generation of world is\n");
		printWorld(world1);
		
		// prompt the user to start the game
		char choice = ' ';
		int generation = 0;
		do {
			System.out.println("Would you like to see the next generation?\n - y for Yes, n for no.");
			choice = input.next().toLowerCase().charAt(0);
		}while(choice != 'y' && choice != 'n');
		
		while(choice != 'n') {
			
			// get the next generation
			generation++;
			world2 = nextGeneration(world1);
			
			// check if the world is empty
			if ( isEmpty(world2) ) {
				System.out.println("World of generation " +  generation + " is empty, game over.\n");
				printWorld(world2);
				System.exit(0);
			}
			
			// check if the world is the same with the former world
			else if ( isSame(world1, world2)) {
				System.out.println("World of generation " + generation + " is the same as the former world, game over.\n");
				printWorld(world2);
				System.exit(0);
			}
			
			// generate the next world
			else {
				System.out.println("World of generation " + generation + ":\n");
				printWorld(world2);
			}
				
			// make world1 the newest world
			char[][] temp;			
			temp = world2;			
			world1 = temp;
			
			// prompt the user to continue the game
			do {
				System.out.println("Would you like to see the next generation?\n - y for Yes, n for no.");
				choice = input.next().toLowerCase().charAt(0);
			}while(choice != 'y' && choice != 'n');
		}	
	}
	
	// return true if the world have no life
	public static boolean isEmpty(char[][] world) {
		for(int i = 1; i <= world.length - 2 ; i++)
			for(int j = 1; j <= world[0].length - 2; j++)
				if(world[i][j] == 'X') return false;
		return true;
	}
	
	// return true if the two worlds are the same
	public static boolean isSame(char[][] world1, char[][] world2) {
		for(int i = 1; i <= world1.length - 2; i++)
			for(int j = 1; j <= world1[0].length - 2; j++)
				if(world1[i][j] != world2[i][j]) return false;
		return true;
	}
	
	// get the number of neighbers of a cell in the world
	public static int numOfNeighbers(char[][] world, int x, int y) {
		int numberOfNeighbers = 0;
		for (int i = x - 1; i <= x + 1; i++){
			for(int j = y - 1; j <= y + 1; j++){
				if( i == x && j == y) continue;
				else if( world[i][j] == 'X')
					numberOfNeighbers++;
			}
		}
		return numberOfNeighbers;
	}
	
	// get the next generation of the world
	public static char[][] nextGeneration(char[][] world) {
		// initialize a char[][] to have the next world status
		char[][] nextWorld = new char[world.length][world[0].length];
		
		// go through M x N world
		for( int i = 1; i <= world.length - 2; i++) {
			for(int j = 1; j <= world[0].length - 2; j++){
				// for the cells that alive, check neighbors to see if it survives
				if(world[i][j] == 'X') {
					if( numOfNeighbers(world, i, j) == 2 || numOfNeighbers(world, i, j) == 3)
						nextWorld[i][j] = 'X';
					else
						nextWorld[i][j] = '.';
				}
				// for the cells that vacant, check neighbors to see if it becomes alive
				if(world[i][j] == '.') {
					if ( numOfNeighbers(world, i, j) == 3)
						nextWorld[i][j] = 'X';
					else
						nextWorld[i][j] = '.';
				}
			}
		}		
		return nextWorld;
	}
	
	public static void printWorld(char[][] world) {	
		for(int i = 1; i <= world.length - 2; i++){
			for(int j = 1; j <= world[i].length - 2; j++)
				System.out.print(world[i][j]);
			System.out.println();
		}
	}
}
