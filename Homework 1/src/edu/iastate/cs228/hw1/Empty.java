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
		if(this.nCensus[EMPTY] + this.nCensus[OUTAGE] <= 1)
		{
			return new Reseller(tNew, super.row, super.col);
		}
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		else if(this.nCensus[CASUAL] >= 5)
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
