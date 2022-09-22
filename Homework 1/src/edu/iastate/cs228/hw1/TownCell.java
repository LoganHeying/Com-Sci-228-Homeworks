package edu.iastate.cs228.hw1;
/**
 * 
 * @author <<Write your name here>>
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		//All non-border cells 
		try {
		nCensus[checkCell(plain.getTown()[row-1][col-1])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row-1) + " " + (col-1) + " Doesn't exist or is null");
		}

		
		try {
		nCensus[checkCell(plain.getTown()[row-1][col])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row-1) + " " + (col) + " Doesn't exist or is null");
		}
		
		try {
		nCensus[checkCell(plain.getTown()[row-1][col+1])]++;
		}		
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row-1) + " " + (col+1) + " Doesn't exist or is null");
		}
		
		try {
		nCensus[checkCell(plain.getTown()[row][col-1])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row) + " " + (col-1) + " Doesn't exist or is null");
		}
		
		try {
		nCensus[checkCell(plain.getTown()[row][col+1])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row) + " " + (col+1) + " Doesn't exist or is null");
		}
		
		try {
		nCensus[checkCell(plain.getTown()[row+1][col-1])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row+1) + " " + (col-1) + " Doesn't exist or is null");
		}
		
		try {
		nCensus[checkCell(plain.getTown()[row+1][col])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row+1) + " " + (col) + " Doesn't exist or is null");
		}
		
		try {
		nCensus[checkCell(plain.getTown()[row+1][col+1])]++;
		}
		catch(IndexOutOfBoundsException e)
		{
			//System.out.println("Cell - " + (row+1) + " " + (col+1) + " Doesn't exist or is null");
		}
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
	
	//TODO: Write Documentation
	public static int checkCell(TownCell c)
	{
		State state = c.who();
		
		switch(state)
		{
		case EMPTY:
			return EMPTY;
		case CASUAL:
			return CASUAL;
		case RESELLER:
			return RESELLER;
		case OUTAGE:
			return OUTAGE;
		case STREAMER:
			return STREAMER;
		}
		return -1;
	}

	//TODO: Write Documentation
	public int getRow()
	{
		return this.row;
	}
	
	//TODO: Write Documentation
	public int getCol()
	{
		return this.col;
	}
	
	protected void printCensus()
	{
		System.out.println("Reseller - " + TownCell.nCensus[RESELLER]);
		System.out.println("Empty - " + TownCell.nCensus[EMPTY]);
		System.out.println("Casual - " + TownCell.nCensus[CASUAL]);
		System.out.println("Outage - " + TownCell.nCensus[OUTAGE]);
		System.out.println("Streamer - " + TownCell.nCensus[STREAMER]);
		System.out.println();
	}
}
