package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Write your name here>>
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) 
	{
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//TODO: Write your code here.
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) 
	{
		//TODO: Write/update your code here.
		return 0;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("How to populate grid (type 1 or 2); 1: From a file. 2: randomly with seed");
		
		int choice = s.nextInt();
		
		if(choice == 1)
		{
			System.out.println("Will Read the File given. TODO");
		}
		else if(choice == 2)
		{
			System.out.println("Provide rows, cols, and seed integer separated by space: ");
			int rows = s.nextInt();
			int cols = s.nextInt();
			int seed = s.nextInt();
			s.close();
			Town t = new Town(rows, cols);
			t.randomInit(seed);
			System.out.println(t.toString());
			
			t.censusAll(rows, cols);
		}
		else
		{
			System.out.println("ERROR: Choice Input Not Valid, Enter 1 or 2\n");
		}
	}
}
