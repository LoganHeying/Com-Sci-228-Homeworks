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
		//Rule 3.a, nCensus[CASUAL] <= 3, Cell becomes E
		if(TownCell.nCensus[CASUAL] <= 3)
		{
			return new Empty(tNew, super.row, super.col);
		}
		//Rule 3.b, nCensus[EMPTY]+[OUTAGE] >= 3, Cell becomes E
		else if(TownCell.nCensus[EMPTY] + TownCell.nCensus[OUTAGE] >= 3)
		{
			return new Empty(tNew, super.row, super.col);
		}
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		else if(TownCell.nCensus[CASUAL] >= 5)
		{
			return new Streamer(tNew, super.row, super.col);
		}
		//default, Cell remains unchanged
		else
		{
			return new Reseller(tNew, super.row, super.col);
		}
	}
}
