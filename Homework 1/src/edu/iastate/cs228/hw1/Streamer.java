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
		//Rule 2.b, nCensus[OUTAGE] >= 1, Cell becomes E
		//Rule 6.a, nCensus[EMPTY] + [OUTAGE] <= 1, Cell becomes R
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		//else, Cell remains unchanged
		return null;
	}

}
