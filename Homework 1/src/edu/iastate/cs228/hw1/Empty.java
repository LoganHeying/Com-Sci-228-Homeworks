package edu.iastate.cs228.hw1;

/**
 * @author Logan Heying
 *
 * The empty town type class
 */
public class Empty extends TownCell {

	public Empty(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell result = null;
		
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		if((TownCell.nCensus[EMPTY] + TownCell.nCensus[OUTAGE]) <= 1)
		{
			result = null;
			result = new Reseller(tNew, super.row, super.col);
		}
		//default, Cell becomes C
		else if(result == null)
		{
			result = new Casual(tNew, super.row, super.col);
		}
		
		return result;
	}
}
