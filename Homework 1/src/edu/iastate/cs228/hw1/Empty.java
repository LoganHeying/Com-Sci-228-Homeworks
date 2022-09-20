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
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		//default, Cell becomes C
		return null;
	}
}
