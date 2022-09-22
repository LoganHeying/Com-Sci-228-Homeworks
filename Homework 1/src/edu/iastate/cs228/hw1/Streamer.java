package edu.iastate.cs228.hw1;

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
		//Rule 2.a, nCensus[RESELLER] >= 1, Cell becomes O
		if(TownCell.nCensus[RESELLER] >= 1)
		{
			return new Outage(tNew, super.row, super.col);
		}
		//Rule 2.b, nCensus[OUTAGE] >= 1, Cell becomes E
		else if(TownCell.nCensus[OUTAGE] >= 1)
		{
			return new Empty(tNew, super.row, super.col);
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
			return new Streamer(tNew, super.row, super.col);
		}
	}
}
