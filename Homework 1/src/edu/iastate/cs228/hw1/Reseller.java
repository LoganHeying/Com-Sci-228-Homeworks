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
		//Rule 3.b, nCensus[EMPTY]+[OUTAGE] >= 3, Cell becomes E
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		//else, Cell remains unchanged
		return null;
	}

}
