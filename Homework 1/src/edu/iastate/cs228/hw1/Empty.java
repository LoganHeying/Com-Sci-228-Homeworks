package edu.iastate.cs228.hw1;

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
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		if(TownCell.nCensus[EMPTY] == 0 && TownCell.nCensus[OUTAGE] == 0)
		{
			return new Reseller(tNew, super.row, super.col);
		}
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		else if(TownCell.nCensus[CASUAL] >= 5)
		{
			return new Streamer(tNew, super.row, super.col);
		}
		//default, Cell becomes C
		else
		{
			return new Casual(tNew, super.row, super.col);
		}
	}
}
