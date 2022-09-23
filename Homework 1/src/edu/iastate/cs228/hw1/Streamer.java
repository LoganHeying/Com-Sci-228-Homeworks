package edu.iastate.cs228.hw1;

/**
 * @author Logan Heying
 *
 * The streamer town cell type
 */
public class Streamer extends TownCell{

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
	}
	
	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell result = null;
		
		//Rule 2.a, nCensus[RESELLER] >= 1, Cell becomes O
		if(TownCell.nCensus[RESELLER] >= 1)
		{
			result = null;
			result = new Outage(tNew, super.row, super.col);
		}
		//Rule 2.b, nCensus[OUTAGE] >= 1, Cell becomes E
		else if(TownCell.nCensus[OUTAGE] >= 1)
		{
			result = null;
			result = new Empty(tNew, super.row, super.col);
		}
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		if((TownCell.nCensus[EMPTY] + TownCell.nCensus[OUTAGE]) <= 1)
		{
			result = null;
			result = new Reseller(tNew, super.row, super.col);
		}
		//default, Cell remains unchanged
		else if(result == null)
		{
			//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
			if(TownCell.nCensus[CASUAL] >= 5)
			{
				result = new Streamer(tNew, super.row, super.col);
			}
			else
			{
				result = new Streamer(tNew, super.row, super.col);
			}
		}
		
		return result;
	}
}
