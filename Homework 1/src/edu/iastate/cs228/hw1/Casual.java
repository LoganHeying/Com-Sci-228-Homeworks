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
		//Rule 1.b, nCensus[STREAMER] >= 1, Cell becomes S
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		//else, Cell remains unchanged
		return null;
	}

}
