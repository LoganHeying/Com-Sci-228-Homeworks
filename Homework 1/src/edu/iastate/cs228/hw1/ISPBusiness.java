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
		
		for(int i = 0; i < tOld.getLength(); i++)
		{
			for(int j = 0; j < tOld.getWidth(); j++)
			{
				tOld.getTown()[i][j].census(tOld.getTown()[i][j].nCensus);
				tNew.addCell(tOld.getTown()[i][j].next(tNew), i, j);
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) 
	{
		int profit = 0;
		for(int i = 0; i < town.getLength(); i++)
		{
			for(int j = 0; j < town.getWidth(); j++)
			{
				if(town.getTown()[i][j].who().equals(State.CASUAL))
				{
					profit++;
				}
			}
		}
		//System.out.println("Profit = " + profit);
		return profit;
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
		int months = 12;
		
		if(choice == 1)
		{
			System.out.print("Please enter file path: ");
			String filename = s.next();
			s.close();
			Town t;
			try {
				t = new Town(filename);
			} 
			catch (FileNotFoundException e) {
				System.out.print("The file doesn't exist, please try again");
				return;
			}
	
			//System.out.println(t.toString());
			simulate(t, months);
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
			simulate(t, months);
			
		}
		else
		{
			System.out.println("ERROR: Choice Input Not Valid, Enter 1 or 2\n");
		}
		s.close();
	}
	
	//TODO: Write Documentation
	private static void simulate(Town start, int months)
	{
		int rows = start.getLength();
		int cols = start.getWidth();
		int maxProfit = rows * cols * months; 
		int totalProfit = 0; 
		Town[] towns = new Town[months];
		
		towns[0] = start;
		totalProfit += getProfit(towns[0]);
		
		for(int i = 1; i < months; i++)
		{
			towns[i] = updatePlain(towns[i-1]);
			totalProfit += getProfit(towns[i]);
		}
		
		double profitUtil = ((double)totalProfit/(double)maxProfit) * 100;
		
		System.out.printf("%.2f%%", profitUtil);
	}
}
