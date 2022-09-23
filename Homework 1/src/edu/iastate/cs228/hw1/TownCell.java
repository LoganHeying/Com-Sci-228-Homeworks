package edu.iastate.cs228.hw1;
/**
 * 
 * @author Logan Heying
 *
 * The abstract town cell class 
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
	
	
	/**
	 * Determines what type of cell to be added in the census function
	 * 
	 * @param c the cell being checked
	 * @return the integer index used for the census
	 */
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

	/**
	 * Returns the row position of the cell.
	 * 
	 * @return row
	 */
	public int getRow()
	{
		return this.row;
	}
	
	/**
	 * Returns the column position of the cell.
	 * 
	 * @return col
	 */
	public int getCol()
	{
		return this.col;
	}
	
	
	/**
	 * A test function that will print the contents of one cell's census data
	 * @return s To be printed
	 */
	public String printCensus()
	{
		String s = "Reseller - " + TownCell.nCensus[RESELLER];
		s += "\nEmpty - " + TownCell.nCensus[EMPTY];
		s += "\nCasual - " + TownCell.nCensus[CASUAL];
		s += "\nOutage - " + TownCell.nCensus[OUTAGE];
		s += "\nStreamer - " + TownCell.nCensus[STREAMER];
		return s;
	}
}
