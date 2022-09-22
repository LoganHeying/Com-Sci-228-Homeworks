package edu.iastate.cs228.hw1;

public class Casual extends TownCell{

	public Casual(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		//Rule 1.a, nCensus[RESELLER] >= 1, Cell becomes O
		if(TownCell.nCensus[RESELLER] >= 1)
		{
			return new Outage(tNew, super.row, super.col);
		}
		//Rule 1.b, nCensus[STREAMER] >= 1, Cell becomes S
		else if(TownCell.nCensus[STREAMER] >= 1)
		{
			return new Streamer(tNew, super.row, super.col);
		}
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		else if(this.nCensus[EMPTY] == 0 && this.nCensus[OUTAGE] == 0)
		{
			return new Reseller(tNew, super.row, super.col);
		}
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		else if(TownCell.nCensus[CASUAL] >= 5)
		{
			return new Streamer(tNew, super.row, super.col);
		}
		//default, Cell remains unchanged
		else
		{
			return new Casual(tNew, super.row, super.col);
		}
	}

}
