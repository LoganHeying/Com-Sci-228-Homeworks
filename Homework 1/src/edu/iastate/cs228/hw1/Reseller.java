package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell result = null;
		
		//Rule 3.a, nCensus[CASUAL] <= 3, Cell becomes E
		if(TownCell.nCensus[CASUAL] <= 3)
		{
			result = null;
			result = new Empty(tNew, super.row, super.col);
		}
		//Rule 3.b, nCensus[EMPTY]+[OUTAGE] >= 3, Cell becomes E
		else if((TownCell.nCensus[EMPTY] + TownCell.nCensus[OUTAGE]) >= 3)
		{
			result = null;
			result = new Empty(tNew, super.row, super.col);
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
				result = new Reseller(tNew, super.row, super.col);
			}
		}
		
		return result;
	}
}
